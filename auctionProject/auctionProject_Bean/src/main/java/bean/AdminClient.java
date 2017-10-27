package bean;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.persistence.*;

import api.interAdminClient;
import entity.ParentOU;
import entity.User;
import entity.Objets;




@Stateless
public class AdminClient implements interAdminClient{
	/**
	 * the reference to the entity manager, which persistence context is "unit1".
	 */
	@PersistenceContext(unitName = "unit1")
	private EntityManager em;
	
	public String add(ParentOU p) {
		return "ok";
	}

	public String remove(ParentOU u) {
		return "ok";
	}

	public void updateUr(ParentOU u) {
		 
	}
	
	
	
	

	 private static final String JPQL_SELECT_BY_ID = "SELECT * FROM OBJETS WHERE id=:ID";
	 private static final String PARAM_ID= "ID";
	
	
	public Objets findObject(int ID) throws SQLException {
		User c=null;
		Query requete = em.createQuery( JPQL_SELECT_BY_ID );
        requete.setParameter( PARAM_ID, ID );
        
		return (Objets)requete.getSingleResult() ;
		
	}
	
	

	//cree la table avec qlq exemples
	public String creatTable() {
		User usr = new User();
		usr.setPseudo("Mohamed");
		usr.setCodep(10);
		usr.setEmail("a@b.c");
		usr.setLn("mohamed");
		usr.setLn("Mohamed");
		usr.setSell_rights(false);
		
		em.persist(usr);
		
		Objets obj = new Objets();
		obj.setId(1);
		obj.setPrice(120);
		obj.setSeel_statut(false);
		
		Objets obj2 = new Objets();
		try {
			obj2=this.findObject(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.persist(obj);

		return "ok";
	}

}
