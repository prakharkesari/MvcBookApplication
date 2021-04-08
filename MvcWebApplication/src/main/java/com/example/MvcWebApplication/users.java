package com.example.MvcWebApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/* 
 * Definisco come entity la classe quindi si collegherà automaticamente alla tabella
 * UTENTI dell'applicazione
*/
@Entity
@Table(name = "users")
public class users {
	
	/* Indico qual'è il campo chiave primaria*/
	@Id
	// Definisco che la Id fa riferimento a una SEQUENCE generata dal db (la seq_users_id)
	@GeneratedValue(
		    strategy = GenerationType.SEQUENCE,
		    generator = "seq_users_id"
		)
	@Column(name = "id")
	// Dico di utilizzare la sequenza definita in precedenza
	@SequenceGenerator(name="seq_users_id", allocationSize=1)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;	
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "useraddress", nullable = false)	
	private String useraddress;
	
	@Column(name = "useremail", nullable = false)	
	private String useremail;
	
	
	@OneToMany(mappedBy="users",cascade = CascadeType.ALL)
	private List<rents> rents = new ArrayList<>();
	
	
    public users()
    {
        super();
    }

    public users(Long id, String username, String password, String name, 
    					  String useraddress, String useremail)
    {
        super();

        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.useraddress = useraddress;
        this.useremail = useremail;
    }	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	
    @Override
    public String toString()
    {
        return "Utente {Id=" + id + 
        			 ", Name=" + name + 
        			 ", Address=" + useraddress + 
        			 ", Email=" + useremail +
        			 "}";
    }	
	

	
}
