package com.security.bank.jwt;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtAuthenticationHelper {

	private String secret = "thisisacodingninjasdemonstrationforsecretkeyinspringsecurityjsonwebtokenauthentication";
    
    public Claims getClaimsFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(secret.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }

    public String getUsernameFromToken(String token){
        return getClaimsFromToken(token).getSubject();
    }
}
