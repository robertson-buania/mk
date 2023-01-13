package com.example.demo.sec.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.sec.contantes.JWTUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JwtAuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if(request.getServletPath().equals("/refreshToken") || request.getServletPath().equals("/login")){
            response.addHeader(JWTUtil.CORS_HEADER,JWTUtil.CORS_ACCESS_PERMITED);
            filterChain.doFilter(request,response);
        }else {

            if(request.getParameter(JWTUtil.TOKEN)!=null ){
                try {
                 //   System.out.println("Before doFilterInternal");
                    String v=request.getParameter(JWTUtil.TOKEN);
                    String jwt=v;

                    Algorithm algorithm=Algorithm.HMAC256(JWTUtil.SECRET);
                    JWTVerifier jwtVerifier= JWT.require(algorithm).build();

                    DecodedJWT verify = jwtVerifier.verify(jwt);

                    String username=verify.getSubject();

                    String [] roles=verify.getClaim("roles").asArray(String.class);

                    Collection<GrantedAuthority> authorities=new ArrayList<>();
                    for(String r:roles ){
                        authorities.add(new SimpleGrantedAuthority(r));
                    }
                    UsernamePasswordAuthenticationToken authenticationToken=
                            new UsernamePasswordAuthenticationToken(username,null,authorities);

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    filterChain.doFilter(request,response);
                    //System.out.println("Succès");


                }catch (Exception e){
                    response.setHeader("error-message",e.getMessage());
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                }
            }else {
                filterChain.doFilter(request,response);
            }
        }


    }
}
/*
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
			}
		};
	}
 */