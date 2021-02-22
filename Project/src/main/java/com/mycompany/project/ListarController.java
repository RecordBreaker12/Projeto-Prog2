package com.mycompany.project;

import com.mycompany.project.Util.File;
import com.mycompany.project.modelo.Usuario;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListarController {
    @FXML
    private TableView<Usuario> tabela;
    @FXML
    private TableColumn<Usuario, String> colunaNome;
    @FXML
    private TableColumn<Usuario, String> colunaLogin;

    private List<Usuario> usuarios;

    private ObservableList<Usuario> listaUsuarios;

    @FXML
    public void initialize() {
        usuarios = File.listar();
        colunaNome = new TableColumn("Nome");
        colunaLogin = new TableColumn("Login");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));   
        colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));        
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);    
        listaUsuarios = FXCollections.observableArrayList(usuarios);        
        tabela.getColumns().addAll(colunaNome, colunaLogin);
        tabela.setItems(listaUsuarios);                                      
    }

    @FXML
    private void menu() throws IOException {
        App.setRoot("menu");
    }

    public TableView<Usuario> getTabela() {
        return tabela;
    }

    public void setTabela(TableView<Usuario> tabela) {
        this.tabela = tabela;
    }

    public TableColumn<Usuario, String> getColunaNome() {
        return colunaNome;
    }

    public void setColunaNome(TableColumn<Usuario, String> colunaNome) {
        this.colunaNome = colunaNome;
    }

    public TableColumn<Usuario, String> getColunaLogin() {
        return colunaLogin;
    }

    public void setColunaLogin(TableColumn<Usuario, String> colunaLogin) {
        this.colunaLogin = colunaLogin;
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
