/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.web.service.impl;

import com.practice.web.model.Login;
import com.practice.web.repository.LoginRepository;
import com.practice.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author erhem
 */
@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    LoginRepository loginRepository;

    public boolean isValidUser(Login login) {
        return loginRepository.isValidUser(login);
    }
    
}
