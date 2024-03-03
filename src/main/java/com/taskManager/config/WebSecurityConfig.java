package com.taskManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;


@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(cust -> {
            cust
                    .requestMatchers("/authorization/**").permitAll()
                    .requestMatchers("/homepage/**", "/taskPage/**", "/error").authenticated();
        });

        http.formLogin(cust -> {
            cust.loginPage("/authorization");
            cust.loginProcessingUrl("/login");
            cust.usernameParameter("login");
            cust.passwordParameter("password");
            cust.successHandler((request, response, authentication) -> {
                response.sendRedirect("/homepage");
            });
            cust.failureHandler(((request, response, exception) -> {
                response.sendRedirect("/authorization");
            }));
        });

        http.logout(cust -> {
            cust.logoutUrl("/logout");
            cust.invalidateHttpSession(true);
            cust.addLogoutHandler(((request, response, authentication) ->
            {
                try {
                    response.sendRedirect("/authorization");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            ));
        });

        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
