package com.mycompany.project.Util;

import com.mycompany.project.Usuario;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class File {
    public static void inserir(Usuario usuario) {
        try {
            ArrayList<Usuario> atual = listar();
            atual.add(usuario);
            FileOutputStream fos = new FileOutputStream(Info.arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Erro ao inserir usuário");
        }
    }

    public static ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Usuario>) ois.readObject();
            ois.close();
            return lista;
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } 
        catch (EOFException e) {  
            return lista;
        } 
        catch (IOException | ClassNotFoundException e) {

        } 
        finally {
            try {
                fis.close();
            } 
            catch (IOException ex) {
                System.out.println("Erro ao ler arquivo");
            }
        }
        return lista;
    }
}