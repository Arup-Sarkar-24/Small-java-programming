package com.cisco.api.book.bootrestbook.dao;
import org.springframework.data.repository.CrudRepository;
import com.cisco.api.book.bootrestbook.entities.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {
	public Book findById(int id); 
		

}
