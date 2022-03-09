/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import java.util.List;
import models.SignatureRequestDto;
import services.SignatureRequestService;
import utils.ServiceHttp;

/**
 *
 * @author USUARIO
 */
public class SignatureRequestServiceImpl extends ServiceHttp implements SignatureRequestService{

    @Override
    public List<SignatureRequestDto> getRequest() throws Exception {
        return HttpGetList("/api/v1/signature_requests/?format=json", SignatureRequestDto[].class);
    }
    
    @Override
    public List<SignatureRequestDto> getRequestUser(int id) throws Exception {
        return HttpGetList("/api/v1/signature_requests_by_user/"+id+"/?format=json", SignatureRequestDto[].class);
    }

    @Override
    public SignatureRequestDto getRequestId(int id) throws Exception {
        return HttpGetOne("/api/v1/signature_requests/"+id+"/?format=json", SignatureRequestDto.class);
    }

    @Override
    public SignatureRequestDto saveRequest(SignatureRequestDto user) throws Exception {
        return HttpPost("/api/v1/signature_requests/?format=json", SignatureRequestDto.class, user);
    }

    @Override
    public SignatureRequestDto updateRequest(SignatureRequestDto user) throws Exception {
        return HttpPut("/api/v1/signature_requests/"+user.getId()+"?format=json", SignatureRequestDto.class, user);
    }

    @Override
    public void deleteRequest(int id) throws Exception {
        HttpDelete("/api/v1/signature_requests/"+id+"?format=json");
    }
    
}
