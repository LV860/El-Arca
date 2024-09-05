package com.example.demo.entidad;

public class NotFoundException extends RuntimeException {

    private String cedula;

    public NotFoundException(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {    
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
