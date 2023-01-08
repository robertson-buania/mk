package com.example.demo;

import com.example.demo.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

    @Bean
    CommandLineRunner start(RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Depense.class, Consommationmazout.class,
                    Engin.class, Livraison.class,
                    Mazout.class, Produit.class );
        };
    }
}
/*
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
