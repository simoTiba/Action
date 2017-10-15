package bean;

import javax.ejb.Stateless;
import javax.persistence.*;

import api.interAdminClient;
import entity.ParentOU;
import entity.User;
import entity.object;




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
		
		object obj = new object();
		obj.setId("1");
		obj.setPrice(120);
		obj.setSeel_statut(false);
		
		em.persist(obj);

		return "ok";
	}

}
