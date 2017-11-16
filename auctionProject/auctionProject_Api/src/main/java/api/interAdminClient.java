package api;


import java.util.List;

import javax.ejb.Remote;


import entity.Objet;
import entity.ParentOU;
 




@Remote 
public interface interAdminClient {
	public List<ParentOU> showall(String s);
	public String add(ParentOU p) ;
	public String remove (String u,String table);
	public String update (ParentOU u);
	public String lookuprights (ParentOU u);
	public Objet getObjet(String i); 
	 
}
