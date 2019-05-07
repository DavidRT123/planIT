/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo.DAO.Impl.Mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;
import planIT.Modelo.ConexionBD;
import planIT.Modelo.DAO.UsuarioDAO;
import planIT.Modelo.Usuario;

/**
 *
 * @author David
 */
public class UsuarioDAOImplMongo implements UsuarioDAO {

    private final String COLECCION = "usuarios";
    private MongoDatabase planIT;
    private MongoCollection usuarios;
    private Document campos;

    public UsuarioDAOImplMongo() {
        planIT = ConexionBD.abrirConexion();
        usuarios = planIT.getCollection(COLECCION);
        campos = new Document();
    }

    @Override
    public void insertar(Usuario usuario) {
        rellenar(usuario);
        usuarios.insertOne(campos);
        System.out.println("Usuario insertado correctamente");
    }

    @Override
    public void actualizar(Usuario usuario) {
        rellenar(usuario);
        Bson busqueda = eq("_id", usuario.getEmail());
        Bson valores = new Document("$set", campos);
        usuarios.updateOne(busqueda, valores);
    }

    @Override
    public ArrayList<Usuario> buscar(Usuario usuario) {
        MongoCursor resultado;
        Document encontrado = null;
        ArrayList<Usuario> listaUsuarios = null;

        //Se rellenan los campos con los datos proporcionados
        rellenar(usuario);
        //Se realiza consulta y se obtiene un cursor con los resultados
        resultado = usuarios.find(campos).iterator();

        //En caso de tener resultados se devuelve crea un nuevo usuario y se devuelve con sus datos
        if (resultado.hasNext()) {
            listaUsuarios = new ArrayList<>();
            encontrado = (Document) resultado.next();
            listaUsuarios.add(new Usuario(encontrado.get("_id").toString(), encontrado.get("nombre").toString(), encontrado.get("pass").toString(), encontrado.get("sal").toString(), encontrado.get("foto").toString(), encontrado.get("colorPrincipal").toString(), encontrado.get("colorSecundario").toString(), encontrado.get("disposicion").toString(), encontrado.get("estiloAlerta").toString(), encontrado.get("sonidoAlerta").toString()));
        }
        return listaUsuarios;
    }

    @Override
    public void rellenar(Usuario obj) {
        campos.clear();
        campos.append("_id", obj.getEmail());
        campos.append("nombre", obj.getNombre());
        campos.append("pass", obj.getPass());
        campos.append("sal", obj.getSal());
        campos.append("foto", obj.getFoto());
        campos.append("colorPrincipal", obj.getColorPrincipal());
        campos.append("colorSecundario", obj.getColorSecundario());
        campos.append("disposicion", obj.getDisposicion());
        campos.append("estiloAlerta", obj.getEstiloAlerta());
        campos.append("sonidoAlerta", obj.getSonidoAlerta());
    }

    //    private Boolean login(String email, String pass) {
//        Usuario usuario;
//        Map<String, String> camposValor = new HashMap<>(); 
//        camposValor.put("email", email);
//        camposValor.put("pass", pass);
//        ArrayList<Usuario> resultado = buscar(camposValor);
//        
//        if(resultado != null){
//            usuario = resultado.get(0);  
//            
//        }else{
//            return false;
//        }
//        
//    }

    @Override
    public void eliminar(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario obtener(Usuario usuario){
        ArrayList<Usuario> listaUsuarios = buscar(usuario);
        if(listaUsuarios.size() > 0){
            return listaUsuarios.get(0);
        }else{
            return null;
        }
    }
    
    public Map<String, String> toMap(Usuario usuario){
        Map<String, String> valores = new HashMap<>();
        valores.put("foto", usuario.getFoto());
        valores.put("colorPrincipal", usuario.getColorPrincipal());
        valores.put("colorSecundario", usuario.getColorSecundario());
        valores.put("disposicion", usuario.getDisposicion());
        valores.put("estiloAlerta", usuario.getEstiloAlerta());
        valores.put("sonidoAlerta", usuario.getSonidoAlerta());
        return valores;
    }
}
