package com.example.demowebflux.repository;

import com.example.demowebflux.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonaRepo {

    Mono<Person> register(Person person);
    Mono<Person> update(Person person);
    Flux<Person> getAll();
    Mono<Person> getById(Integer id);
    Mono<Void> delete(Integer id);
}
