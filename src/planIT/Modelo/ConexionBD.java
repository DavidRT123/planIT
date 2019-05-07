/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author David
 */
public class ConexionBD {
    private static final String BBDD = "planIT";
    
    public static String getBBDD() {
        return BBDD;
    }
    
    public static MongoDatabase abrirConexion(){
        MongoClient mongo = null;
        mongo = new MongoClient("localhost", 27017);        
        return mongo.getDatabase(BBDD);
    }
    
    public static void cerrarConexion(MongoClient mongo){
        if(mongo != null){
            mongo.close();
        }
    }
}
