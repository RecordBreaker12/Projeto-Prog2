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
import java.util.Calendar;

public class File {
    public static void inserir(Usuario usuario) {
        try {
            ArrayList<Usuario> atual = listar();
            atual.add(usuario);
            FileOutputStream fos = new FileOutputStream(Info.arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        }
        catch (IOException ex) {
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
    public static Usuario procurar(Usuario usuario) throws FileNotFoundException{
        ArrayList<Usuario> lista = listar();
        for(Usuario u : lista){
            if(u.getLogin().equals(usuario.getLogin())&&u.getSenha().equals(usuario.getSenha())){
                return u;
            }
        }
        return null;
    }
    public static ArrayList<Usuario> listReservas(){
        ArrayList<Usuario> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.silo);
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
    
    public static Usuario procurarReserva(Usuario usuario) throws FileNotFoundException{
        ArrayList<Usuario> lista = listReservas();
        for(Usuario u : lista){
            if(u.getLogin().equals(usuario.getLogin())&&u.getSenha().equals(usuario.getSenha())){
                return u;
            }
        }
        return null;
    }
    
    public static float verCapacidade(){
        float val = 0;
        ArrayList<Usuario> atual = listReservas();
        for(Usuario u : atual){
            val+=u.getReserva();
        }
        return val;
    }
    
    public static void reservar(float val, Usuario usuario){
        if (val+verCapacidade()>=40){
            System.out.println("Espaço indisponivel");
        }
        else{
            try {
                ArrayList<Usuario> atual = listReservas();
                for(Usuario u : atual){
                    if(u.getLogin().equals(usuario.getLogin())&&u.getSenha().equals(usuario.getSenha())){
                        usuario = u;
                    }
                }
                if(procurarReserva(usuario)==null){
                    usuario.setData();
                    atual.add(usuario);
                }
                usuario.setReserva(val+usuario.getReserva());
                FileOutputStream fos = new FileOutputStream(Info.silo);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(atual);
                oos.close();
            } 
            catch (IOException ex) {
                System.out.println("Erro ao efetuar reserva");
            }
        }
    }
    
    public static void retirar(float val, Usuario usuario) throws FileNotFoundException, IOException{
        float divida;
        ArrayList<Usuario> atual = listReservas();
        for(Usuario u : atual){
            if(u.getLogin().equals(usuario.getLogin())&&u.getSenha().equals(usuario.getSenha())){
                usuario = u;
            }
        }
        if (val>usuario.getReserva()){
            System.out.println("Reserva insuficiente");
        }
        else{
            usuario.setReserva(usuario.getReserva()-val);
            if(usuario.getReserva()==0&&usuario.getDivida()==0){
                atual.remove(usuario);
            }
            try{
                FileOutputStream fos = new FileOutputStream(Info.silo);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(atual);
                oos.close();
            }
            catch (IOException ex) {
                System.out.println("Erro ao efetuar retirada");
            }
        }
    }
    
    public static void aberto(float val, Usuario usuario) throws FileNotFoundException, IOException{
        float divida;
        ArrayList<Usuario> atual = listReservas();
        for(Usuario u : atual){
            if(u.getLogin().equals(usuario.getLogin())&&u.getSenha().equals(usuario.getSenha())){
                usuario = u;
            }
        }
        if (val>usuario.getReserva()){
            System.out.println("Reserva insuficiente");
        }
        else{
            usuario.setReserva(usuario.getReserva()-val);
            Calendar c = Calendar.getInstance();
            long dif = c.getTimeInMillis()-usuario.getData().getTime();
            long meses = 3+dif/(30*24*60*60*1000);
            divida = val*meses*200;
            usuario.setDivida(divida+usuario.getDivida());
            if(usuario.getReserva()==0&&usuario.getDivida()==0){
                atual.remove(usuario);
            }
            try{
                FileOutputStream fos = new FileOutputStream(Info.silo);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(atual);
                oos.close();
            }
            catch (IOException ex) {
                System.out.println("Erro ao efetuar retirada");
            }
        }
    }
    
    public static void quitar(Usuario usuario){
        ArrayList<Usuario> atual = listReservas();
        for(Usuario u : atual){
            if(u.getLogin().equals(usuario.getLogin())&&u.getSenha().equals(usuario.getSenha())){
                usuario = u;
            }
        }
        usuario.setDivida(0);
        if(usuario.getReserva()==0){
            atual.remove(usuario);
        }
        try{
            FileOutputStream fos = new FileOutputStream(Info.silo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        }
        catch (IOException ex) {
            System.out.println("Erro ao efetuar retirada");
        }
    }
}
