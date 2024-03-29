package com.example.demo.sec.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.sec.contantes.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("attemptAuthentication");
        String username=request.getParameter("username");

        String password=request.getParameter("password");

        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(username,password);



        return authenticationManager.authenticate(authenticationToken);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        System.out.println("successfulAuthentication");
        User user=(User) authResult.getPrincipal();


        Algorithm algorithm=Algorithm.HMAC256(JWTUtil.SECRET);
        String accessToken= JWT.create()
                .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+JWTUtil.EXPIRE_ACCESS))
                                .withIssuer(request.getRequestURL().toString())
                                        .withClaim("roles",
                                                user.getAuthorities().
                                                        stream().map(grantedAuthority -> grantedAuthority.getAuthority()).collect(Collectors.toList()))
                                                .sign(algorithm);

       // response.setHeader("Authorization",accessToken);
        String refreshToken= JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+JWTUtil.EXPIRE_REFRESH))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        Map<String,String> stringStringMap=new HashMap<>();

        stringStringMap.put("access_token",accessToken);
        stringStringMap.put("refresh_token",refreshToken);
        response.setContentType("application/json");

        new ObjectMapper().writeValue(response.getOutputStream(),stringStringMap);
    }
}
