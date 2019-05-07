/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Controlador;

import com.mongodb.BasicDBObject;
import planIT.Modelo.ConexionBD;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import planIT.Modelo.DAO.Impl.Mongo.UsuarioDAOImplMongo;
import planIT.Modelo.Usuario;

/**
 *
 * @author David
 */
public class PlanIT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*ConexionBD bd = new ConexionBD();
        Mongo mongo = bd.abrirConexion();
        DB planIT = mongo.getDB(ConexionBD.getDATABASE());
        DBCollection usuarios = planIT.getCollection("usuarios");
        
        String pass = "juan";
        
	//Crear objeto donde se guardan los datos introducidos en los TextFields
        String sal = generarSal();
        BasicDBObject searchQuery = new BasicDBObject("nombre", "Juan");
        BasicDBObject fields = new BasicDBObject();
        fields.put("nombre", "Juan");
        //Actualizar registro
//            fields.put("nombre", "Juan");
//            fields.put("sal", sal);
//            fields.put("pass", generarHashConSal(pass, sal.getBytes()));
//            usuarios.update(searchQuery, fields); 
        
//        System.out.println(usuarios.find(fields).next().get("pass"));
//        System.out.println(generarHashConSal(pass, usuarios.find(fields).next().get("sal").toString().getBytes()));
   
        //DBCursor cursor = usuarios.find(fields);
        
        //System.out.println(cursor.next());
//        System.out.println(usuarios.find(fields).next().get("pass").equals(generarHashConSal(pass, usuarios.find(fields).next().get("sal").toString().getBytes())));
//        System.out.println("Generada a partir de datos: " + generarHashConSal(pass, usuarios.find(fields).next().get("sal").toString().getBytes()));
         System.out.println(validarPass(pass, usuarios.find(fields).next().get("sal").toString().getBytes(), usuarios.find(fields).next().get("pass").toString()));*/
        
        UsuarioDAOImplMongo uDI = new UsuarioDAOImplMongo();
        
        Usuario usuario = new Usuario();
        
        usuario.setEmail("juana@email.com");
        usuario.setNombre("Nuevo nombre");
        //usuario = uDI.buscar(usuario);
        //System.out.println(usuario.getId());
        
        uDI.actualizar(usuario);
    }

    public static String generarSal() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String generarHashConSal(String input, byte[] sal) {
        byte[] hash = null;
        try {
            PBEKeySpec spec = new PBEKeySpec(input.toCharArray(), sal, 256, 256);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            hash = skf.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(PlanIT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PlanIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Base64.getEncoder().encodeToString(hash);
    }
    
    public static boolean validarPass(String input, byte[] sal, String hashConSal){
        boolean validado;
        String hashConSalGenerado = generarHashConSal(input, sal);
        System.out.println(hashConSalGenerado + " = " + hashConSal);

        if(hashConSalGenerado.equalsIgnoreCase(hashConSal)){
            System.out.println("COINCIDE");
            validado = true;
        }else{
            System.out.println("NO COINCIDE");
            validado = false;
        }
        return validado;
    }
}
