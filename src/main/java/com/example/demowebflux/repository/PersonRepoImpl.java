package com.example.demowebflux.repository;

import com.example.demowebflux.controller.PersonController;
import com.example.demowebflux.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepoImpl implements IPersonaRepo{

    private static final Logger LOG = LoggerFactory.getLogger(PersonRepoImpl.class);
    @Override
    public Mono<Person> register(Person person) {
        LOG.info(person.toString());
        return Mono.just(person);
    }

    @Override
    public Mono<Person> update(Person person) {
        LOG.info(person.toString());
        return Mono.just(person);
    }

    @Override
    public Flux<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Cristhian"));
        personList.add(new Person(2, "Sandra"));
        personList.add(new Person(3, "Carlos"));
        return Flux.fromIterable(personList);
    }

    @Override
    public Mono<Person> getById(Integer id) {
        return Mono.just(new Person(id, "Cristhian"));
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return Mono.empty();
    }
}
