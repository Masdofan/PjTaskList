package com.taskManager.service.impl;

import com.taskManager.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenServiceImpl implements TokenService {

    private String secret = "hfq873g4fq736gfu8gqirwekyhvbg8734618943gfiyuherqbgbgoisdabygiqawbdgbiwerygbq36428g1ibfskjdbv8ayw4723";

    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public String createToken(UserDetails userDetails) {
        var username = userDetails.getUsername();
        var authorities = userDetails.getAuthorities();

        var perms = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(username)
                .claim("login", username)
                .claim("roles", perms)
                .signWith(secretKey)
                .compact();

    }

    @Override
    public Authentication fromToken(String token) {
        JwtParser parser = Jwts.parser()
                .setSigningKey(secretKey)
                .build();

        Claims payload = parser.parseClaimsJws(token).getPayload();

        Object login = payload.get("login");
        String roles = (String)payload.get("roles");

        List<SimpleGrantedAuthority> collect = Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(login, null, null);
    }
}
