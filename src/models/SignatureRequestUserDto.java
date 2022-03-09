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
public class SignatureRequestUserDto {

    private int id;
    private int pos_x;
    private int pos_y;
    private int num_page;
    private boolean signed;
    private String signature_date;
    private String created_date;
    private int request;
    private int user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public int getNum_page() {
        return num_page;
    }

    public void setNum_page(int num_page) {
        this.num_page = num_page;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public String getSignature_date() {
        return signature_date;
    }

    public void setSignature_date(String signature_date) {
        this.signature_date = signature_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ", \"pos_x\":" + pos_x + ", \"pos_y\":"
                + pos_y + ", \"num_page\":" + num_page + ", \"signed\":\"" + signed
                + "\", \"request\":" + request + ", \"user\":" + user + '}';
    }
    
     public UserDto getUserDto() {
        UserDto model = null;
        try {
            if (user != 0) {
                return new ApiService().getUserService().getUserId(user);
            }
        } catch (Exception e) {
        }
        return null;
    }

}
