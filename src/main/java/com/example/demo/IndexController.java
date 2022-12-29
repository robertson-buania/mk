package com.example.demo;

import net.bytebuddy.utility.RandomString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    private  PersonRepository personRepository;

    public IndexController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("index")
    public Person stringt(){

           Person person=new Person();
            person.setNom(RandomString.make(8));


        return personRepository.save(person);
        //64434fe2-0e03-4e75-9cdd-2f0bb54e9a99
    }
}
