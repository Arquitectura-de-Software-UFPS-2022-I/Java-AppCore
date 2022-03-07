/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.util.List;
import models.FileDto;

/**
 *
 * @author USUARIO
 */
public interface FileService {
    
    List<FileDto> getFiles();
    
    FileDto getFileId(int id);
    
    FileDto saveFile(String name, File file);
    
    void deleteFile(int id);
    
}
