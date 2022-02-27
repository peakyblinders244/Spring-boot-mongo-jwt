//package com.hcmus.demo.demo;
//
//import com.hcmus.demo.demo.jwt.JwtTokenProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.EOFException;
//import java.io.IOException;
//
//@Component
//public class SecurityConfig extends OncePerRequestFilter {
//
//    private JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (authorizationHeader == null && authorizationHeader.startsWith("Bearer ")) {
//            throw new EOFException("Authorization header must be provided");
//        }
//
//        String token = authorizationHeader.substring("Bearer ".length()).trim();
//
//        try {
//            if(token != null && jwtTokenProvider.validateJwtToken(token)){
//                String userName = jwtTokenProvider.getUserNameFromJwtToken(token);
//
//                //Kiểm tra trong database có tồn tại username ko... làm demo nên cho là auto có
////                if(userName == JWT_USERNAME){
////
////                }
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }
//}
