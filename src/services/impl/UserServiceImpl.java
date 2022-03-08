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
    public List<UserDto> getUser() throws Exception {
        return HttpGetList("/api/v1/users/?format=json", UserDto[].class);
    }

    @Override
    public UserDto getUserId(int id) throws Exception {
        return HttpGetOne("/api/v1/users/"+id+"/?format=json", UserDto.class);
    }

    @Override
    public UserDto saveUser(UserDto user) throws Exception {
        return HttpPost("/api/v1/users/?format=json", UserDto.class, user);
    }

    @Override
    public UserDto updateUser(UserDto user) throws Exception {
        return HttpPut("/api/v1/users/" + user.getId() + "/?format=json", UserDto.class, user);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        HttpDelete("/api/v1/users/" + id + "/?format=json");
    }

    @Override
    public UserDto loginUser(String password, String username) throws Exception {
        String result = HttpPost("/api/v1/auth/user/?format=json", "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");
        if (result!= null) {
            return (UserDto) new Gson().fromJson(result, UserDto.class);
        }
        return null;
    }

}
