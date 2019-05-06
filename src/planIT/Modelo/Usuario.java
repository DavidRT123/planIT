/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo;

/**
 *
 * @author David
 */
public class Usuario{
    
    private int id;
    private String email;
    private String pass;
    private String sal;
    private String foto;
    private String colorPrincipal;
    private String colorSecundario;
    private String disposicion;
    private String estiloAlerta;
    private String sonidoAlerta;

    public Usuario(int id, String email, String pass, String sal, String foto, String colorPrincipal, String colorSecundario, String disposicion, String estiloAlerta, String sonidoAlerta) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.sal = sal;
        this.foto = foto;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.disposicion = disposicion;
        this.estiloAlerta = estiloAlerta;
        this.sonidoAlerta = sonidoAlerta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public String getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(String disposicion) {
        this.disposicion = disposicion;
    }

    public String getEstiloAlerta() {
        return estiloAlerta;
    }

    public void setEstiloAlerta(String estiloAlerta) {
        this.estiloAlerta = estiloAlerta;
    }

    public String getSonidoAlerta() {
        return sonidoAlerta;
    }

    public void setSonidoAlerta(String sonidoAlerta) {
        this.sonidoAlerta = sonidoAlerta;
    }
}
