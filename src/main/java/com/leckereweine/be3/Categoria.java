package com.leckereweine.be3;

public class Categoria {
    private int id_categoria;
    private String nombre;
    Catalogo catalogo;

    public Categoria(int id_categoria, String nombre, Catalogo catalogo) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.catalogo = catalogo;
    }

    public Categoria(){

    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
}
