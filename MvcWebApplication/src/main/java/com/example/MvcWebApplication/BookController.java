package com.example.MvcWebApplication;


import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class BookController {

	@Autowired
	BooksRepository bookRepository;
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public ResponseEntity<Iterable<books>> getAllBooks() {
		 Iterable<books> allBooks = bookRepository.findAll();
		 return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
	}	
	
	@RequestMapping(value="/books/{bookId}", method=RequestMethod.GET)
	public ResponseEntity<?> getBook(@PathVariable Long bookId) {
		Optional<books> b = bookRepository.findById(bookId);
		return new ResponseEntity<> (b, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public ResponseEntity<?> createBook(@RequestBody books books) {	
	 books = bookRepository.save(books);

	 // Set the location header for the newly created resource
	 HttpHeaders responseHeaders = new HttpHeaders();
	 URI newUserUri = ServletUriComponentsBuilder
	 .fromCurrentRequest()
	 .path("/{id}")
	 .buildAndExpand(books.getBookid())
	 .toUri();
	 responseHeaders.setLocation(newUserUri);

	 return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}		
	
	@RequestMapping(value="/books/{bookId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
	 bookRepository.deleteById(bookId);
	 return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	@RequestMapping(value="/books/{bookId}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateBook(@RequestBody books book, @PathVariable Long bookId) {
		// Save the entity
		Optional<books>  ToUpdate = bookRepository.findById(bookId);
		books bookToUpdate = ToUpdate.get();
		bookToUpdate.setTitle(book.getTitle());
		bookToUpdate.setAuthor(book.getAuthor());		
		books c = bookRepository.save(bookToUpdate);
			 
		 return new ResponseEntity<>(HttpStatus.OK);
	}	
	
}
