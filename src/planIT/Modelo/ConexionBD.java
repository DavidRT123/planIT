/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo;

import com.mongodb.DB;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class ConexionBD {
    private static final String BBDD = "planIT";
    
    public static String getBBDD() {
        return BBDD;
    }
    
    public static DB abrirConexion(){
        Mongo mongo = null;
        try {
            mongo = new Mongo("localhost", 27017);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        if(mongo == null){
            return mongo.getDB(BBDD);
        }else{
            return null;
        }
    }
    
    public static void cerrarConexion(Mongo mongo){
        if(mongo != null){
            mongo.close();
        }
    }
}
