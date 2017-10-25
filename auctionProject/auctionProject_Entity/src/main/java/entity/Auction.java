package entity;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Auction")
public class Auction extends ParentOU implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String obj;
	private ArrayList<User> o = new ArrayList<User>()   ;
	private String state;
	private int price;
	
	@Id 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	
	@OneToMany(cascade = ALL, mappedBy = "ect")
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
	public Auction(String id, String obj, ArrayList<User> o, String state, int price) {
		super();
		this.id = id;
		this.obj = obj;
		this.o = o;
		this.state = state;
		this.price = price;
	}
	public Auction() {
		
	}
	@Override
	public String toString() {
		return "Auction [id=" + id + ", obj=" + obj + ", o=" + o + ", state=" + state + ", price=" + price + "]";
	}
	

}
