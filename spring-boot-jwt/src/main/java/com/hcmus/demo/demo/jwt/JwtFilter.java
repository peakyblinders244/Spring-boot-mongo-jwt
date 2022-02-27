package com.hcmus.demo.demo.jwt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Priority;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/service/*")
public class JwtFilter implements Filter {

    private JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
    private final String JWT_SECRET = "HongQuan";


    @Value("${JWT_USERNAME}")
    private String JWT_USERNAME;

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authorizationHeader = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            //gửi lỗi khi ko có token
            throw new ServletException("OncePerRequestFilter just supports HTTP requests");
        }
        String token = authorizationHeader.substring("Bearer ".length()).trim();


        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                String userName = jwtTokenProvider.getUserNameFromJwt(token);

                //Kiểm tra trong database có tồn tại username ko... làm demo nên cho là auto có
//                if(userName == JWT_USERNAME){
//
//                }

                filterChain.doFilter(request, response);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
