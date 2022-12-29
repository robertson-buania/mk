package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface PersonRepository extends JpaRepository <Person,Long> {
}
