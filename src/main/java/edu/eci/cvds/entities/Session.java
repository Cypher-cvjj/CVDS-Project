package edu.eci.cvds.entities;

import java.io.Serializable;

public class Session implements Serializable{

    private int rol;
    private String email;
    private String password;
    private String username;
    private String career;
    private String document;

    private int community = 0;
    private int admin = 1;
    private int student = 2;

    public void logIn(int rol, String email, String password, String username, String career, String document) {
        this.rol = rol;
        this.email = email;
        this.password = password;
        this.username = username;
        this.career = career;
        this.document = document;
    }

    public void logOut(){
        this.rol = community;
        this.email = "";
        this.password = "";
        this.username = "";
        this.career = "";
    }

    public boolean isadmin(){
        if (rol == admin){
            return true;
        }else{
            return false;
        }
    }

    public boolean isstudent(){
        if (rol == student){
            return true;
        }else{
            return false;
        }
    }

    public boolean iscommunity(){
        if (rol == community){
            return true;
        }else{
            return false;
        }
    }

    public int getRol() {
        return rol;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return  password;
    }

    public String getUsername(){
        return username;
    }

    public String getCareer(){
        return career;
    }

    public String getDocument() {
        return document;
    }

    public void setRol(int rol){
        this.rol = rol;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setCareer(String career){
        this.career = career;
    }

    public void setDocument(String document){
        this.document = document;
    }
}
