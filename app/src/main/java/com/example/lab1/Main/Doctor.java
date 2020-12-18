package com.example.lab1.Main;

public class Doctor {

    private String name; // название
    private String speciality;  // столица
    private int fotoResource; // ресурс флага

    public Doctor(String name, String speciality, int foto){

        this.name=name;
        this.speciality=speciality;
        this.fotoResource=foto;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getFotoResource() {
        return this.fotoResource;
    }

    public void setFotoResource(int fotoResource) {
        this.fotoResource = fotoResource;
    }
}
