/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.itextpdf.text.pdf.PdfReader;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.FileDto;
import models.SignatureRequestDto;
import models.SignatureRequestUserDto;
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
        try {
            ApiService api = new ApiService();
            
            FileDto file = api.getFileService().getFileId(41);
            
            int[][] data = file.getDimensionsPdf();
            for (int i = 0; i < data.length; i++) {
                System.out.println("page: "+(i+1)+": x: "+ data[i][0]+": y: "+ data[i][1]);
            }
                    
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
