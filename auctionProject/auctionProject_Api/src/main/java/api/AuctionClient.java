package api;

import javax.ejb.Remote;


import entity.Auction;
import entity.User;


@Remote
public interface AuctionClient {
	public String startAuction(Auction o);
	public String closeAuction(Auction au);
	public String Bids(User u, Auction au);
  	public Auction UpdateAuction(Auction au);
	
	
}