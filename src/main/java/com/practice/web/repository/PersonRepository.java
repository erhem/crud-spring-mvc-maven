/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.web.repository;

import com.practice.web.model.Person;
import java.util.List;

/**
 *
 * @author erhem
 */
public interface PersonRepository {

    public List<Person> getListPerson();

    public String validateNewPerson(Person person);

    public void savePerson(Person person);

    public Person getPersonById(Integer idPerson);

    public void updateData(Person person);

    public void deleteData(Integer idPerson);
    
}
