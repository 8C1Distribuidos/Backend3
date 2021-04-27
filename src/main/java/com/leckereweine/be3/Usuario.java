package com.leckereweine.be3;

public class Usuario {
    private int id;
    private String firstName;
    private String paternalName;
    private String maternalName;
    private String photo;
    private String password;
    private String email;
    private Role role;

    public int getId_usuario() {
        return id;
    }

    public void setId_usuario(int id_usuario) {
        this.id = id_usuario;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPaternalName() {
        return paternalName;
    }

    public void setPaternalName(String paternalName) {
        this.paternalName = paternalName;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario(){

    }
}
