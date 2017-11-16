#!/bin/bash

fct_menu ()
{
	clear
echo ------------------------------ Micro Projet EJB ----------------------------
echo "Choisir un ordre"
echo "Quitter le script via (Q)"
echo
echo " Clean + install + Lancer le deployement         (1) "
echo " Lancer le Client                                (2) "

echo
echo -n "Choix > "
echo -n

read optionmenu
    case $optionmenu in
    1)
		clear
		asadmin stop-domain
		asadmin stop-database
        mvn clean install 
       	sleep 2
       	asadmin start-domain
		asadmin start-database
		asadmin undeploy microProject-bean
		asadmin deploy auctionProject_Bean/target/microProject-bean.jar
		asadmin stop-domain
		asadmin stop-database

        fct_menu ;;
    2)
		asadmin start-domain
		asadmin start-database
        cd auctionProject_Client
		java -classpath $CLASSPATH:../auctionProject_Bean/target/microProject-bean.jar:target/auctionProject_Client-0.0.1-SNAPSHOT.jar client.Client
		sleep 8
		cd ..
		
	exit ;;	
        
   
    Q)
        exit ;;
    *)
        echo
        echo "Erreur de frappe "
        echo
        fct_menu ;;
        esac
}
fct_menu
