package entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name ="Utilisateur")
public class User extends ParentOU implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String pseudo;
	private String fn;
	private String ln;
	private int codep;
	private String email;
	private boolean sell_rights;
	private Auction ect;
	
	public User(String pseudo, String fn, String ln, int codep, String email, boolean sell_rights, Auction ect) {
		super();
		this.pseudo = pseudo;
		this.fn = fn;
		this.ln = ln;
		this.codep = codep;
		this.email = email;
		this.sell_rights = sell_rights;
		this.ect = ect;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id 
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public int getCodep() {
		return codep;
	}
	public void setCodep(int codep) {
		this.codep = codep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSell_rights() {
		return sell_rights;
	}
	public void setSell_rights(boolean sell_rights) {
		this.sell_rights = sell_rights;
	}
	public Auction getEct() {
		return ect;
	}
	public void setEct(Auction ect) {
		this.ect = ect;
	}
	
	
	@Override
	public String toString() {
		return "User [pseudo=" + pseudo + ", fn=" + fn + ", ln=" + ln + ", codep=" + codep + ", email=" + email
				+ ", sell_rights=" + sell_rights + ", ect=" + ect + "]";
	}
	
	
	
	
	
}
