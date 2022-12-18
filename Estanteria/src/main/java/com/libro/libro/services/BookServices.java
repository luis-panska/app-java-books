package com.libro.libro.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libro.libro.data.Book;
import com.libro.libro.data.BookRepository;





@Service
public class BookServices {
	
	@Autowired
	BookRepository bookRepository;
	
	public Optional<Book> obtenerBook(Long id) {
		return this.bookRepository.findById(id);		
	}
	
	public void guardarBook(Book r) {
		bookRepository.save(r);
	}
	
	public Iterable<Book> listarBook(){
		return bookRepository.findAll();
	}
}
