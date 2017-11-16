package entity;



import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Auction")
public class Auction implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	private String id;
	@OneToOne
	@JoinColumn(name="idobj",nullable=false)
	private Objet obj;
	@OneToOne
	private User acheteur;
	@ManyToOne
	@JoinColumn(nullable=false)
	private User vendeur;
	public String state;
	private int price;
	
	
	
	
	
	
	
	
	
	
	private Auction(String id, Objet obj,int prixdebut) {
		super();
		this.id = id;
		this.obj = obj;
		this.vendeur =obj.getId_vendor();
		this.price= prixdebut;
		this.state = "not started";
	}

	public static Auction creerAuction(String id, Objet obj,int prixdebut) {
		return new Auction(id, obj, prixdebut);
		
	}
	
	
	
	
	
	
	public User getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(User acheteur) {
		this.acheteur = acheteur;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Objet getObj() {
		return obj;
	}
	public void setObj(Objet obj) {
		this.obj = obj;
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
	public User getVendeur() {
		return vendeur;
	}
	public void setVendeur(User vendeur) {
		this.vendeur = vendeur;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	
	
	
	
	
	
	public Auction() {
		super();
	}

	@Override
	public String toString() {
		return "Auction [id=" + id + ", obj=" + obj + ", acheteur=" + acheteur + ", state=" + state + ", price=" + price + "]";
	}
	

}
