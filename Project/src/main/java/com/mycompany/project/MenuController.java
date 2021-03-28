package com.mycompany.project;

import java.io.IOException;
import javafx.fxml.FXML;


public class MenuController {
    @FXML
    private void efetuarReserva() throws IOException{
        App.setRoot("reserva");
    }
    @FXML
    private void cadastrarUsuario() throws IOException{
        App.setRoot("cadastrar");
    }
    @FXML
    private void listarUsuario() throws IOException{
        App.setRoot("listar");
    }
    
    @FXML
    private void efetuarRetirada() throws IOException{
        App.setRoot("retirar");
    }
    
    @FXML
    private void gerenciar() throws IOException{
        App.setRoot("armazenamento");
    }
    
    @FXML
    private void efetuarPagamento() throws IOException{
        App.setRoot("pagar");
    }
    
    @FXML
    private void sair(){
        System.exit(0);
    }
}
