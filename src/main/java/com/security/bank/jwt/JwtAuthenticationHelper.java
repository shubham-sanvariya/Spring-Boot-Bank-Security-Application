package com.security.bank.jwt;

import java.util.Date;
import java.util.HashMap;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import com.security.bank.dto.JwtRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtAuthenticationHelper {

	private String secret = "thisisacodingninjasdemonstrationforsecretkeyinspringsecurityjsonwebtokenauthentication";
	private static final long JWT_TOKEN_VALIDITY = 60 * 60;
    
    public Claims getClaimsFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(secret.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }

    public String generateToken(JwtRequest jwtRequest){
        return Jwts.builder()
                .setClaims(new HashMap<String ,Object>())
                .setSubject(jwtRequest.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS512.getJcaName()),SignatureAlgorithm.HS512)
                .compact();

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
