/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.SignatureRequestDto;

/**
 *
 * @author USUARIO
 */
public interface SignatureRequestService {
    
    List<SignatureRequestDto> getRequest();
    
    List<SignatureRequestDto> getRequestUser(int id);
    
    SignatureRequestDto getRequestId(int id);
    
    SignatureRequestDto saveRequest(SignatureRequestDto user);
    
    SignatureRequestDto updateRequest(SignatureRequestDto user);
    
    void deleteRequest(int id);
    
}
