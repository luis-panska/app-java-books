package com.libro.libro.security;

import lombok.Data;

@Data
public class AuthCredentials {
	private String email;
	private String password;
	private String nombre;
}
