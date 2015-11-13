/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.web.controller;

import com.practice.web.model.Login;
import com.practice.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author erhem
 */
@Controller
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginPage(Model model) {
        Login login = new Login();
        login.setUsername("admin");
        model.addAttribute("login", login);
        return "login";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String postLoginPage(Model model, 
            @ModelAttribute("login") Login login) {
        
        if(loginService.isValidUser(login)) {
            return "redirect:/member-area";
        } else {
            model.addAttribute("message", 
                    "Wrong Username or Password");
            return "login";
        }
    }
    
}
