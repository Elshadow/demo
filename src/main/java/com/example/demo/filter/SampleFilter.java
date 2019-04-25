package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "*", filterName = "SampleFilter")
public class SampleFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        String uri = ((HttpServletRequest) request).getRequestURI();
        if (!uri.contains("/favicon.ico"))
            System.out.println("Sample Filter doFilter " + uri + " | encoding " + ((HttpServletRequest) request).getRequestURL());
        chain.doFilter(request, response);
	}

}