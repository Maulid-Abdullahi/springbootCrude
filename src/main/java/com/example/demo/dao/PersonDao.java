package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
     int addPerson(UUID id, Person person);
     default int addPerson(Person person){
        UUID uid = UUID.randomUUID();
        return addPerson(uid, person);
    }
   List<Person> selectALlPeople();

     Optional<Person> selectPersonById(UUID id);
     int deletePersonById(UUID id);
     int updatePersonById(UUID id , Person person);
}
