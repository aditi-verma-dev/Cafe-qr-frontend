package com.cafeqr.cafeQR.Security;



import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service 
public class JwtService {

    private final String SECRET="QWERTYUIOPASDFGHJKLZXCVBNMQWERTY";

    public String generateToken( String username)
    {
   return Jwts.builder()
              .subject(username)
              .issuedAt(new Date(System.currentTimeMillis()))
              .expiration(new Date(System.currentTimeMillis()+1000*60*60*24))
              .signWith(getKey())
              .compact();
    }
    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }
    public boolean isTokenValid(String token,String username){
        String tokenUsername=extractUsername(token);
        return tokenUsername.equals(username)&& !isTokenExpired(token);
    }
    public boolean isTokenExpired(String token){
        return extractAllClaims(token).getExpiration().before(new Date());

    }
    public Claims extractAllClaims(String token){
        return Jwts.parser()
                   .verifyWith(getKey())
                   .build()
                   .parseSignedClaims(token)
                   .getPayload();

    }
    private SecretKey getKey()
    {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    }
}
