package com.example.demo.services;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MkprodService<T> {
    
    public List<T> all();

    public T findOne(Long id);

    public T saveOne(T t);

    public boolean delete(Long id);

}
