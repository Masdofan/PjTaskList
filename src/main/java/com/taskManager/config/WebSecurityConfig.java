package com.taskManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {

//    @Autowired
//    private TokenGenerationFilter tokenGenerationFilter;
//    @Autowired
//    private TokenValidationFilter tokenValidationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(cust -> {
            cust
                    .requestMatchers("/authorization/**").permitAll()
                    .requestMatchers("/homepage/**", "/taskPage").permitAll();
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
//
//        http.addFilterAfter(tokenGenerationFilter, LogoutFilter.class);
//        http.addFilterBefore(tokenValidationFilter, SecurityContextHolderFilter.class);

        http.logout(cust -> {
            cust.logoutUrl("/logout");
            cust.invalidateHttpSession(true);
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
