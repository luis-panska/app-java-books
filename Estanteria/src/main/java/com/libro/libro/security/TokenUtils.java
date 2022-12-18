package com.libro.libro.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class TokenUtils {

	private final static String ACCESS_TOKEN_SECRET= "$2a$10$35soosOtDwKGIokEQRF2I.Qd4lr6Jsr/YyPz2FHLUrhwuSIdrRcnW";
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
	
	public static String createToken(String nombre, String email) {
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000L;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		
		Map<String, Object> extra = new HashMap<>();
		extra.put("nombre", nombre);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
			
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		try {
			System.out.println("LLEGADA");
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();
			
			System.out.println(claims);
			String email = claims.getSubject();
			System.out.print("email: ");
			System.out.println(email);
			
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		}catch(JwtException e) {
			e.getStackTrace();
			return null;
		}
	}
}
