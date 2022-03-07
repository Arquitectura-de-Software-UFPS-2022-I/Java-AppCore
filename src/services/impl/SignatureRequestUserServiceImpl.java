/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import java.util.List;
import models.SignatureRequestUserDto;
import services.SignatureRequestUserService;
import utils.ServiceHttp;

/**
 *
 * @author USUARIO
 */
public class SignatureRequestUserServiceImpl extends ServiceHttp implements SignatureRequestUserService{

    @Override
    public List<SignatureRequestUserDto> getRequest() throws Exception {
        return HttpGetList("/api/v1/signature_request_users_by_user/?format=json", SignatureRequestUserDto[].class);
    }

    @Override
    public List<SignatureRequestUserDto> getRequestUser(int id) throws Exception {
        return HttpGetList("/api/v1/signature_request_users_by_user/"+id+"/?format=json", SignatureRequestUserDto[].class);
    }

    @Override
    public List<SignatureRequestUserDto> getRequest(int id) throws Exception {
        return HttpGetList("/api/v1/signature_request_users_by_request/"+id+"/?format=json", SignatureRequestUserDto[].class);
    }

    @Override
    public SignatureRequestUserDto getRequestId(int id) throws Exception {
        return HttpGetOne("/api/v1/signature_request_users/"+id+"/?format=json", SignatureRequestUserDto.class);
    }

    @Override
    public SignatureRequestUserDto saveRequest(SignatureRequestUserDto user) throws Exception {
        return HttpPut("/api/v1/signature_request_users/?format=json", SignatureRequestUserDto.class, user);
    }

    @Override
    public SignatureRequestUserDto updateRequest(SignatureRequestUserDto user) throws Exception {
        return HttpPut("/api/v1/signature_request_users/"+user.getId()+"/?format=json", SignatureRequestUserDto.class, user);
    }

    @Override
    public void deleteRequest(int id) throws Exception {
        HttpDelete("/api/v1/signature_request_users/"+id+"/?format=json");
    }
    
}
