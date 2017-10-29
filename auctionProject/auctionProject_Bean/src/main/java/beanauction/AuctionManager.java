package beanauction;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import api.AuctionClient;
import bean.AdminClient;
import entity.Auction;
import entity.User;


@Stateless
public class AuctionManager implements AuctionClient {

	AdminClient adm = null;
	
	@PersistenceContext(unitName = "unit1")
	private EntityManager em;
	
	 private static final String JPQL_SELECT_BY_ID = "SELECT * FROM OBJET WHERE id=:ID";
	 private static final String PARAM_ID= "ID";
	
	public boolean startAuction(Auction au) {
		/*try {
			if(au.getObj()== adm.findObject(au.getObj().getId())){
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		au.setState("Started");*/
		return false;
	}

	public void closeAuction(Auction au) {
		// TODO Auto-generated method stub
		
	}

	public void Bids(int b) {
		// TODO Auto-generated method stub
		
	}

/*	private Object findObject(int ID) throws SQLException {
		User c=null;
		Query requete = em.createQuery( JPQL_SELECT_BY_ID );
        requete.setParameter( PARAM_ID, ID );
        
		return (User)requete.getSingleResult() ;
		
	}*/
	
	
	
}
