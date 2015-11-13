/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.web.repository.impl;

import com.practice.web.model.Person;
import com.practice.web.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author erhem
 */
@Repository
public class JdbcPersonRepository implements PersonRepository {

    @Autowired
    JdbcTemplate jdbc;
    
    public List<Person> getListPerson() {
        return jdbc.query("select * from person order by id", 
                new BeanPropertyRowMapper(Person.class));
    }

    public String validateNewPerson(Person person) {
        try {
            String temp = jdbc
                    .queryForObject("select name from person "
                    + "where name = ?", String.class, 
                    person.getName());
            
            return "Nama sudah terdaftar di database";
            
        } catch(EmptyResultDataAccessException e) {
            return "";
        }
    }

    public void savePerson(Person person) {
        jdbc.update("insert into person (id, name) "
                + "values (?, ?)", person.getId(), 
                person.getName());
    }

    public Person getPersonById(Integer idPerson) {
        String sql = "select * from person where id = ?";
        return jdbc.queryForObject(sql, 
                new BeanPropertyRowMapper<Person>
                (Person.class), idPerson);
    }

    public void updateData(Person person) {
        
        jdbc.update("update person set name = ? "
                + "where id = ?", person.getName(), 
                person.getId());
    }

    public void deleteData(Integer idPerson) {
        jdbc.update("delete from person where id = ?", 
                idPerson);
    }

}
