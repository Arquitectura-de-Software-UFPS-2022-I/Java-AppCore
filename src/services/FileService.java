/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.util.List;
import models.FileDto;
import models.FirmaDto;

/**
 *
 * @author USUARIO
 */
public interface FileService {
    
    List<FileDto> getFiles() throws Exception;
    
    FileDto getFileId(int id) throws Exception;
    
    FirmaDto validateAsignature(File file) throws Exception;
    
    FileDto saveFile(String name, File file) throws Exception;
    
    void deleteFile(int id) throws Exception;
    
}
