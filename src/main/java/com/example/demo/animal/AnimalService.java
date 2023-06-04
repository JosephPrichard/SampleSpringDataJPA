package com.example.demo.animal;

import com.example.demo.zoo.ZooNotFoundException;
import com.example.demo.zoo.ZooRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final ModelMapper mapper = new ModelMapper();
    private final AnimalRepository animalRepo;
    private final ZooRepository zooRepo;

    @Autowired
    public AnimalService(AnimalRepository animalRepo, ZooRepository zooRepo) {
        this.animalRepo = animalRepo;
        this.zooRepo = zooRepo;
    }

    public AnimalEntity create(CreateAnimalDto animal) {
        var animalEntity = mapper.map(animal, AnimalEntity.class);
        var zooEntity = zooRepo.findById(animal.getZooId());
        if (zooEntity.isEmpty()) {
            throw new ZooNotFoundException();
        }
        animalEntity.setZoo(zooEntity.get());
        animalRepo.save(animalEntity);
        return animalEntity;
    }

    public Optional<AnimalEntity> findById(long id) {
        return animalRepo.findById(id);
    }

    public List<AnimalEntity> findBySpecies(String species) {
        return animalRepo.findBySpecies(species);
    }

}
