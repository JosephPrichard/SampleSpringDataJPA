package com.example.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public AnimalEntity create(@RequestBody CreateAnimalDto animal) {
        return animalService.create(animal);
    }

    @GetMapping
    public AnimalEntity findById(@RequestParam("id") long id) {
        var animal = animalService.findById(id);
        if (animal.isPresent()) {
            return animal.get();
        } else {
            throw new AnimalNotFoundException();
        }
    }

    @GetMapping(path = "/bySpecies")
    public List<AnimalEntity> findBySpecies(@RequestParam("species") String species) {
        return animalService.findBySpecies(species);
    }
}
