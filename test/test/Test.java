/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.FileService;
import services.UserService;
import services.impl.ApiService;
import services.impl.FileServiceImpl;
import services.impl.UserServiceImpl;

/**
 *
 * @author USUARIO
 */
public class Test {
    public static void main(String[] args) {
        ApiService api = new ApiService();
        try {
            api.getUserService().getUserId(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
