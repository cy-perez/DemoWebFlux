package com.example.demowebflux.controller;

import com.example.demowebflux.model.Person;
import com.example.demowebflux.repository.IPersonaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private IPersonaRepo personaRepo;

    @GetMapping
    public Flux<Person> listar(){
        return personaRepo.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Person> listarPorId(@PathVariable("id") Integer id){
        return personaRepo.getById(id);
    }

    @PostMapping
    public Mono<Person> registrarPersona(@RequestBody Person person){
        return personaRepo.register(person);
    }

    @PutMapping
    public Mono<Person> actualizarPersona(@RequestBody Person person){
        return personaRepo.update(person);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarPorId(@PathVariable("id") Integer id){
        return personaRepo.getById(id)
                .flatMap(p -> personaRepo.delete(p.getId()));
    }
}