package com.adobe.prj.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "*.jsp")
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // my logic
        // conditonally return;
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
