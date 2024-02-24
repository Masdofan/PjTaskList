package com.taskManager.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {

    String createToken(UserDetails userDetails);

    Authentication fromToken(String token);

}
