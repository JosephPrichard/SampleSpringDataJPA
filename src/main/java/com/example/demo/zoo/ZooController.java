package com.example.demo.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class ZooController {
    private final ZooService zooService;

    @Autowired
    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }


    @PostMapping
    public ZooEntity create(@RequestBody CreateZooDto zoo) {
        return zooService.create(zoo);
    }

    @GetMapping
    public ZooEntity findById(@RequestParam("id") long id) {
        var zoo = zooService.findById(id);
        if (zoo.isPresent()) {
            return zoo.get();
        } else {
            throw new ZooNotFoundException();
        }
    }

    @GetMapping(path = "/byState")
    public List<ZooEntity> findByState(@RequestParam("state") String state) {
        return zooService.findByState(state);
    }

    @GetMapping(path = "/byCity")
    public List<ZooEntity> findByCity(@RequestParam("city") String city) {
        return zooService.findByCity(city);
    }
}
