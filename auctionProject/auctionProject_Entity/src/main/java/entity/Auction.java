package entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Auction implements Serializable {

	private String obj;
	private ArrayList<User> o = new ArrayList<User>()   ;
	
	private String state;
	private int price;
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	public ArrayList<User> getO() {
		return o;
	}
	public void setO(ArrayList<User> o) {
		this.o = o;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
