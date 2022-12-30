package com.example.demo.services;

import com.example.demo.dao.EnginRepository;
import com.example.demo.entities.Engin;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnginServiceImpl implements MkprodService<Engin>{

    private EnginRepository enginRepository;

    public EnginServiceImpl(EnginRepository enginRepository) {

        this.enginRepository = enginRepository;
    }

    @Override
    public List<Engin> all() {
        return enginRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Engin findOne(Long id) {
        return enginRepository.findById(id).get();
    }

    @Override
    public Engin saveOne(Engin engin) {
       return enginRepository.save(engin);
    }

    @Override
    public boolean delete(Long id) {
       return false;

    }


}