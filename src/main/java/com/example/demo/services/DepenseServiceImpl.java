package com.example.demo.services;

import com.example.demo.dao.DepenseRepository;
import com.example.demo.entities.Depense;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepenseServiceImpl implements MkprodService<Depense>{

    private DepenseRepository depenseRepository;

    public DepenseServiceImpl(DepenseRepository depenseRepository) {
        this.depenseRepository = depenseRepository;
    }

    @Override
    public List<Depense> all() {
        return depenseRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Depense findOne(Long id) {
        return depenseRepository.findById(id).get();
    }

    @Override
    public Depense saveOne(Depense depense) {
       return depenseRepository.save(depense);
    }

    @Override
    public boolean delete(Long id) {
        Depense depense=findOne(id);

        if(depense!=null){
            depenseRepository.delete(findOne(id));
            return true;
        }else{
            return false;
        }

    }

}