package br.xksoberbado.apix.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("v1/persons")
public class PersonController {

    private static List<Person> persons = List.of(
        new Person(UUID.randomUUID(), "Joao"),
        new Person(UUID.randomUUID(), "Maria")
    );

    @GetMapping
    public List<Person> get() {
        log.info("Getting persons.");

        return persons;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> add(@RequestHeader(required = false) final String oheader,
                            @RequestBody final Person person) {
        log.info("Adding person.");

        persons = Stream.concat(
            persons.stream(),
            Stream.of(person)
        ).toList();

        return persons;
    }

    private record Person(UUID id,
                          String name) {
    }
}
