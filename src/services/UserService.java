/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.UserDto;

/**
 *
 * @author USUARIO
 */
public interface UserService {
    
    List<UserDto> getUser() throws Exception;
    
    UserDto getUserId(int id) throws Exception;
    
    UserDto saveUser(UserDto user) throws Exception;
    
    UserDto updateUser(UserDto user) throws Exception;
    
    void deleteUser(int id) throws Exception;
    
    UserDto loginUser(String password, String username) throws Exception;
    
}
