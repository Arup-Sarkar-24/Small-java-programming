package com.cisco.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.api.book.bootrestbook.entities.Book;
import com.cisco.api.book.bootrestbook.services.BookService;

@RestController
public class Controller {
	
	@Autowired
	private BookService bookService;
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list=bookService.getAllBooks();
		if (list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		} 
		return ResponseEntity.of(Optional.of(list));
	}
	
	 @GetMapping("/books/{id}")
	 public ResponseEntity<Book>getBook(@PathVariable("id")int id) {
		 Book book = bookService.getBookById(id);
		 if (book==null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		 return ResponseEntity.of(Optional.of(book));
		 
	 }
	 @PostMapping("/books")
	 public Book addBook(@RequestBody Book book) {
		Book b= this.bookService.addBook(book);
		System.out.println(book);
		return b;
	 }
	 //delete book handler
	 @DeleteMapping("/books/{bookId}")
	 public void deleteBook(@PathVariable("bookId") int bookId) {
		 this.bookService.deleteBook(bookId);
	 }
	 @PutMapping("/books/{bookId}")
	 public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId) {
		 this.bookService.updateBook(book,bookId);
		 return book;
	 }


}
