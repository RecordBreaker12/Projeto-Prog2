package com.mycompany.project;

import com.mycompany.project.Util.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ReservaController {
    @FXML
    private TextField campoLogin;

    @FXML
    private TextField campoSenha;
    
    @FXML
    private TextField campoReserva;
    
    @FXML
    private void efetuarReserva () throws IOException{
        Usuario usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setSenha(campoSenha.getText());
        usuario = File.procurar(usuario);
        if(usuario==null){
            System.out.println("Acesso negado");
        }
        else{
            File.reservar(Float.parseFloat(campoReserva.getText()), usuario);
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
