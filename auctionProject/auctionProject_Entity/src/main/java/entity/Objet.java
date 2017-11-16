package entity;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Objet")
public class Objet extends ParentOU implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String idobj;
	private String description;
	private String cat;
	
	@ManyToOne
	@JoinColumn(name="pseudouser",nullable=false)
	private User id_vendor;
	
	private int inc_prop;
	private int price;
	
	

	 
	
	
	
	public Objet(String id, String desc, String cat, int inc_prop, int price) {
		super();
		this.idobj = id;
		this.description = desc;
		this.cat = cat;
		this.id_vendor = null;
		this.inc_prop = inc_prop;
		this.price = price;
		
	}
	public Objet() {
		super();
	}
	
	
	
	public String getId() {
		return idobj;
	}
	public void setId(String id) {
		this.idobj = id;
	}
	
	public String getDesc() {
		return description;
	}
	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
	public User getId_vendor() {
		return id_vendor;
	}
	public void setId_vendor(User id_vendor) {
		this.id_vendor = id_vendor;
	}
	public int getInc_prop() {
		return inc_prop;
	}
	public void setInc_prop(int inc_prop) {
		this.inc_prop = inc_prop;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "object [id=" + idobj + ", desc=" + description + ", cat=" + cat + ", id_vendor=" + id_vendor + ", inc_prop="
				+ inc_prop + ", price=" + price + "]";
	}
	
	

}
