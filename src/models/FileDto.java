/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author USUARIO
 */
public class FileDto {

    private int id;
    private String name;
    private String uuid_image;
    private String file;
    private String create_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid_image() {
        return uuid_image;
    }

    public void setUuid_image(String uuid_image) {
        this.uuid_image = uuid_image;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ", \"name\":\"" + name + "\", \"uuid_image\":\"" + uuid_image + "\", \"file\":\"" + file + "\", \"create_date\":\"" + create_date + "\"}";
    }

}
