package com.rovenlin.casualgym.security;

import com.rovenlin.casualgym.security.jwt.JwtConfigurer;
import com.rovenlin.casualgym.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String LOGIN_ENDPOINT = "/auth";
    private static final String REG_ENDPOINT = "/api/users/";
    private static final String H2_ENDPOINT = "/h2/**";
    private static final String FILES_ENDPOINT = "/api/files/**";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().configurationSource(request -> {
                     CorsConfiguration cors = new CorsConfiguration();
                     String[] allowedOrigins = {"http://localhost:4200", "http://127.0.0.1:80", "http://example.com"};
                     String[] allowedMethods = {"GET","POST", "PUT", "DELETE", "OPTIONS"};
                     String[] allowedHeaders = {"*"};
                     cors.setAllowedOrigins(Arrays.asList(allowedOrigins));
                     cors.setAllowedMethods(Arrays.asList(allowedMethods));
                     cors.setAllowedHeaders(Arrays.asList(allowedHeaders));
                     return cors;
                })
                .and().httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(REG_ENDPOINT).permitAll()
                .antMatchers(H2_ENDPOINT).permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers(FILES_ENDPOINT).permitAll()
                //.antMatchers("/users/{user_id}/groups").authenticated()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
        //http.cors();
        http.headers().frameOptions().disable();
    }

}
