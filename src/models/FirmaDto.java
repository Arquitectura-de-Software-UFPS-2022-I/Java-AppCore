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
public class FirmaDto {

    private int class_label;
    private float confidence;

    public int getClass_label() {
        return class_label;
    }

    public void setClass_label(int class_label) {
        this.class_label = class_label;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return "{" + "\"class_label\":" + class_label + ", \"confidence\":" + confidence + '}';
    }

}
