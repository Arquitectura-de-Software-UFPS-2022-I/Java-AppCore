/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.SignatureRequestDto;
import models.SignatureRequestUserDto;

/**
 *
 * @author USUARIO
 */
public interface SignatureRequestUserService {
    
    List<SignatureRequestUserDto> getRequest() throws Exception;
    
    List<SignatureRequestUserDto> getRequestUser(int id) throws Exception;
    
    List<SignatureRequestUserDto> getRequest(int id) throws Exception;
    
    SignatureRequestUserDto getRequestId(int id) throws Exception;
    
    SignatureRequestUserDto saveRequest(SignatureRequestUserDto user) throws Exception;
    
    SignatureRequestUserDto updateRequest(SignatureRequestUserDto user) throws Exception;
    
    void deleteRequest(int id) throws Exception;
    
}
