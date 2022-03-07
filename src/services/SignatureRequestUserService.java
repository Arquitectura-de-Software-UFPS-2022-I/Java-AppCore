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
    
    List<SignatureRequestUserDto> getRequest();
    
    List<SignatureRequestUserDto> getRequestUser(int id);
    
    List<SignatureRequestUserDto> getRequest(int id);
    
    SignatureRequestUserDto getRequestId(int id);
    
    SignatureRequestUserDto saveRequest(SignatureRequestUserDto user);
    
    SignatureRequestUserDto updateRequest(SignatureRequestUserDto user);
    
    void deleteRequest(int id);
    
}
