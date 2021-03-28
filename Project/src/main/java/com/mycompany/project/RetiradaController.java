package com.mycompany.project;

import com.mycompany.project.Util.File;
import static com.mycompany.project.Util.File.listReservas;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RetiradaController {
    @FXML
    private TextField campoLogin;

    @FXML
    private TextField campoSenha;
    
    @FXML
    private TextField campoReserva;
    
    @FXML
    private void efetuarPagamento () throws IOException{
        Usuario usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setSenha(campoSenha.getText());
        if(File.procurar(usuario)==null){
            System.out.println("Acesso negado");
        }
        else if(File.procurarReserva(usuario)==null){
            System.out.println("Reserva ainda não feita");
        }
        else{
            File.retirar(Float.parseFloat(campoReserva.getText()), usuario);
            App.setRoot("menu");
        }
    }
    
    @FXML
    private void deixarAberto () throws IOException{
        Usuario usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setSenha(campoSenha.getText());
        if(File.procurar(usuario)==null){
            System.out.println("Acesso negado");
        }
        else if(File.procurarReserva(usuario)==null){
            System.out.println("Reserva ainda não feita");
        }
        else{
            ArrayList<Usuario> atual = listReservas();
            for(Usuario u : atual){
                if(u.getLogin().equals(usuario.getLogin())&&u.getSenha().equals(usuario.getSenha())){
                    usuario = u;
                }
            }
            File.aberto(Float.parseFloat(campoReserva.getText()), usuario);
            App.setRoot("menu");
        }
    }
    
    @FXML
    private void voltar() throws IOException{
        App.setRoot("menu");
    }
    
    @FXML
    private void fechar(){
        System.exit(0); 
    }
}
