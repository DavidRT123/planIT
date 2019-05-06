/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.util.ArrayList;
import planIT.Modelo.ConexionBD;

/**
 *
 * @author David
 */
public abstract class Modelo {
    private final String NOMBRECOLECCION; //Hace que al sobreescribirla en las subclases las consultas se adecuen a la colección correspondiente de la que recuperan los datos
    private Mongo mongo;
    DB bd;
    DBCollection coleccion;

    public Modelo(String NOMBRECOLECCION){
        this.NOMBRECOLECCION = NOMBRECOLECCION;
        
        //Iniciar la conexión con la que se llevarán a cabo las consultas
        mongo = ConexionBD.abrirConexion();
        bd = mongo.getDB(ConexionBD.getDATABASE());
        coleccion = bd.getCollection(NOMBRECOLECCION); 
    }
    
    private void insertar(){
    
    }
    
    private void actualizar(){
    
    }
    
    private void eliminar(){
    
    }
    
    private ArrayList buscar(String[] campos){
    
    }
}
