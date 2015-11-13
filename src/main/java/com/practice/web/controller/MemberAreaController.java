/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.web.controller;

import com.practice.web.model.Person;
import com.practice.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author erhem
 */
@Controller
public class MemberAreaController {
    
    @Autowired
    PersonService personService;
    
    @RequestMapping(value="/member-area", method=RequestMethod.GET)
    public String getMemberAreaPage(Model model) {
        model.addAttribute("listData", personService.getListPerson());
        return "member-area";
    }
    
    @RequestMapping(value="/add-data", method=RequestMethod.GET)
    public String getAddDataPage(Model model) {
        model.addAttribute("person", new Person());
        return "add-data";
    }
    
    @RequestMapping(value="/add-data", method=RequestMethod.POST)
    public String postAddDataPage(Model model, 
            @ModelAttribute("person") Person person) {
        
        String message = personService.validateNewPerson(person);
        if(message.equals("")) {
            personService.savePerson(person);
            return "redirect:/member-area";
        } else {
            model.addAttribute("message", "Nama sudah terdaftar di database");
            return "add-data";
        }
    }
    
    
    @RequestMapping(value="/edit-data/{id}", method=RequestMethod.GET)
    public String getEditDataPage(Model model, 
            @PathVariable("id") Integer idPerson) {
        
        model.addAttribute("person", personService.getPersonById(idPerson));
        return "edit-data";
    }
    
    
    @RequestMapping(value="/edit-data/{id}", method=RequestMethod.POST)
    public String postEditDataPage(Model model, 
            @PathVariable("id") Integer idPerson, 
            @ModelAttribute("person") Person person) {
        
        personService.updateData(person);
        return "redirect:/member-area";
    }
    
    @RequestMapping(value="/delete-data/{id}", method=RequestMethod.GET)
    public String getDeleteDataPage(Model model, 
            @PathVariable("id") Integer idPerson) {
        
        personService.deleteData(idPerson);
        return "redirect:/member-area";
    }
    
}
