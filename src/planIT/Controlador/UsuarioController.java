/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import planIT.Modelo.DAO.Impl.Mongo.UsuarioDAOImplMongo;
import planIT.Modelo.Usuario;

/**
 *
 * @author driquelme
 */
public class UsuarioController {
    private UsuarioDAOImplMongo usuDAOI;
    
    public UsuarioController(){
        usuDAOI = new UsuarioDAOImplMongo();
    }
    
    public void insertar(String email, String nombre, String pass){
        String sal = PasswordController.generarSal();
        Usuario usuario = new Usuario(email, nombre, PasswordController.generarHashConSal(pass, sal.getBytes()), sal, "default", "default", "default", "default", "default", "default");
        
        if(usuDAOI.obtener(usuario) == null){
           usuDAOI.insertar(usuario); 
        }else{
            System.err.println("El usuario que se esta intentando introducir ya existe (MISMO EMAIL)");
        }
        
    }
    
    public void actualizar(String email, String nombre, String pass, String sal, String foto, String colorPrincipal, String colorSecundario, String disposicion, String estiloAlerta, String sonidoAlerta){
        Usuario usuario = new Usuario(email, nombre, pass, sal, foto, colorPrincipal, colorSecundario, disposicion, estiloAlerta, sonidoAlerta);
        usuDAOI.actualizar(usuario);        
    }
    
    public Map<String, String> login(String email, String pass){
        Map<String, String> valores = null;
        Usuario usuario = usuDAOI.obtener(new Usuario(email, pass)); 
        if(usuario != null){
            valores = usuDAOI.toMap(usuario);
        }else{
            valores = null;
        }
        return valores;
    }
    
    //Cerrar todo lo abierto?
    public void desconectar(){
    
    }
}
