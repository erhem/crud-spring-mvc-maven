/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.web.repository.impl;

import com.practice.web.model.Login;
import com.practice.web.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author erhem
 */
@Repository
public class JdbcLoginRepository implements LoginRepository {

    @Autowired
    JdbcTemplate jdbc;
    
    public boolean isValidUser(Login login) {
        String sql = "select count(*) from user_login " 
                + " where username=? and password=?";
        
        int temp = jdbc.queryForObject(sql, Integer.class, 
                login.getUsername(), login.getPassword());
        
        if(temp == 1) {
            return true;
        } else {
            return false;
        }
    }
    
}
