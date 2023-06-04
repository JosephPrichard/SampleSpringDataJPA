package com.example.demo.zoo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZooService {

    private final ModelMapper mapper = new ModelMapper();
    private final ZooRepository repo;

    @Autowired
    public ZooService(ZooRepository repo) {
        this.repo = repo;
    }

    public ZooEntity create(CreateZooDto animal) {
        var entity = mapper.map(animal, ZooEntity.class);
        repo.save(entity);
        return entity;
    }

    public Optional<ZooEntity> findById(long id) {
        return repo.findById(id);
    }

    public List<ZooEntity> findByState(String state) {
        return repo.findByState(state);
    }

    public List<ZooEntity> findByCity(String city) {
        return repo.findByCity(city);
    }
}
