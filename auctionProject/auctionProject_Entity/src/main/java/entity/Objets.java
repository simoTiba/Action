package entity;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Objets")
public class Objets extends ParentOU implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private int id;
	private String desc;
	private String cat;
	
	@ManyToOne
	@JoinColumn(name="pseudo")
	private String id_vendor;
	private String inc_prop;
	private double price;
	private boolean seel_statut;
	public Objets(int id, String desc, String cat, String id_vendor, String inc_prop, double price,
			boolean seel_statut) {
		super();
		this.id = id;
		this.desc = desc;
		this.cat = cat;
		this.id_vendor = id_vendor;
		this.inc_prop = inc_prop;
		this.price = price;
		this.seel_statut = seel_statut;
	}
	public Objets() {
		super();
	}
	
	@Id
	@Column(name = "Obj_Id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "Obj_Desc")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Column(name = "Obj_Cat")
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
	public String getId_vendor() {
		return id_vendor;
	}
	public void setId_vendor(String id_vendor) {
		this.id_vendor = id_vendor;
	}
	public String getInc_prop() {
		return inc_prop;
	}
	public void setInc_prop(String inc_prop) {
		this.inc_prop = inc_prop;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isSeel_statut() {
		return seel_statut;
	}
	public void setSeel_statut(boolean seel_statut) {
		this.seel_statut = seel_statut;
	}
	@Override
	public String toString() {
		return "object [id=" + id + ", desc=" + desc + ", cat=" + cat + ", id_vendor=" + id_vendor + ", inc_prop="
				+ inc_prop + ", price=" + price + ", seel_statut=" + seel_statut + "]";
	}
	
	

}
