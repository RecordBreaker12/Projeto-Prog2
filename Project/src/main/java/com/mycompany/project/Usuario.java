package com.mycompany.project;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Usuario implements Serializable{
    String login;
    String nome;
    String senha; 
    float reserva = 0;
    float divida = 0;
    Date dataReserva;
    String dataString;
    public Usuario() {
        this.login = "";
        this.nome = "";
        this.senha = "";
    }

    public Usuario(String login, String nome, String senha) {
        this.login = login; 
        this.nome = nome;
        this.senha = senha; 
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public float getReserva() {
        return reserva;
    }

    public void setReserva(float reserva) {
        this.reserva = reserva;
    }
    
    public float getDivida() {
        return divida;
    }

    public void setDivida(float divida) {
        this.divida = divida;
    }
    
    public Date getData() {
        return dataReserva;
    }

    public void setData() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dataReserva = c.getTime();
        dataString = sdf.format(dataReserva);
    }
}

