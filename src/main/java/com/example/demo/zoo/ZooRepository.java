package com.example.demo.zoo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ZooRepository extends CrudRepository<ZooEntity, Long> {

    List<ZooEntity> findByState(String state);

    List<ZooEntity> findByCity(String city);

    Optional<ZooEntity> findById(long id);
}
