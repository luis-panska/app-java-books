package com.libro.libro.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.libro.libro.data.Book;
import com.libro.libro.data.BookRepository;
@Component
public class AppStartUpEvent implements ApplicationListener<ApplicationReadyEvent> {
	//private final RoomRepository roomRepository;
	
	public AppStartUpEvent(BookRepository roomRepository) {
	//	this.roomRepository = roomRepository;
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		
	//	System.out.println(this.roomRepository.count());
	//	Iterable<Room> rooms = this.roomRepository.findAll();
	//	rooms.forEach(System.out::println);
	}

}
