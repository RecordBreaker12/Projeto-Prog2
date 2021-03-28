package com.mycompany.project;

import com.mycompany.project.Util.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class PagarController {
    @FXML
    private TextField campoLogin;

    @FXML
    private TextField campoSenha;
    
    @FXML
    private void efetuarPagamento () throws IOException{
        Usuario usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setSenha(campoSenha.getText());
        usuario = File.procurar(usuario);
        if(usuario==null){
            System.out.println("Acesso negado");
        }
        else{
            File.quitar(usuario);
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
