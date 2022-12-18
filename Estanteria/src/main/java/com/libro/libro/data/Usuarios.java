package com.libro.libro.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USUARIOS")
@Data
	public class Usuarios {
		@Id
		@Column(name="USERNAME")	
		String username;	
		@Column(name="PASSWORD")
		String password;
		@Column(name="NOMBRE")
		String nombre;
}
