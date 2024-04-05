package org.example.kotlinapi.controller.controller

import lombok.RequiredArgsConstructor
import org.example.kotlinapi.controller.model.Person
import org.example.kotlinapi.controller.service.PersonService
import org.springframework.web.bind.annotation.*


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/persons")
class PersonController(
    private var service: PersonService
){

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id:Long):Person{
        return service.findById(id);
    }

    @PostMapping
    fun create(@RequestBody person:Person):Person{
        return service.save(person);
    }
}