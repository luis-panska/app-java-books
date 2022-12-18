package com.libro.libro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libro.libro.data.*;
import com.libro.libro.entity.BookData;


@Controller
public class CertusController {
	@Autowired
	private BookRepository roomRepository;

	@GetMapping("/views/books")
	public String Saludar(@RequestParam(name = "id", required = false, defaultValue = "1") Long id, Model model) {

		Optional<Book> r = this.roomRepository.findById(id);
		BookData bean = new BookData();

		if (!r.isEmpty()) {
			bean.setId( r.get().getId() );
			bean.setTitle(r.get().getTitle());
			bean.setStock(r.get().getStock());
			bean.setAuthor(r.get().getAuthor());
			/*
			model.addAttribute("IDCuarto", r.get().getId());
			model.addAttribute("nombre", r.get().getName());
			model.addAttribute("numCuarto", r.get().getRoomNumber());
			model.addAttribute("InfoCama", r.get().getBedInfo());
			*/
			model.addAttribute("Room", bean);
			model.addAttribute("mensaje", "OK");
		} else {
			model.addAttribute("mensaje", "No existe Habitacion con el ID");
		}

		return "Registro";
	}
	
	@GetMapping("/views/newBook")
	public String Biblioteca(
			Model model) {
		model.addAttribute("mensaje","OK");
		model.addAttribute("Room", new BookData());
		return "Biblioteca";
	}
	
	@PostMapping("/views/guardar")
	public String SaveRoom( @ModelAttribute BookData  room) {
		System.out.println(room);
		//Creo el objeto a almacenar
		Book r = new Book();
		//Seteo los objetos
		r.setStock(room.getStock());
		r.setTitle(room.getTitle());
		r.setAuthor(room.getAuthor());
		//Guardo el objeto creado
		roomRepository.save(r);
		return "redirect:/views/rooms";
	}
	
	@PostMapping("/views/modificar")
	public String ModifyRoom( @ModelAttribute BookData room) {
		System.out.println(room);
		//Creo el objeto a almacenar
		Book r = new Book();
		//Seteo los objetos
		r.setStock(room.getStock());
		r.setTitle(room.getTitle());
		r.setAuthor(room.getAuthor());
		r.setId(room.getId());
		//Guardo el objeto creado
		roomRepository.save(r);
		return "redirect:/views/rooms?id=" + r.getId();
	}
	
}
