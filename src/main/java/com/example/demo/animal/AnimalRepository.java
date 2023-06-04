package com.example.demo.animal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends CrudRepository<AnimalEntity, Long> {

    List<AnimalEntity> findBySpecies(String species);

    Optional<AnimalEntity> findById(long id);
}
