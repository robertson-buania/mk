package com.example.demo.sec.repo;

import com.example.demo.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

    AppRole findAppRoleByRoleName(String roleNAme);
}
