package api;

import javax.ejb.Remote;

import entity.Auction;

@Remote
public interface AuctionClient {
	
	public boolean startAuction(Auction au);
	
	public void closeAuction(Auction au);
	
	public void Bids(int b);
	
	
}
