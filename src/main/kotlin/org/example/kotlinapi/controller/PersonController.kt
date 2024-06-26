package org.example.kotlinapi.controller

import lombok.RequiredArgsConstructor
import org.example.kotlinapi.dto.PersonResponse
import org.example.kotlinapi.model.Person
import org.example.kotlinapi.service.PersonService
import org.springframework.web.bind.annotation.*


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/persons")
class PersonController(
    private var service: PersonService
) {

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): PersonResponse {
        return service.findById(id);
    }

    @PostMapping
    fun create(@RequestBody person: Person): PersonResponse {
        return service.save(person);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody person: Person): PersonResponse {
        return service.updatePerson(id, person);
    }

    @GetMapping
    fun findAll(): List<PersonResponse> {
        return service.findAll()
    }

}