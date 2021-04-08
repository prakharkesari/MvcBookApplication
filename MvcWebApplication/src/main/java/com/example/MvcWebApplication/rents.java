package com.example.MvcWebApplication;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rents")
public class rents {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rentid")
	private Integer rentid;
	
	@Column(name = "daterent", nullable = false)
	private Timestamp daterent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iduser", nullable = false)
	private users users;	
	
    public users getUsers() {
        return users;
    }
    public void setUsers(users users) {
        this.users = users;
    }


	@OneToOne
	@JoinColumn(name = "idbook")
	private books books;    
	
    public books getBooks() {
        return books;
    }
    public void setBooks(books books) {
        this.books = books;
    }
	
    public Integer getRentid() {
		return rentid;
	}
	public void setRentid(Integer rentid) {
		this.rentid = rentid;
	}
	public Timestamp getDaterent() {
		return daterent;
	}
	public void setDaterent(Timestamp daterent) {
		this.daterent = daterent;
	}
	@Override
    public String toString()
    {
        return "{rentid=" + rentid + 
        			 ", datarent=" + daterent.toString() + 
        			 "}";
    }

}
