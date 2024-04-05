package org.example.kotlinapi.controller.service

import lombok.RequiredArgsConstructor
import org.example.kotlinapi.controller.model.Person
import org.example.kotlinapi.controller.repository.PersonRepository
import org.springframework.stereotype.Service


@Service
@RequiredArgsConstructor
class PersonService(private var repository: PersonRepository) {


    fun findById(id: Long): Person {
        return repository.findById(id).get()
    }

    fun save(person: Person): Person {
        return repository.save(person)
    }




}
