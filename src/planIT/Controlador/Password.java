/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Controlador;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author David
 */
public class Password {
    
    private String sal;
    private String pass;
    
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
