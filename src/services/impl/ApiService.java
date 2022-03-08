/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import services.FileService;
import services.SignatureRequestService;
import services.SignatureRequestUserService;
import services.UserService;

/**
 *
 * @author USUARIO
 */
public class ApiService {
    
    private final FileService fileService;
    private final SignatureRequestService signatureRequestService;
    private final SignatureRequestUserService signatureRequestUser;
    private final UserService userService;

    public ApiService() {
        this.fileService = new FileServiceImpl();
        this.signatureRequestService = new SignatureRequestServiceImpl();
        this.signatureRequestUser = new SignatureRequestUserServiceImpl();
        this.userService = new UserServiceImpl();
    }

    public FileService getFileService() {
        return fileService;
    }

    public SignatureRequestService getSignatureRequestService() {
        return signatureRequestService;
    }

    public SignatureRequestUserService getSignatureRequestUser() {
        return signatureRequestUser;
    }

    public UserService getUserService() {
        return userService;
    }
    
    
    
    
    
}
