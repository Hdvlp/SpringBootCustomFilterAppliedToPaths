package com.springbootcustomfilterappliedtopaths.demo.config;

import java.io.IOException;
import java.util.Objects;

import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;


public class CustomFilter extends GenericFilterBean{
    private static int count = 0;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        
        count++;

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (Objects.equals(httpRequest, null)){
            chain.doFilter(request, response);
            return;
        }
        String requestPath = httpRequest.getRequestURI();
        if (requestPath.equals("/login")) {
            chain.doFilter(request, response);
            return;
        }
            

        System.out.println();
        System.out.println("CustomFilter: " + count + " : " + requestPath);

    
        chain.doFilter(request, response);
        return;
    }

}


