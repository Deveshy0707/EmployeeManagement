package com.example.employeemanagement.security.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtility {

    @Value("${jwtSecret}")
    private String jwtSecret;

    @Value("${jwtExpirationMs}")
    private int jwtExpirationMs;


    public String generateToken(Authentication authentication) {
        UserDetails userDetails=((UserDetails)authentication.getPrincipal());
        Date currentTime = new Date();
        //String key=Encoders.BASE64.encode(jwtSecret.getBytes());
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities());

        return  Jwts.builder()
                .claims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(currentTime)
                .setExpiration(new Date(currentTime.getTime()+ jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        Claims claims=parser(token).getBody();

        Date expiration=claims.getExpiration();
        return expiration.after( new Date());
    }

    public String getUserName(String t) {
        return parser(t).getBody().getSubject();
    }

    public Jws<Claims> parser(String token) {
        JwtParser parser = Jwts.parser()
                .setSigningKey(jwtSecret)
                .build();

        return parser.parseClaimsJws(token);
    }
}
