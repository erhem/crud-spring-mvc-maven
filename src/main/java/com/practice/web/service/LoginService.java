/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.web.service;

import com.practice.web.model.Login;

/**
 *
 * @author erhem
 */
public interface LoginService {

    public boolean isValidUser(Login login);
    
}
