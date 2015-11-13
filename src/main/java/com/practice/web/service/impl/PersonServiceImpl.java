/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.web.service.impl;

import com.practice.web.model.Person;
import com.practice.web.repository.PersonRepository;
import com.practice.web.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author erhem
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
    
    public List<Person> getListPerson() {
        return personRepository.getListPerson();
    }

    public String validateNewPerson(Person person) {
        return personRepository.validateNewPerson(person);
    }

    public void savePerson(Person person) {
        personRepository.savePerson(person);
    }

    public Person getPersonById(Integer idPerson) {
        return personRepository.getPersonById(idPerson);
    }

    public void updateData(Person person) {
        personRepository.updateData(person);
    }

    public void deleteData(Integer idPerson) {
        personRepository.deleteData(idPerson);
    }
    
}
