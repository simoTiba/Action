#!/bin/bash

asadmin stop-domain
asadmin stop-database
echo "--------------------------------------------------------------------------"
echo "--------------------------------------------------------------------------"
echo "---------                  Auction Projet EJB                  -----------"
echo "--------------------------------------------------------------------------"
echo "--------------------------------------------------------------------------"

sleep 4
clear

echo "---------                1 - MAVEN Clean Install                      -----------"
mvn clean install

echo "---------                Fin de l'etape 1                       -----------"

sleep 4 
clear

echo "---------                2 - Deployement                      -----------"

asadmin start-domain
sleep 2


asadmin start-database
sleep 2
asadmin undeploy microProject-bean
sleep 2
asadmin deploy auctionProject_Bean/target/microProject-bean.jar
sleep 4
clear
echo "---------                Fin de l'etape 2                       -----------"
sleep 2
echo "Lencer le test (yes/non)"
#read rep
#if [ $rep= "YES" || $rep= "yes" || $rep= "y" ]
#then
##	echo "---------                3 - Test                      -----------"
#	cd ClientBean
#	java -classpath $CLASSPATH:../auctionProject_Bean/target/microProject-bean.jar:target/auctionProject_Client-0.0.1-SNAPSHOT.jar client.Client
#	cd ..
#fi
 
echo "---------                Fin de l'etape 3                      -----------"


