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
import services.impl.FileServiceImpl;
import services.impl.UserServiceImpl;

/**
 *
 * @author USUARIO
 */
public class Test {
    public static void main(String[] args) {
        try {
            FileService s = new FileServiceImpl();
            System.out.println(s.validateAsignature(new File("C:\\Users\\USUARIO\\Desktop\\Firma_Yhojan_Díaz.jpg")));
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
