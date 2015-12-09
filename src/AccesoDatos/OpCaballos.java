/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Caballos
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpCaballos {

    private static Statement instruccion;

    private static String Nrege = "", Nombre = "", NombreDuenio = "", Apellido1Duenio = "", Apellido2Duenio = "", Edad = "", Cria = "", pruebaAIE = "", Estado = "";

    public static String getNreg() {
        return Nrege;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static String getNombreDuenio() {
        return NombreDuenio;
    }

    public static String getEdad() {
        return Edad;
    }

    public static String getCria() {
        return Cria;
    }

    public static String getPruebaAIE() {
        return pruebaAIE;
    }

    public static void setNreg(String nreg) {
        Nrege = nreg;
    }

    public static void setNombre(String nombre) {
        Nombre = nombre;
    }

    public static void setNombreDuenio(String duenio) {
        NombreDuenio = duenio;
    }

    public static void setEdad(String edad) {
        Edad = edad;
    }

    public static void setCria(String cria) {
        Cria = cria;
    }

    public static void setPruebaAIE(String anem) {
        pruebaAIE = anem;
    }
    
    /**
     * @return the Apellido1Duenio
     */
    public static String getApellido1Duenio() {
        return Apellido1Duenio;
    }

    /**
     * @param aApellido1Duenio the Apellido1Duenio to set
     */
    public static void setApellido1Duenio(String aApellido1Duenio) {
        Apellido1Duenio = aApellido1Duenio;
    }

    /**
     * @return the Apellido2Duenio
     */
    public static String getApellido2Duenio() {
        return Apellido2Duenio;
    }

    /**
     * @param aApellido2Duenio the Apellido2Duenio to set
     */
    public static void setApellido2Duenio(String aApellido2Duenio) {
        Apellido2Duenio = aApellido2Duenio;
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
     * @param nrege
     * @param nombre
     * @param nomDuenio
     * @param apll1Duenio
     * @param apll2Duenio
     * @param edad
     * @param cria
     * @param anem 
     * @return aux 
     */
    public static int guardar(String nrege, String nombre, String nomDuenio, String apll1Duenio, String apll2Duenio, String edad, String cria, String anem) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_caballos").executeQuery();
            while (r.next()) {
                if (nrege.equals(r.getString("Nrege"))) {
                    JOptionPane.showMessageDialog(null, "El número de registro ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "insert into tbl_caballos (Nrege, Nombre, NombreDuenio, Apellido1Duenio, Apellido2Duenio, Edad, Cria, Anem, Estado) values (?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, nrege);
                cmd.setString(2, nombre);
                cmd.setString(3, nomDuenio);
                cmd.setString(4, apll1Duenio);
                cmd.setString(5, apll2Duenio);
                cmd.setString(6, edad);
                cmd.setString(7, cria);
                cmd.setString(8, anem);
                cmd.setString(9, "Activo");
                cmd.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
    }

    /**
     * Método que permite buscar la información de un caballo en la base de
     * datos, de acuerdo a la identificación.
     * @param Nreg
     */
    public static void buscar(String Nreg) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_caballos").executeQuery();
            while (rs.next()) {
                if (Nreg.equals(rs.getString("Nrege"))) {
                    String sql = "select * from tbl_caballos where Nrege = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, Nreg);
                    ResultSet r = cmd.executeQuery();

                    while (r.next()) {
                        Nrege = r.getString(1);
                        Nombre = r.getString(2);
                        NombreDuenio = r.getString(3);
                        Apellido1Duenio = r.getString(4);
                        Apellido2Duenio = r.getString(5);
                        Edad = r.getString(6);
                        Cria = r.getString(7);
                        pruebaAIE = r.getString(8);
                        Estado = r.getString(9);
                    }

                    cmd.close();

                    //JOptionPane.showMessageDialog(null, "El registro se encontró con éxito");
                    aux = 1;
                }
            }
            if (aux == 0) {
                JOptionPane.showMessageDialog(null, "No se encontró el registro", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    /**
     * Método que permite cambiar el estado de un caballo de la base de datos, de acuerdo a
     * la identificación.
     * @param Nrege
     */
    public static void cambiarEstado(String Nrege) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_caballos").executeQuery();
            while (rs.next()) {
                if (Nrege.equals(rs.getString("Nrege"))) {
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "update tbl_caballos set Estado = ? where Nrege = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    if (rs.getString("Estado").equals("Activo")) {
                        cmd.setString(1, "Inactivo");
                    }else{
                        cmd.setString(1, "Activo");
                    }
                    cmd.setString(2, Nrege);
                    cmd.executeUpdate();
                    aux = 1;
                    JOptionPane.showMessageDialog(null, "El estado del registro se actualizó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (aux == 0) {
                JOptionPane.showMessageDialog(null, "No se encontró el registro", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que permite modificar la informacion obtenida en la base de datos.
     * @param nrege
     * @param nombre
     * @param nomDuenio
     * @param apll1Duenio
     * @param apll2Duenio
     * @param edad
     * @param cria
     * @param anem 
     */
    public static void modificar(String nrege, String nombre, String nomDuenio, String apll1Duenio, String apll2Duenio, String edad, String cria, String anem) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_caballos").executeQuery();
            while (rs.next()) {
                if (nrege.equals(rs.getString("Nrege"))) {
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    String sql = "update tbl_caballos set Nombre = ?, NombreDuenio = ?, Apellido1Duenio = ?, Apellido2Duenio = ?, Edad = ?, Cria = ?, Anem = ? where Nrege = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);

                    cmd.setString(1, nombre);
                    cmd.setString(2, nomDuenio);
                    cmd.setString(3, apll1Duenio);
                    cmd.setString(4, apll2Duenio);
                    cmd.setString(5, edad);
                    cmd.setString(6, cria);
                    cmd.setString(7, anem);
                    cmd.setString(8, nrege);

                    cmd.executeUpdate();
                    aux = 1;
                    JOptionPane.showMessageDialog(null, "El registro se modificó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (aux == 0) {
                JOptionPane.showMessageDialog(null, "No se encontró el registro", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que permite obtener todos los caballos coincidentes con la búsqueda en el registro de la base de datos
     * @param busqueda
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerCaballos(String busqueda) throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select Nrege, Nombre from tbl_caballos WHERE Nrege LIKE '%" + busqueda +"%' LIMIT 10;";
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
     * Método que permite cargar todos los registros de la base de datos.
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select Nrege, Nombre, Edad, Cria, Anem, Estado from tbl_caballos order by Nrege";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                Object[] columnas = new Object[6];
                for (int i = 0; i < 6; i++) {
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
     * Método que permite buscar por un registro específico en la base de datos
     * @param Nrege
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String Nrege) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql;
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            
            sql = "select Nrege, Nombre, Edad, Cria, Anem, Estado from tbl_caballos where Nrege =" + Nrege + " order by Nrege;";
            
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                Object[] columnas = new Object[6];
                for (int i = 0; i < 6; i++) {
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
}
