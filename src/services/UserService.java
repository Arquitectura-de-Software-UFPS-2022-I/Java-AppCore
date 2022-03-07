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
    
    List<UserDto> getUser();
    
    UserDto getUserId(int id);
    
    UserDto saveUser(UserDto user);
    
    UserDto updateUser(UserDto user);
    
    void deleteUser(int id);
    
    UserDto loginUser(String password, String username);
    
}
