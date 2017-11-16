//java -classpath $CLASSPATH:../auctionProject_Bean/target/microProject-bean.jar:target/auctionProject_Client-0.0.1-SNAPSHOT.jar client.Client

package client;
import javax.naming.InitialContext;

import api.AuctionClient;
import api.interAdminClient;
import entity.Auction;
import entity.Objet;
import entity.ParentOU;
import entity.User;

//import entity.User;

public class Client {

	public static void main(String[] args) {

		interAdminClient cl ;
		AuctionClient a1;
	//----------------------------------------------------------------------	
		User usr = new User();
		usr.setPseudo("yassine");
		usr.setCodep(10);
		usr.setEmail("a@b.c");
		usr.setFn("yassine");
		usr.setLn("zinabi");
		usr.setSell_rights(false);
		
		User usr1 = new User();
		usr1.setPseudo("simo");
		usr1.setCodep(10);
		usr1.setEmail("a@b.c");
		usr1.setFn("mohamed");
		usr1.setLn("T.I.B.A");
		usr1.setSell_rights(true);
		
		User usrremove=new User();
		usrremove.setPseudo("jean-pierre");
		usrremove.setCodep(12);
		usrremove.setEmail("jean@gmail.com");
		usrremove.setFn("jean");
		usrremove.setLn("l7ajra");
		usrremove.setSell_rights(true);
		
		
	//-------------------------------------------------------------------	
		Objet obj1=new Objet();
		obj1.setId("1");
		obj1.setInc_prop(10);
		obj1.setId_vendor(usr1);
		
		
		Objet obj2=new Objet();
		obj2.setId_vendor(usr1);
		obj2.setId("2");
		
		Objet obj3=new Objet();
		obj3.setId_vendor(usr1);
		obj3.setId("3");
		
		Objet obj4=new Objet();
		obj4.setId_vendor(usr1);
		obj4.setId("4");
		
		Objet obj5=new Objet();
		obj5.setId_vendor(usr1);
		obj5.setId("5");
		
		Objet obj6=new Objet();
		obj6.setId_vendor(usr1);
		obj6.setId("6");
		
		Objet obj7=new Objet();
		obj7.setId_vendor(null);
		obj7.setId("7");
		
		Objet objremove =new Objet();
		objremove.setId("remove");
		objremove.setId_vendor(usrremove);
		//objet avec proprio sans droit de vente
		Objet obj8 =new Objet();
		obj8.setId_vendor(usr);
		obj8.setId("8");
		
		
		
		Auction auct1=Auction.creerAuction("1", obj1,100);
		Auction auct2=Auction.creerAuction("2", obj2,200);
		Auction auct3=Auction.creerAuction("3", obj3,300);
		Auction auct4=Auction.creerAuction("4", obj4,400);
		Auction auct5=Auction.creerAuction("5", obj5,500);
		Auction auct6=Auction.creerAuction("6", obj6,600);
		Auction auct7=Auction.creerAuction("7", obj1,600);
		Auction auct8=Auction.creerAuction("8", obj8,800);
		
		

		
		
		
		

		
		
		
        try {
		InitialContext ic = new InitialContext();
		cl = (interAdminClient) ic.lookup("api.interAdminClient");
		a1=(AuctionClient)ic.lookup("api.AuctionClient");
		
		
		
		
System.out.println("\n-----------------------partie Ajout utilisateur-------------------------------");
		System.out.println(cl.add(usr));
		System.out.println(cl.add(usr1));
		System.out.println(cl.add(usr));
		
		System.out.println(cl.add(usrremove));
		
		System.out.println("\n\t-----------------------partie Ajout Obj-------------------------------");
		System.out.println(cl.add(obj1));
		System.out.println(cl.add(obj2));
		System.out.println(cl.add(obj3));
		System.out.println(cl.add(obj4));
		System.out.println(cl.add(obj5));
		System.out.println(cl.add(obj6));
		//objets sans proprio
		System.out.println(cl.add(obj7));
		System.out.println(cl.add(objremove));
		System.out.println(cl.add(obj8));
		
		
System.out.println("\n-----------------------partie affichage-------------------------------");
		for(ParentOU s:cl.showall("User")) {
			System.out.println(s.toString());
		}
		
		
		for(ParentOU s:cl.showall("Objet")) {
			System.out.println(s.toString());
		}
System.out.println("\n-----------------------partie suppression d'un user-------------------------------");
		
	System.out.println(cl.remove(usrremove.getPseudo(),"User"));
	
	System.out.println("\n-----------------------partie affichage apres supression-------------------------------");
	for(ParentOU s:cl.showall("User")) {
		System.out.println(s.toString());
	}
	//supression de l'objet objremove de userremove par effet cascade
	
	for(ParentOU s:cl.showall("Objet")) {
		System.out.println(s.toString());
	}
	
	
	
	
	
System.out.println("\n------------------Update---------------------------------");

usr.setLn("ZINABI Test Mise A Jour !!");
obj3.setDesc("Test description MAJ");
objremove.setDesc("blbllblb");
usrremove.setLn("blblbllb");
System.out.println(cl.update(obj3));
System.out.println(cl.update(usr));
//modification des instances supprimées ultérieurement
System.out.println(cl.update(usrremove));
System.out.println(cl.update(objremove));


		
	

System.out.println("\n-----------------------Partie affichage aprés Update-------------------------------");
		for(ParentOU s:cl.showall("User")) {
			System.out.println(s);
			
		}
		
for(ParentOU s:cl.showall("Objet")) {
	System.out.println(s.toString());
}
		


System.out.println("\n--------------------------------Auction----------------");
//System.out.println(Color.RED+auct1.getState());
System.out.println(a1.startAuction(auct1));
System.out.println(a1.startAuction(auct2));
System.out.println(a1.startAuction(auct3));
System.out.println(a1.startAuction(auct4));
System.out.println(a1.startAuction(auct5));
System.out.println(a1.startAuction(auct6));
System.out.println(a1.startAuction(auct7));
System.out.println(a1.startAuction(auct8));

auct1 =a1.UpdateAuction(auct1);
auct2 =a1.UpdateAuction(auct2);
auct3 =a1.UpdateAuction(auct3);
auct4 =a1.UpdateAuction(auct4);
auct5 =a1.UpdateAuction(auct5);






System.out.println("auct: "+auct1.getId()+" etat: "+auct1.getState());
System.out.println("auct: "+auct2.getId()+" etat: "+auct2.getState());
System.out.println("auct: "+auct3.getId()+" etat: "+auct3.getState());
System.out.println("auct: "+auct4.getId()+" etat: "+auct4.getState());
System.out.println("auct: "+auct5.getId()+" etat: "+auct5.getState());
System.out.println("auct: "+auct6.getId()+" etat: "+auct6.getState());

//------------close d'une auction----------------------------------



System.out.println("\n-----test de triche-----------");
System.out.println(a1.Bids(usr1, auct1));


System.out.println(a1.closeAuction(auct8));


System.out.println(a1.Bids(usr, auct1));
System.out.println("-------------------------------------test bid puis close-----------");
auct1 = a1.UpdateAuction(auct1);
System.out.println(auct1.toString());
System.out.println(a1.closeAuction(auct1));



	} catch(Exception e) {
		e.printStackTrace();	
	}

	}
	
}

