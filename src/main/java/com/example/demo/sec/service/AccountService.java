package com.example.demo.sec.service;

import com.example.demo.sec.entities.AppRole;
import com.example.demo.sec.entities.AppUser;

import java.util.List;

public interface AccountService {


    AppRole addAppRole(AppRole appRole);

    AppUser addAppUser(AppUser appUser);

    void addRoleToUser(String username,String roleName);

    AppUser loadUserByUsername(String username);

    List <AppUser>  listUsers();
}
