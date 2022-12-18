package com.libro.libro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libro.libro.data.Book;
import com.libro.libro.services.BookServices;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ListaController {
	@Autowired
	private BookServices bookServices;

	@GetMapping("/apiLibros/BDBiblioteca")
	public List<Book> listaBook(){
		return (List<Book>) bookServices.listarBook();
	}	
}
