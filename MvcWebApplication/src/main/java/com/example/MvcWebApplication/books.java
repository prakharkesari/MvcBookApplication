package com.example.MvcWebApplication;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/* 
 * Definisco come entity la classe quindi si collegherà automaticamente alla tabella
 * LOGIN dell'applicazione
*/
@Entity
@Table(name = "books")
public class books {
	
	/* Indico qual'è il campo chiave primaria*/
	@Id
	// Definisco che la Id fa riferimento a una SEQUENCE generata dal db (la seq_books_id)
	@GeneratedValue(
		    strategy = GenerationType.SEQUENCE,
		    generator = "seq_books_id"
		)
	@Column(name = "bookid")
	// Dico di utilizzare la sequenza definita in precedenza
	@SequenceGenerator(name="seq_books_id", allocationSize=1)	
	private Long bookid;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@OneToOne(mappedBy="books")
	private rents rents;	
	
	public Long getBookid() {
		return bookid;
	}


	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}

	
    @Override
    public String toString()
    {
        return "{Id=" + bookid + 
        			 ", Title=" + title + 
        			 ", Author=" + author +
        			 "}";
    }

}
