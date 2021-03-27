package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson( @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return  personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping("{id}")
    public void DeletePerson(@PathVariable("id") UUID id){
         personService.deletePerson(id);
    }

    @PutMapping(path ="{id}")
    public int UpdatePersonById(@PathVariable("id") UUID id, Person personToUpdate){
        return personService.updatePersonId(id, personToUpdate);
    }
}
