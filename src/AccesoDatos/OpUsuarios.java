/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Utilidades.Conexion;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Usuarios
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpUsuarios {
    
    private static Statement instruccion;
    
    private static String Id = "", TipoDocumento = "", Nombre = "", Apellido1 = "", Apellido2 = "", Ocupacion = "", Usuario = "", Clave = "", Perfil = "", Estado = "";

    /**
     * @return the Id
     */
    public static String getId() {
        return Id;
    }

    /**
     * @param aId the Id to set
     */
    public static void setId(String aId) {
        Id = aId;
    }

    /**
     * @return the TipoDocumento
     */
    public static String getTipoDocumento() {
        return TipoDocumento;
    }

    /**
     * @param aTipoDocumento the TipoDocumento to set
     */
    public static void setTipoDocumento(String aTipoDocumento) {
        TipoDocumento = aTipoDocumento;
    }

    /**
     * @return the Nombre
     */
    public static String getNombre() {
        return Nombre;
    }

    /**
     * @param aNombre the Nombre to set
     */
    public static void setNombre(String aNombre) {
        Nombre = aNombre;
    }
    
    /**
     * @return the Apellido1
     */
    public static String getApellido1() {
        return Apellido1;
    }

    /**
     * @param aApellido1 the Apellido1 to set
     */
    public static void setApellido1(String aApellido1) {
        Apellido1 = aApellido1;
    }

    /**
     * @return the Apellido2
     */
    public static String getApellido2() {
        return Apellido2;
    }

    /**
     * @param aApellido2 the Apellido2 to set
     */
    public static void setApellido2(String aApellido2) {
        Apellido2 = aApellido2;
    }

    /**
     * @return the Ocupacion
     */
    public static String getOcupacion() {
        return Ocupacion;
    }

    /**
     * @param aOcupacion the Ocupacion to set
     */
    public static void setOcupacion(String aOcupacion) {
        Ocupacion = aOcupacion;
    }

    /**
     * @return the Usuario
     */
    public static String getUsuario() {
        return Usuario;
    }

    /**
     * @param aUsuario the Usuario to set
     */
    public static void setUsuario(String aUsuario) {
        Usuario = aUsuario;
    }

    /**
     * @return the Clave
     */
    public static String getClave() {
        return Clave;
    }

    /**
     * @param aClave the Clave to set
     */
    public static void setClave(String aClave) {
        Clave = aClave;
    }

    /**
     * @return the Perfil
     */
    public static String getPerfil() {
        return Perfil;
    }

    /**
     * @param aPerfil the Perfil to set
     */
    public static void setPerfil(String aPerfil) {
        Perfil = aPerfil;
    }
    
    /**
     * @return the Estado
     */
    public static String getEstado() {
        return Estado;
    }

    /**
     * @param aEstado the Estado to set
     */
    public static void setEstado(String aEstado) {
        Estado = aEstado;
    }
    
    /**
     * Método que permite guardar la información obtenida en la base de datos.
     * @param IdUsuario
     * @param TipoDocumento
     * @param Nombre
     * @param Apellido1
     * @param Apellido2
     * @param Ocupacion
     * @param Usuario
     * @param Clave
     * @param Perfil 
     * @return aux
     */
    public static int guardar(String IdUsuario, String TipoDocumento, String Nombre, String Apellido1, String Apellido2, String Ocupacion, String Usuario, String Clave, String Perfil) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_usuarios").executeQuery();
            while (r.next()) {
                if (IdUsuario.equals(r.getString("IdUsuario"))) {
                    JOptionPane.showMessageDialog(null, "La identificación del registro ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                } else if (Usuario.equals(r.getString("Usuario"))) {
                    JOptionPane.showMessageDialog(null, "El usuario especificado ya está siendo usado", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "insert into tbl_usuarios (IdUsuario, TipoId, Nombre, Apellido1, Apellido2, Cargo, Usuario, Clave, Perfil, Estado) values (?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, IdUsuario);
                cmd.setString(2, TipoDocumento);
                cmd.setString(3, Nombre);
                cmd.setString(4, Apellido1);
                cmd.setString(5, Apellido2);
                cmd.setString(6, Ocupacion);
                cmd.setString(7, Usuario);
                cmd.setString(8, Clave);
                cmd.setString(9, Perfil);
                cmd.setString(10, "Activo");
                cmd.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro se ingresó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }

            //JOptionPane.showMessageDialog(null, "se guardó");                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
    }
    
    /**
     * Metodo que permite buscar la información de un usuario en la base de datos, de acuerdo a la identificación.
     * @param IdUsuario 
     */
    public static void buscar(String IdUsuario) {
        int aux = 0;
        Id = IdUsuario;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_usuarios").executeQuery();
            while (rs.next()) {
                if (IdUsuario.equals(rs.getString("IdUsuario"))) {
                    String sql = "select * from tbl_usuarios where IdUsuario = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, IdUsuario);
                    ResultSet r = cmd.executeQuery();

                    while (r.next()) {
                        Id = r.getString(1);
                        TipoDocumento = r.getString(2);
                        Nombre = r.getString(3);
                        Apellido1 = r.getString(4);
                        Apellido2 = r.getString(5);
                        Ocupacion = r.getString(6);
                        Usuario = r.getString(7);
                        //Clave = r.getString(8);
                        Perfil = r.getString(10);
                        Estado = r.getString(11);
                    }
                    cmd.close();
                    //JOptionPane.showMessageDialog(null, "El registro fue encontrado con éxito");
                    aux = 1;
                }
            }
            if (aux == 0) {
                //JOptionPane.showMessageDialog(null, "No se encontró el registro");
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que permite cambiar el estado de un usuario de la base de datos, de acuerdo a la identificación.
     * @param IdUsuario 
     */
    public static void cambiarEstado(String IdUsuario) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_usuarios").executeQuery();
            while (rs.next()) {
                if (IdUsuario.equals(rs.getString("IdUsuario"))) {
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "update tbl_usuarios set Estado = ? where IdUsuario = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    if (rs.getString("Estado").equals("Activo")) {
                        cmd.setString(1, "Inactivo");
                    }else{
                        cmd.setString(1, "Activo");
                    }
                    cmd.setString(2, IdUsuario);
                    cmd.executeUpdate();
                    aux = 1;
                    JOptionPane.showMessageDialog(null, "El estado del registro se actualizó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (aux == 0) {
                //JOptionPane.showMessageDialog(null, "No se encontró el registro");
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }
    
    /**
     * Método que permite actualizar un registro en la base de datos, con respecto a la información suministrada.
     * @param IdUsuario
     * @param TipoDocumento
     * @param Nombre
     * @param Apellido1
     * @param Apellido2
     * @param Ocupacion
     * @param Usuario
     * @param Clave
     * @param Perfil 
     */
    public static void modificar(String IdUsuario, String TipoDocumento, String Nombre, String Apellido1, String Apellido2, String Ocupacion, String Usuario, String Clave, String Perfil) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_usuarios").executeQuery();
            while (rs.next()) {
                if(!IdUsuario.equals(rs.getString("IdUsuario")) && Usuario.equals(rs.getString("Usuario"))){
                    JOptionPane.showMessageDialog(null, "El usuario especificado ya está siendo usado");
                    aux = 2;
                }else
                if (IdUsuario.equals(rs.getString("IdUsuario")) && aux == 0) {
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "update tbl_usuarios set TipoId = ?, Nombre = ?, Apellido1 = ?, Apellido2 = ?, Cargo = ?, Usuario = ?, Clave = ?, Cambio_clave = ?, Perfil = ? where IdUsuario = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);

                    cmd.setString(1, TipoDocumento);
                    cmd.setString(2, Nombre);
                    cmd.setString(3, Apellido1);
                    cmd.setString(4, Apellido2);
                    cmd.setString(5, Ocupacion);
                    cmd.setString(6, Usuario);
                    cmd.setString(7, Clave);
                    cmd.setInt(8, 1);
                    cmd.setString(9, Perfil);
                    cmd.setString(10, IdUsuario);

                    cmd.executeUpdate();
                    aux = 1;
                    JOptionPane.showMessageDialog(null, "El registro se modificó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (aux == 0) {
                //JOptionPane.showMessageDialog(null, "No se encontró el registro");
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que permite obtener todos los perfiles registrados, a fin de cargarlos en el formulario
     * @return 
     * @returnr result
     * @throws SQLException 
     */
    public static TreeMap obtenerPerfiles() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdPerfil, Nombre from tbl_perfiles";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();

            while (r.next()) {
                result.put(r.getInt(1), r.getString(2));
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return result;
    }
    
    /**
     * Método que permite obtener todos los tipos de documentos registrados a fin de cargarlos en el formulario
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerTipoDoc() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdTipoDoc, Nombre from tbl_tipo_documentos";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();

            while (r.next()) {
                result.put(r.getInt(1), r.getString(2));
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return result;
    }
    
    /**
     * Método que permite obtener todos los cargos registrados a fin de cargarlos en el formulario
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerCargos() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdCargo, NombreCargo from tbl_cargo";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();

            while (r.next()) {
                result.put(r.getInt(1), r.getString(2));
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return result;
    }
    
    /**
     * Método que permite obtener los usuarios coincidentes con la búsqueda
     * @param busqueda
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerUsuarios(String busqueda) throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdUsuario, CONCAT(Nombre, SPACE(2), Apellido1, SPACE(2), Apellido2) from tbl_usuarios WHERE IdUsuario LIKE '%" + busqueda +"%' LIMIT 10;";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();

            while (r.next()) {
                result.put(r.getString(1), r.getString(2));
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return result;
    }
    
    /**
     * Método que permite obtener todos los registros de la base de datos
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdUsuario, Nombre, Apellido1, Apellido2, Estado from tbl_usuarios order by IdUsuario";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                Object[] columnas = new Object[5];
                for (int i = 0; i < 5; i++) {
                    columnas[i] = r.getObject(i+1);
                }
                data.add(columnas); 
            }
          
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return data;
    }
    
    /**
     * Método que permite buscar un registro específico
     * @param IdUsuario
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String IdUsuario) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql;
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            
            sql = "select IdUsuario, Nombre, Apellido1, Apellido2, Estado from tbl_usuarios where IdUsuario =" + IdUsuario + " order by IdUsuario;";
            
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                Object[] columnas = new Object[5];
                for (int i = 0; i < 5; i++) {
                    columnas[i] = r.getObject(i+1);
                }
                data.add(columnas);
                o++;
            }
            
            if (o == 0) {
                JOptionPane.showMessageDialog(null, "No se han encontrado registros coincidentes con la búsqueda", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
            }
            
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return data;
    }
    
    /**
     * Método que permite cambiar la contraseña del usuario al iniciar sesión
     * @param Usuario
     * @param Clave 
     */
    public static void cambiarClave(String Usuario, String Clave) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_usuarios").executeQuery();
            while (rs.next()) {
                if (Usuario.equals(rs.getString("Usuario")) && aux == 0) {
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "update tbl_usuarios set Clave = ?, Cambio_clave = ? where Usuario = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);

                    cmd.setString(1, Clave);
                    cmd.setInt(2, 0);
                    cmd.setString(3, Usuario);

                    cmd.executeUpdate();
                    aux = 1;
                    JOptionPane.showMessageDialog(null, "La contraseña se ha modificado correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (aux == 0) {
                //JOptionPane.showMessageDialog(null, "No se encontró el registro");
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Métodos que permiten encriptar la contraseña
     * @param data
     * @return 
     */
    public static String convertByteToHex(byte data[])
    {
        StringBuffer hexData = new StringBuffer();
        for (int byteIndex = 0; byteIndex < data.length; byteIndex++)
            hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));
        
        return hexData.toString();
    }
    
    public static String hashText(String textToHash) throws Exception
    {
        final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
        sha512.update(textToHash.getBytes());
        
        return convertByteToHex(sha512.digest());
    }
}
