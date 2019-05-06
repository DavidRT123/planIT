/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo.DAO;

import com.mongodb.BasicDBObject;

/**
 *
 * @author mdfda
 * @param <Clase>
 * @param <ID>
 */
public interface DAO<Clase, ID> {
    public Boolean insertar(Clase obj);
    public void actualizar(Clase obj);
    public Clase buscar(Clase obj);
    public BasicDBObject rellenar(Clase obj);
    public int id();
}
