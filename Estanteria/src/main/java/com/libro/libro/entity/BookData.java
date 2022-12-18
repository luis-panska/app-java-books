package com.libro.libro.entity;

import lombok.Data;

@Data
public class BookData {
	private long id;
	private String title;
	private int stock;
	private String author;
}
