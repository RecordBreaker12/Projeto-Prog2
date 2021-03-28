package com.mycompany.project;

import com.mycompany.project.Util.File;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ArmazenamentoController {
    @FXML
    private TableView<Usuario> tabela;
    @FXML
    private TableColumn<Usuario, String> colunaLogin;
    @FXML
    private TableColumn<Usuario, Float> colunaReserva;
    @FXML
    private TableColumn<Usuario, Float> colunaDivida;

    private List<Usuario> usuarios;

    private ObservableList<Usuario> listaUsuarios;

    @FXML
    public void initialize() {
        usuarios = File.listReservas();
        colunaLogin = new TableColumn("Login");
        colunaReserva = new TableColumn("Reserva");
        colunaDivida = new TableColumn("Divida");
        colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));   
        colunaReserva.setCellValueFactory(new PropertyValueFactory<>("reserva"));
        colunaDivida.setCellValueFactory(new PropertyValueFactory<>("divida"));        
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);    
        listaUsuarios = FXCollections.observableArrayList(usuarios);        
        tabela.getColumns().addAll(colunaLogin, colunaReserva, colunaDivida);
        tabela.setItems(listaUsuarios);                                      
    }

    @FXML
    private void voltar() throws IOException{
        App.setRoot("menu");
    }

    public TableView<Usuario> getTabela() {
        return tabela;
    }

    public void setTabela(TableView<Usuario> tabela) {
        this.tabela = tabela;
    }

    public TableColumn<Usuario, String> getColunaLogin() {
        return colunaLogin;
    }

    public void setColunaLogin(TableColumn<Usuario, String> colunaLogin) {
        this.colunaLogin = colunaLogin;
    }

    public TableColumn<Usuario, Float> getColunaReserva() {
        return colunaReserva;
    }

    public void setColunaReserva(TableColumn<Usuario, Float> colunaReserva) {
        this.colunaReserva = colunaReserva;
    }
    
    public TableColumn<Usuario, Float> getColunaDivida() {
        return colunaDivida;
    }

    public void setColunaDivida(TableColumn<Usuario, Float> colunaDivida) {
        this.colunaDivida = colunaDivida;
    }

    public ObservableList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ObservableList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

