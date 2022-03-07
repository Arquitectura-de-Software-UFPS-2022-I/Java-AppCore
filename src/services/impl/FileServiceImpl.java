/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import java.io.File;
import java.util.List;
import models.FileDto;
import services.FileService;
import utils.ServiceHttp;

/**
 *
 * @author USUARIO
 */
public class FileServiceImpl extends ServiceHttp implements FileService {

    @Override
    public List<FileDto> getFiles() throws Exception{
        return HttpGetList("/api/v1/files/?format=json", FileDto[].class);
    }

    @Override
    public FileDto getFileId(int id) throws Exception {
        return HttpGetOne("/api/v1/files/"+id+"/?format=json", FileDto.class);
    }

    @Override
    public FileDto saveFile(String name, File file) throws Exception {
        return HttpPost("/api/v1/files/?format=json", name, file);
    }

    @Override
    public void deleteFile(int id) throws Exception {
        HttpDelete("/api/v1/files/"+id+"/");
    }
    
}
