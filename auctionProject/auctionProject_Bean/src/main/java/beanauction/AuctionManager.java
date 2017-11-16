package beanauction;
import java.util.List;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JList;

import api.AuctionClient;
import api.interAdminClient;

import entity.Auction;
import entity.Objet;
import entity.User;



@Stateless
public class AuctionManager implements AuctionClient {

	
	
	@PersistenceContext(unitName = "unit1")
	private EntityManager em;
	
	
	@EJB
	public interAdminClient adm ; 
	
	//-----------------------Start auction--------------------
	public String startAuction(Auction au) {
		if(exist(au)==0) {
		if(count(au)<=4) {
		em.persist(au);
		if(au.getState().equals("not started")) {
			if(adm.lookuprights(au.getVendeur()).equals("oui"))	{
				em.find(Auction.class,au.getId()).setState("active");
				return "l'enchére "+au.getId()+" a commencé avec un prix de depart de:"+au.getPrice();
				}
			else {
				
				return au.getVendeur().getPseudo()+" n'a pas le droit de vendre";
			}
		}
		else if(au.getState().equals("active")) {
			return "l'enchére a deja commencé";
			}
			else if(au.getState().equals("closed"))
				return "l'enchére est deja fini";
			else
		return "Enchére mal créer impossible de la commencer";
		}
		else 
			return au.getVendeur().getPseudo()+" a deja 5 enchéres en cours (active), impossible d'en avoir plus";
		
	}
		return "l'objet est deja en mis en enchére";
	}
	
	//-----------------fct pour faire la mise a jour coté client 
	
	
	public Auction UpdateAuction(Auction au) {
	
		
		return em.find(Auction.class, au.getId());
		}
	
	
	
	
	//---------------CLose-------------

	public String closeAuction(Auction au) {
		
		Auction c=em.find(Auction.class, au.getId());
		if(c!=null && c.getState()=="active") {
			if(c.getAcheteur()!=null) {
			c.setState("closed");
			Objet obj_new=adm.getObjet(c.getObj().getId());
			obj_new.setId_vendor(c.getAcheteur());
			obj_new.setPrice(c.getPrice());
			adm.update(obj_new);
			em.merge(c);
			return "Enchére "+c.getId()+" est terminé,merci pour la participation";
				}
			
			else 
			return "personne a voulu acheter l'objet , desolé";
				}
		else
			return "cette enchére n'existe pas ou elle est deja terminée ,impossible de la terminer";
		
		
	}
//----------------------------BIDS------------------------------------
	public String Bids(User u, Auction au) {
		
		if(em.find(Auction.class,au.getId()).getState().equals("active")) {
			if(em.find(Auction.class, au.getId()).getVendeur().getPseudo().equals(u.getPseudo())) {
				return u.getPseudo()+" est le vendeur , impossible pour le vendeur de participer a l'enchére  ";
			}
			else {
			au.setPrice(au.getPrice()+au.getObj().getInc_prop());
			au.setAcheteur(u);
			em.merge(au);
			return " "+u.getPseudo()+" est le leader de l'enchére "+au.getId()+" crée par"+au.getVendeur().getPseudo()+" avec la somme de "+au.getPrice();
			}
		}
		else
		return "erreur ( peut etre sur l 'enchére choisi)";
		
		
	}


//---------fct de count pour la contrrainte de 5 auctions max par utilisateur--------------

	public Long count(Auction au) {
		Query rqt =em.createQuery("SELECT COUNT(A.id) FROM Auction AS A WHERE A.vendeur = ?1 AND A.state = 'active' ");
				rqt.setParameter(1, au.getVendeur());
	    
				List<Long> c=rqt.getResultList();
			    
			    
				return c.get(0);	
		
	}
	
	//------------fct d'existence de l'auction dans la table auction avec un statut active -------
	
	public Long exist(Auction au) {
		Query rqt =em.createQuery("SELECT COUNT(A) FROM Auction AS A WHERE A.obj = ?1 AND A.state = 'active' ");
		rqt.setParameter(1, au.getObj());
		
		List<Long> l=rqt.getResultList();
    
	    
		return l.get(0);
		
		
		
		/*int c= rqt.getFirstResult();
	
		return c;*/
	}

	

	
	
}
