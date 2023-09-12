package com.mottakin.onlineBookLibraryApplication.security;

import com.mottakin.onlineBookLibraryApplication.constants.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager)
            throws Exception {
        http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->{
                    auth
                            .requestMatchers(HttpMethod.POST, AppConstants.SIGN_IN, AppConstants.SIGN_UP).permitAll()
                            .requestMatchers(HttpMethod.GET, AppConstants.USERS_DETAILS).hasRole("ADMIN")
                            .requestMatchers(HttpMethod.POST, AppConstants.CREATE_BOOKS).hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, AppConstants.UPDATE_BOOKS).hasRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, AppConstants.DELETE_BOOKS).hasRole("ADMIN")
                            .requestMatchers(HttpMethod.GET,AppConstants.SEE_ALL_BOOKS).hasAnyRole("ADMIN", "CUSTOMER")
                            .requestMatchers(HttpMethod.POST, AppConstants.BORROW_BOOK).hasRole("CUSTOMER")
                            .requestMatchers(HttpMethod.POST, AppConstants.RETURN_BOOK).hasRole("CUSTOMER")
                            .requestMatchers(HttpMethod.GET,AppConstants.SEE_BORROWED_RETURNED_BOOK).hasAnyRole("ADMIN", "CUSTOMER")
                            .requestMatchers(HttpMethod.GET,AppConstants.SEE_ONLY_BORROWED_BOOK).hasAnyRole("ADMIN", "CUSTOMER")
                            .requestMatchers(HttpMethod.GET,AppConstants.HISTORY).hasRole("CUSTOMER")
                            .requestMatchers(HttpMethod.POST,AppConstants.CREATE_REVIEW).hasRole( "CUSTOMER")
                            .requestMatchers(HttpMethod.GET,AppConstants.SEE_REVIEW).hasAnyRole( "CUSTOMER", "ADMIN")
                            .requestMatchers(HttpMethod.DELETE,AppConstants.DELETE_REVIEW).hasRole( "CUSTOMER")
                            .requestMatchers(HttpMethod.PUT,AppConstants.UPDATE_REVIEW).hasRole( "CUSTOMER")
                            .requestMatchers(HttpMethod.POST,AppConstants.RESERVE_BOOK).hasRole( "CUSTOMER")
                            .requestMatchers(HttpMethod.POST,AppConstants.CANCLE_RESERVE_BOOK).hasRole( "CUSTOMER")
                            .anyRequest().authenticated();
                })
                .addFilter(new CustomAuthenticationFilter(authenticationManager))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }
}
