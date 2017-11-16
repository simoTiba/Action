package bean;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;


import api.interAdminClient;
import entity.ParentOU;
import entity.User;
import entity.Objet;




@Stateless
public class DirectoryManager implements interAdminClient{
	/**
	 * the reference to the entity manager, which persistence context is "unit1".
	 */
	@PersistenceContext(unitName = "unit1")
	private EntityManager em;
	
	
	// --------------------------ADD------------------------------
	
	public String add(ParentOU p) {
		// si c'est un client on persiste
		if(p.getClass().getName().equals("entity.User")) {
			User u =(User)p;
			if(em.find(User.class,u.getPseudo())==null)
			em.persist(u);
			else 
				return "l'utilisateur existe déja";
		return "utilisateur ajouté";}
		//si c'est un objet
		else if(p.getClass().getName().equals("entity.Objet")){
			Objet o = (Objet)p;
			//si l'objet a un proprio et ce proprio existe dans la table
			
	if(o.getId_vendor()!=null && (User)em.find(User.class, o.getId_vendor().getPseudo())!=null)
			{ 
				em.persist(o);
				em.find(User.class, o.getId_vendor().getPseudo()).getListobjets().add(o);
				return "objet "+o.getId()+" est ajouté ";}
			else
				//si l'objet n'a pas de proprio
				return "objet sans proprio impossible de l'ajouter";
			}
		//si on essait d'ajouter un objet de classe differente des notres
		else
			return "impossible d'ajouter cet elements (different du shéma de la table)";		
	}

	//--------------------------REMOVE----------------------------------
	
	public String remove(String a,String table) {
		if(table.equals("User")) {
			User usr =em.find(User.class, a);
					if(usr != null) {
						em.remove(usr);
		return " Utilisateur est supprimé";}
					else
						return "l'utilisateur n'existe pas";
		}
		
		else if(table.equals("Objet")) {
			Objet obj= em.find(Objet.class, a);
			if(obj !=null) {
				em.find(User.class, obj.getId_vendor().getPseudo()).getListobjets().remove(obj);
				em.remove(obj);
			return "Objet  supprimé";
			}
			else 
				return "impossible l'objet n'existe pas";
		}
		
		return "impossible de supprimer votre objet (pas de strucuture sismilaire dans la table)  ";		
	}
		
					
	

	//------------------------------UPDATE------------------------------------
	public String update(ParentOU p) {
		if(p.getClass().getName().equals("entity.User")) {
			User u=(User) p;
			if(em.find(User.class,u.getPseudo())!=null) {
			em.merge(u);
			return "utilisateur : "+u.getPseudo()+" a été modifié";}
			else 
				return "l'utilisateur n'existe pas ou la modification souhaité est impossible";
			
		}
		else if(p.getClass().getName().equals("entity.Objet")) {
			Objet o = (Objet)p;
			if(o!=null && o.getId_vendor()!=null && (User)em.find(User.class, o.getId_vendor().getPseudo())!=null) {
				em.merge(o);
				return "objet : "+o.getId()+" a été modifié";
			}
			return "l'objet n'existe pas ou la modfication souhaité est impossible ";
	
		}
		return "pas de strucuture sismilaire dans la table impossible de modifier";
		 
	}
	
	//------------------------------LOOKUP RIGHTS--------------------------------
	
	
	
	public String lookuprights(ParentOU p) {
		
		if(p.getClass().getName().equals("entity.User")) {
			User u=(User)p;
			if(u.isSell_rights()) {
				return "oui";
			}
			else 
				return "non";	
		}
		else
			return "impossible de verifier les droit ( mauvaise entitée)";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------SHOW ALL-------------------------------

	public List<ParentOU> showall(String s) {
		if( s.equals("User")) {
			String requete ="SELECT U FROM User as U";
			Query rqt =em.createQuery(requete);
		return rqt.getResultList();
		}
		else if(s.equals("Objet")){
			String requete ="SELECT O FROM Objet as O";
			Query rqt =em.createQuery(requete);
		return rqt.getResultList();
		}
		else 
			return null;
				
		
	}
	
	
	

	public Objet getObjet(String i) {
		
		return em.find(Objet.class,i);
	}

	





}
