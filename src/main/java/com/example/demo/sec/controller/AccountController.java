package com.example.demo.sec.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.sec.contantes.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.sec.contantes.JWTUtil;
import com.example.demo.sec.entities.AppRole;
import com.example.demo.sec.entities.AppUser;
import com.example.demo.sec.service.AccountService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(JWTUtil.CORS_ACCESS_PERMITED)
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("users")
    @PostAuthorize("hasAuthority('SUPER_ADMIN')")
    List<AppUser> users(){
        return accountService.listUsers();
    }

    @PostMapping("users")
    @PostAuthorize("hasAuthority('SUPER_ADMIN')")
    AppUser saveUser(@RequestBody AppUser appUser){


        return accountService.addAppUser(appUser) ;
    }

    @PostMapping("roles/save")
    @PostAuthorize("hasAuthority('SUPER_ADMIN')")
    AppRole saveUser(@RequestBody AppRole appRole){


        return accountService.addAppRole(appRole) ;
    }


    @PostMapping("addRoleToUser")
    @PostAuthorize("hasAuthority('SUPER_ADMIN')")
    void addRoleToUser(@RequestBody AddRoleUserForm addRoleUserForm){


        accountService.addRoleToUser(addRoleUserForm.getUsername(),addRoleUserForm.getRoleName());
    }

    @GetMapping("refreshToken")
    @PostAuthorize("hasAuthority('SUPER_ADMIN')")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String autToken=request.getHeader(JWTUtil.AUTH_HEADER);

        if(autToken!=null && autToken.startsWith(JWTUtil.PREFIX)){
         try {
             String refreshToken=autToken.substring(JWTUtil.PREFIX.length());
             Algorithm algorithm=Algorithm.HMAC256(JWTUtil.SECRET);
             JWTVerifier jwtVerifier= JWT.require(algorithm).build();
             DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
             String username= decodedJWT.getSubject();

             AppUser appUser=accountService.loadUserByUsername(username);

             String accessToken= JWT.create()
                     .withSubject(appUser.getUsername())
                     .withExpiresAt(new Date(System.currentTimeMillis()+1*60*1000))
                     .withIssuer(request.getRequestURL().toString())
                     .withClaim("roles",
                             appUser.getAppRoles().
                                     stream().map(r -> r.getRoleName()).collect(Collectors.toList()))
                     .sign(algorithm);

             Map<String,String> stringStringMap=new HashMap<>();

             stringStringMap.put("access-token",accessToken);
             stringStringMap.put("refresh-token",refreshToken);
             response.setContentType("application/json");

             new ObjectMapper().writeValue(response.getOutputStream(),stringStringMap);
         }catch (Exception e){
             throw  e;
         }
        }else {
            throw new RuntimeException("Refresh token required");
        }
    }

    @GetMapping("profil")
    @PostAuthorize("hasAuthority('SUPER_ADMIN')")
    public AppUser profil(Principal principal){
        return accountService.loadUserByUsername(principal.getName());
    }

}

class AddRoleUserForm{

    private String username;
    private  String roleName;

    public AddRoleUserForm() {
    }

    public AddRoleUserForm(String username, String roleName) {
        this.username = username;
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}