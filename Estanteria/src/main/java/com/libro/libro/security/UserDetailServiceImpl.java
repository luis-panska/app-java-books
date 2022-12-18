package com.libro.libro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.libro.libro.data.UsuariosRepository;
import com.libro.libro.data.Usuarios;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AuthCredentials usuario = new AuthCredentials();
		
		System.out.println("USERNAME: " + email);
		
		Usuarios usuarios = usuarioRepository
				.findById(email)
				.orElseThrow( () -> new UsernameNotFoundException("No existe el mail " + email) );
				
	
		usuario.setEmail(usuarios.getUsername());
		usuario.setPassword(usuarios.getPassword());
		usuario.setNombre(usuarios.getNombre());
		// TODO Auto-generated method stub
		return new UserDetailsImpl(usuario);
	}

}
