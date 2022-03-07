/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import com.google.gson.Gson;
import java.util.List;
import models.UserDto;
import services.UserService;
import utils.ServiceHttp;
import static utils.ServiceHttp.HttpGetList;

/**
 *
 * @author USUARIO
 */
public class UserServiceImpl extends ServiceHttp implements UserService {

    @Override
    public List<UserDto> getUser() {
        return HttpGetList("/api/v1/users/?format=json", UserDto[].class);
    }

    @Override
    public UserDto getUserId(int id) {
        return HttpGetOne("/api/v1/users/?format=json", UserDto.class);
    }

    @Override
    public UserDto saveUser(UserDto user) {
        return HttpPost("/api/v1/users/?format=json", UserDto.class, user);
    }

    @Override
    public UserDto updateUser(UserDto user) {
        return HttpPut("/api/v1/users/" + user.getId() + "/?format=json", UserDto.class, user);
    }

    @Override
    public void deleteUser(int id) {
        HttpDelete("/api/v1/users/" + id + "/?format=json");
    }

    @Override
    public UserDto loginUser(String password, String username) {
        String result = HttpPost("/api/v1/auth/user/?format=json", "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");
        System.out.println("dd"+ result);
        if (result!= null) {
            return (UserDto) new Gson().fromJson(result, UserDto.class);
        }
        return null;
    }

}
