//java -classpath $CLASSPATH:../auctionProject_Bean/target/microProject-bean.jar:target/auctionProject_Client-0.0.1-SNAPSHOT.jar client.Client

package client;

import javax.naming.InitialContext;

import api.interAdminClient;
import entity.Objets;

//import entity.User;

public class Client {

	public static void main(String[] args) {

		interAdminClient cl ;
		//User u;
		
        try {
		InitialContext ic = new InitialContext();
		cl = (interAdminClient) ic.lookup("api.interAdminClient");
		System.out.println("Inserting Things.. " + cl.creatTable());
		Objets c = new Objets();
		System.out.println(c.getPrice());

	} catch(Exception e) {
		e.printStackTrace();	
	}

	}
	
}

