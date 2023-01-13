package com.example.demo.sec.repo;

import com.example.demo.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findAppUserByUsername(String username);
}
