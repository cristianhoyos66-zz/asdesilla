package AccesoDatos;

import Utilidades.Conexion;
import java.sql.*;//para poder usar codigos para conectarse como sentencias sql

/**
 * Esta clase permite validar el inicio de sesión a la aplicación, validar el rol de dicho usuario
 * así como validar la necesidad del cambio por parte del usuario al iniciar sesión
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpInicio {

    private String usuario;//variables
    private String clave;
    private String tipo;
    private Statement instruccion;
    private int nfilas = 0;

    public OpInicio() {
    }

    public OpInicio(String usuario, String clave, String tipo) {

        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    /**
     * @param usuario to usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @param clave to clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @param tipo to tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return usuario
     */
    public String getUsuario() {
        return this.usuario;
    }

    /*
     * @return clave
     */
    public String getClave() {
        return this.clave;
    }

    /**
     * @return tipo
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * @return nfilas
     */
    public int getNfilas() {
        return this.nfilas;
    }

    /**
     * Método que permite validar si el usuario existe y corresponde con el usuario clave recibidos, 
     * devuelve si el usuario existe o no.
     * @param usuario
     * @param clave
     * @return respuesta
     */
    public boolean ingresar(String usuario, String clave) {
        boolean respuesta = false;
        PreparedStatement p;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try{
            String sql = "select usuario, clave from tbl_usuarios where Usuario= ? AND Clave= ?";
            p = (PreparedStatement) conectar.prepareStatement(sql);
            p.setString(1, usuario);
            p.setString(2, clave);
            ResultSet r = p.executeQuery();
            if(r.next())
            {
                respuesta = true;
            }else{
                respuesta = false;
            }
            r.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return respuesta;

    }
    
    /**
     * Método que permite validar en caso de que el usuario y contraseña coincidan, si este se encuentra activo
     * @param usuario
     * @return respuesta
     */
    public boolean ValidarUsuarioActivo(String usuario) {
        boolean respuesta = false;
        PreparedStatement p;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try{
            String sql = "select usuario, clave from tbl_usuarios where Usuario='"+usuario+"' AND Estado = 'Activo'";
            p = (PreparedStatement) conectar.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            if(r.next())
            {
                respuesta = true;
            }else{
                respuesta = false;
            }
            r.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return respuesta;

    }
    
    /**
     * Método que permite validar el rol asignado a un usuario, de acuerdo al usuario y clave dadas, 
     * devuelve el rol asociado.
     * @param usuario
     * @param clave
     * @return rol
     */
    public static String validarRol(String usuario, String clave)
    {
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        String rol = "";
        PreparedStatement p;
        try{
            String sql = "select * from tbl_usuarios where Usuario='"+usuario+"' AND Clave='"+clave+"'";
            p = (PreparedStatement) conectar.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            if(r.next())
            {
                rol = r.getString("Perfil");
            }
            r.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rol;
    }
    
    /**
     * Método que permite validar si a dicho usuario se le ha generado un cambio de contraseña por parte de un administrador
     * @param usuario
     * @return b
     */
    public boolean validarCambioClave(String usuario)
    {
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        boolean b = false;
        PreparedStatement p;
        try{
            String sql = "select Cambio_clave from tbl_usuarios where Usuario= ?";
            p = (PreparedStatement) conectar.prepareStatement(sql);
            p.setString(1, usuario);
            ResultSet r = p.executeQuery();
            if(r.next())
            {
                if (r.getInt("Cambio_clave")!= 0) {
                    b = true;
                }
            }
            r.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return b;
    }
}
