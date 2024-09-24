package com.security.bank.jwt;

import java.util.Date;

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

    public boolean isTokenExpired(String token){
        Claims claims = getClaimsFromToken(token);

        Date expiredDate = claims.getExpiration();

        return expiredDate.before(new Date());
    }
}
