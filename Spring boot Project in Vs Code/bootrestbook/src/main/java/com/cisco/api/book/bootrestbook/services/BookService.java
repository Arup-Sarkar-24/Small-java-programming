package com.cisco.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.ietf.jgss.Oid;
import org.springframework.stereotype.Component;

import com.cisco.api.book.bootrestbook.dao.BookRepo;
import com.cisco.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
	private BookRepo bookRepo; 
	/*
	private static List<Book> list = new ArrayList<>();
	static {
		list.add(new Book(12,"Java Programming","Arup Sarkar"));
		list.add(new Book(13,"C++ Programming","Arup Sarkar"));
		list.add(new Book(14,"Python Programming","Arup Sarkar"));
		list.add(new Book(15,"PHP Programming","Arup Sarkar"));
		list.add(new Book(16,"Basic C Programming","Arup Sarkar"));
		list.add(new Book(17,"Front End Programming","Arup Sarkar"));
		list.add(new Book(18,"Back End Programming","Arup Sarkar"));
	} */
	public List<Book> getAllBooks(){
		List<Book> list=(List<Book>) this.bookRepo.findAll();
		return list;
	}
	public Book getBookById(int id) {
		Book book=null;
		try {
			book= this.bookRepo.findById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	//adding the book
	public Book addBook(Book b) {
		Book resultBook =bookRepo.save(b);
		return resultBook;
	}
	public void deleteBook(int bid) {
		//list =list.stream().filter(Book ->Book.getId()!=bid).collect(Collectors.toList());
		bookRepo.deleteById(bid);
	}
	//update the book
	public void updateBook(Book book, int bookId) {
		/* list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		*/
		book.setId(bookId);
		bookRepo.save(book);
		
	}

}
