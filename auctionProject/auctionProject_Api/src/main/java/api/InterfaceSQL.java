package api;

public interface InterfaceSQL {
	
	public static final String Find_Objet_Sql="Select o from Objets as o where o.id=?" ;
	public static final String Insert_Objet_Sql="Insert into Objets Values"+"(idobj,des,cat,id_vendor,inc_prop,price,sell_statut)"+"(?,?,?,?,?,?,?)";
	public static final String Insert_User_Sql="Insert into User Values"+"(pseudo,fn,ln,codep,email,sell_rights)"+"(?,?,?,?,?,?)";
	
	
	
	
	

}
