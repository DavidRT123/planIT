/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo.DAO.Impl.Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import planIT.Modelo.ConexionBD;
import planIT.Modelo.DAO.UsuarioDAO;
import planIT.Modelo.Usuario;

/**
 *
 * @author David
 */
public class UsuarioDAOImplMongo implements UsuarioDAO{
    
    private final String COLECCION = "usuarios";
    private DB planIT; 
    private DBCollection usuarios;
    private BasicDBObject campos;
    
    public UsuarioDAOImplMongo(){
        planIT = ConexionBD.abrirConexion();
        usuarios = planIT.getCollection(COLECCION);
        campos = new BasicDBObject();
    }

    @Override
    public Boolean insertar(Usuario obj) {
        Boolean insertado = false;
        Usuario usuario = buscar(obj);

        if(usuario == null){
            usuarios.insert(rellenar(usuario));
            insertado = true;
        }
        
        return insertado;
    }

    @Override
    public void actualizar(Usuario obj) {
        BasicDBObject campos = new BasicDBObject();
        usuarios.update(campos, campos, true, true);
    }

    @Override
    public Usuario buscar(Usuario obj) {
        DBObject encontrado;
        campos.clear();
        campos.put("email", obj.getEmail());
        Usuario usuario = null;
        //En caso de tener resultados se devuelve el usuario encontrado
        if(usuarios.find(campos).hasNext()){
            encontrado = usuarios.find(campos).next();
            usuario = new Usuario(Integer.parseInt(encontrado.get("id").toString()), encontrado.get("email").toString(), encontrado.get("pass").toString(), encontrado.get("sal").toString(), encontrado.get("foto").toString(), encontrado.get("colorPrincipal").toString(), encontrado.get("colorSecundario").toString(), encontrado.get("disposicion").toString(), encontrado.get("estiloAlerta").toString(), encontrado.get("sonidoAlerta").toString());
        }
        return usuario;
    }

    @Override
    public BasicDBObject rellenar(Usuario obj) {
        campos.clear();
        campos.put("id", "");
        campos.put("email", obj.getEmail());
        campos.put("pass", obj.getPass());
        campos.put("sal", obj.getSal());
        campos.put("foto", obj.getFoto());
        campos.put("colorPrincipal", obj.getColorPrincipal());
        campos.put("colorSecundario", obj.getColorSecundario());
        campos.put("disposicion",obj.getDisposicion());
        campos.put("estiloAlerta", obj.getEstiloAlerta());
        campos.put("sonidoAlerta", obj.getSonidoAlerta());
        return campos;
    }
}
