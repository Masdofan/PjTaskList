//package com.taskManager.config.filters;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.filter.OncePerRequestFilter;
//import com.taskManager.service.TokenService;
//
//import java.io.IOException;
//
//@Service
//public class TokenValidationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authorization = request.getHeader("Authorization");
//
//        if (authorization != null && !authorization.isBlank()) {
//            String token = authorization.substring(7);
//
//            Authentication authentication = tokenService.fromToken(token);
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        }
//        filterChain.doFilter(request, response);
//    }
//
//}
