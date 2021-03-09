package com.mycompany.project;

import java.io.IOException;
import javafx.fxml.FXML;


public class MenuController {
    @FXML
    private void cadastrarUsuario() throws IOException{
        App.setRoot("cadastrar");
    }
    @FXML
    private void listarUsuario() throws IOException{
        App.setRoot("listar");
    }
    
    @FXML
    private void sair(){
        System.exit(0);
    }
}
