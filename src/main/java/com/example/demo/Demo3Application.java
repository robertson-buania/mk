package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.sec.contantes.JWTUtil;
import com.example.demo.sec.entities.AppRole;
import com.example.demo.sec.entities.AppUser;
import com.example.demo.sec.service.AccountService;
import com.example.demo.sec.service.AccountServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(JWTUtil.CORS_ACCESS_PERMITED);
            }
        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Depense.class, Consommationmazout.class,
                    Engin.class, Livraison.class,
                    Mazout.class, Produit.class );
            AppRole appRole=new AppRole(null,"ADMIN");
//b****777
            accountService.addAppRole(appRole);
            AppRole appRolesuper=new AppRole(null,"SUPER_ADMIN");

            accountService.addAppRole(appRolesuper);

            AppRole appRole1=new AppRole(null,"USER");

            accountService.addAppRole(appRole1);


            AppUser appUser=new AppUser(null,"Michel","Kalala1993fundibora",new ArrayList<>());
            accountService.addAppUser(appUser);
            AppUser appUser1=new AppUser(null,"Mike001","Mkproduction",new ArrayList<>());
            accountService.addAppUser(appUser1);
            AppUser buania=new AppUser(null,"Buania","Buania@@",new ArrayList<>());
            accountService.addAppUser(buania);


            accountService.addRoleToUser("Michel","ADMIN");
            accountService.addRoleToUser("Michel","USER");
            accountService.addRoleToUser("Buania","ADMIN");
            accountService.addRoleToUser("Buania","SUPER_ADMIN");
            accountService.addRoleToUser("Buania","USER");
            accountService.addRoleToUser("Mike001","USER");






        };
    }


    }
    /*
    git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Buania/fundiboramkprod.git
git push -u origin main
     */

/*
Local



spring.datasource.url = jdbc:mysql://localhost:3307/mkprod?serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password =1
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
#spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.servlet.multipart.max-file-size=500KB
spring.servlet.multipart.max-request-size=500KB
#mysql://${{ MYSQLUSER }}:${{ MYSQLPASSWORD }}@${{ MYSQLHOST }}:${{ MYSQLPORT }}/${{ MYSQLDATABASE }}

*************************************************************************************************************
spring.datasource.url = jdbc:mysql://containers-us-west-187.railway.app:5957/railway?serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password =Yp9odUtpQ9rdAyv8i7cQ
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
#spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.servlet.multipart.max-file-size=500KB
spring.servlet.multipart.max-request-size=500KB


#mysql://${{ MYSQLUSER }}:${{ MYSQLPASSWORD }}@${{ MYSQLHOST }}:${{ MYSQLPORT }}/${{ MYSQLDATABASE }}


 */
