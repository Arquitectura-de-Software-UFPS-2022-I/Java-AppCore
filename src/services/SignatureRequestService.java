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
    
    List<SignatureRequestDto> getRequest() throws Exception;
    
    List<SignatureRequestDto> getRequestUser(int id) throws Exception;
    
    SignatureRequestDto getRequestId(int id) throws Exception;
    
    SignatureRequestDto saveRequest(SignatureRequestDto user) throws Exception;
    
    SignatureRequestDto updateRequest(SignatureRequestDto user) throws Exception;
    
    void deleteRequest(int id) throws Exception;
    
}
