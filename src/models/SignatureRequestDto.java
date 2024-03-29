/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import services.impl.ApiService;

/**
 *
 * @author USUARIO
 */
public class SignatureRequestDto {

    private int id;
    private String subject;
    private int document;
    private int user;
    private String create_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ", \"subject\":\"" + subject + "\", \"document\":" + document + ", \"user\":" + user + "}";
    }

    public FileDto getDocumentDto() {
        try {
            if (document != 0) {
                return new ApiService().getFileService().getFileId(document);
            }
        } catch (Exception e) {
        }
        return null;
    }

}
