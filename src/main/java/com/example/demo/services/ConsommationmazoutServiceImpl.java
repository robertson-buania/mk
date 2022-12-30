package com.example.demo.services;

import net.buania.mkprodback.dao.ConsommationmazoutRepository;
import net.buania.mkprodback.entities.Consommationmazout;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsommationmazoutServiceImpl implements MkprodService<Consommationmazout>{

    private ConsommationmazoutRepository consommationmazoutRepository;

    public ConsommationmazoutServiceImpl(ConsommationmazoutRepository consommationmazoutRepository) {
        this.consommationmazoutRepository = consommationmazoutRepository;
    }

    @Override
    public List<Consommationmazout> all() {
        return consommationmazoutRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Consommationmazout findOne(Long id) {
        return consommationmazoutRepository.findById(id).get();
    }

    @Override
    public Consommationmazout saveOne(Consommationmazout consommationmazout) {
       return consommationmazoutRepository.save(consommationmazout);
    }

    @Override
    public boolean delete(Long id) {
        Consommationmazout consommationmazout=findOne(id);

        if(consommationmazout!=null){
            consommationmazoutRepository.delete(findOne(id));
            return true;
        }else{
            return false;
        }

    }


}