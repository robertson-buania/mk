package com.example.demo.sec.service;

import com.example.demo.sec.entities.AppRole;
import com.example.demo.sec.entities.AppUser;
import com.example.demo.sec.repo.AppRoleRepository;
import com.example.demo.sec.repo.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements  AccountService{

    private PasswordEncoder passwordEncoder;
    private AppUserRepository appUserRepository;

    private AppRoleRepository appRoleRepository;

    public AccountServiceImpl(PasswordEncoder passwordEncoder, AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppRole addAppRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public AppUser addAppUser(AppUser appUser) {

        String pw=appUser.getPassword();

        appUser.setPassword(passwordEncoder.encode(pw));

        return appUserRepository.save(appUser);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole appRole=appRoleRepository.findAppRoleByRoleName(roleName);

      //  System.out.println("zrrr"+ appRole.getRoleName());
        AppUser appUser=appUserRepository.findAppUserByUsername(username);

        appUser.getAppRoles().add(appRole);

    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findAppUserByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
