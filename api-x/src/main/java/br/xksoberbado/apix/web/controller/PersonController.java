package br.xksoberbado.apix.web.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
//@RequestMapping("v1/persons")
@RequestMapping("v1")
public class PersonController {

    private static final List<Person> PERSONS = List.of(
        Person.of(UUID.randomUUID(), "Joao"),
        Person.of(UUID.randomUUID(), "Maria")
    );

    @GetMapping
    public List<Person> get() {
        log.info("Getting persons.");

        return PERSONS;
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Person {
        private UUID id;
        private String name;
    }
}
