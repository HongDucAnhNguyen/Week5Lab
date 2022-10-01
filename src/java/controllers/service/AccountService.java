/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.service;

import models.User;

/**
 *
 * @author nguye
 */
public class AccountService {
    User user = new User();
    public AccountService(){}
    public User login(String username, String password){
        if((username.equals("abe") || username.equals("barb")) && password.equals("password")){
            user = new User(username, password);
        }
        else{
            return null;
        }
        return user;
    }
}
