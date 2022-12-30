package com.example.demo.services;

import com.example.demo.dao.MazoutRepository;
import com.example.demo.entities.Mazout;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MazoutServiceImpl implements MkprodService<Mazout>{

    private MazoutRepository mazoutRepository;

    public MazoutServiceImpl(MazoutRepository mazoutRepository) {
        this.mazoutRepository = mazoutRepository;
    }

    @Override
    public List<Mazout> all() {
        return mazoutRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Mazout findOne(Long id) {
        return mazoutRepository.findById(id).get();
    }

    @Override
    public Mazout saveOne(Mazout mazout) {
       return mazoutRepository.save(mazout);
    }
    @Override
    public boolean delete(Long id) {
      return false;

    }


}