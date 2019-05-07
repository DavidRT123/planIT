/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo.DAO;

import java.util.ArrayList;

/**
 *
 * @author mdfda
 * 
 */
public interface DAO<Clase, ID> {
    public void insertar(Clase obj);
    public void actualizar(Clase obj);
    public void eliminar(Clase obj);
    public ArrayList<Clase> buscar(Clase obj);
    public void rellenar(Clase obj);
}
