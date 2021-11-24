package com.rovenlin.casualgym.security.filters;

import com.google.gson.Gson;
import com.rovenlin.casualgym.dtos.ExceptionResponseDTO;
import com.rovenlin.casualgym.security.jwt.JwtAuthenticationException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);

        } catch (UsernameNotFoundException e) {
            setErrorResponse(HttpStatus.FORBIDDEN, response, new JwtAuthenticationException("Token is invalid"));
        } catch (RuntimeException e) {
            e.printStackTrace();
            setErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, response, e);
        }
    }
    //TODO: shouldn't really return UserNameNotFound, too much information. Replace to token is invalid, log initial exception when logging is implemented
    private void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex){
        response.setStatus(status.value());
        response.setContentType("application/json");
        ExceptionResponseDTO errorResponse = new ExceptionResponseDTO();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setExceptionName(ex.getClass().getSimpleName());
        try {
            String json = new Gson().toJson(errorResponse);
            System.out.println(json);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
