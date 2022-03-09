/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import services.impl.ApiService;

/**
 *
 * @author USUARIO
 */
public class UserDto {

    private int id;
    private String full_name;
    private String username;
    private String email;
    private String password;
    private Integer signature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSignature() {
        return signature;
    }

    public void setSignature(Integer signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ", \"full_name\":\"" + full_name
                + "\", \"username\":\"" + username + "\", \"email\":\"" + email
                + "\", \"password\":\"" + password + "\", \"signature\":"
                + signature + "}";
    }

    public FileDto getSignatureDto() {
        try {
            if (signature != 0) {
                return new ApiService().getFileService().getFileId(signature);
            }
        } catch (Exception e) {
        }
        return null;
    }

}
