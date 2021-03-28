package com.mycompany.project;

import com.mycompany.project.Util.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastrarController {
    @FXML
    private TextField campoLogin;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoSenha;
    
    @FXML
    private void cadastrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setNome(campoNome.getText());
        usuario.setSenha(campoSenha.getText());
        File.inserir(usuario);
        limparCampos(); 
    }
    
    @FXML
    private void limparCampos(){
        this.campoLogin.setText("");
        this.campoNome.setText("");
        this.campoSenha.setText("");
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
