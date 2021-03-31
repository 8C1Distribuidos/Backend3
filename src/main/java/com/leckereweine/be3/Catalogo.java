package com.leckereweine.be3;

public class Catalogo {
    private int id_catalogo;
    private String nombre;

    public Catalogo() {
    }

    public Catalogo(int id_catalogo, String nombre) {
        this.id_catalogo = id_catalogo;
        this.nombre = nombre;
    }

    public int getId_catalogo() {
        return id_catalogo;
    }

    public void setId_catalogo(int id_catalogo) {
        this.id_catalogo = id_catalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
