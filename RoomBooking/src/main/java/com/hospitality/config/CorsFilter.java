//package com.hospitality.config;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class CorsFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletResponse res = (HttpServletResponse) response;
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
//        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        res.setHeader("Access-Control-Allow-Headers", "*");
//        res.setHeader("Access-Control-Allow-Credentials", "true");
//
//        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
//            return;
//        }
//
//        chain.doFilter(request, response);
//    }
//}
