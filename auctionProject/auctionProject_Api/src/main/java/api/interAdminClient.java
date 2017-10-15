package api;

import javax.ejb.Remote;

import entity.ParentOU;
 




@Remote 
public interface interAdminClient {

	public String creatTable();
	
	public String add(ParentOU p) ;
	
	public String remove (ParentOU u);
	
	public void updateUr (ParentOU u);
	
}
