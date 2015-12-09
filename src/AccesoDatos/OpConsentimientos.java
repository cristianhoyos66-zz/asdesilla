/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import Utilidades.Conexion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Consentimientos
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpConsentimientos {
    private static String codigo = "";
    private static String fecha = "";
    private static String idHistoriaClinica = "";
    private static String idProfesional = "";
    private static Image adjunto;

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        OpConsentimientos.codigo = codigo;
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        OpConsentimientos.fecha = fecha;
    }

    public static String getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public static void setIdHistoriaClinica(String idHistoriaClinica) {
        OpConsentimientos.idHistoriaClinica = idHistoriaClinica;
    }

    public static Image getAdjunto() {
        return adjunto;
    }

    public static void setAdjunto(Image adjunto) {
        OpConsentimientos.adjunto = adjunto;
    }

    public static String getIdProfesional() {
        return idProfesional;
    }

    public static void setIdProfesional(String idProfesional) {
        OpConsentimientos.idProfesional = idProfesional;
    }
    
    /**
     * Método que permite obtener los pacientes coincidentes con la búsqueda que están activos
     * @param busqueda
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerPacientes(String busqueda) throws SQLException {
        Map<Integer, String> result = new HashMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select tbl_historia_clinica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_historia_clinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente LIKE '%"+busqueda+"%' and tbl_pacientes.Estado = 'Activo' LIMIT 10;";
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
     * Método que permite obtener todos los pacientes a fin de cargarlos en el registro de todos los consentimientos
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerPacientes() throws SQLException {
        Map<Integer, String> result = new HashMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select tbl_historia_clinica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_historia_clinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
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
     * Método que permite obtener los pacientes coincidentes con la búsqueda
     * @param busqueda
     * @return result
     * @throws SQLException 
     */
    public static Map consultarPacientes(String busqueda) throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdPaciente, CONCAT(Nombre, SPACE(2), Apellido1, SPACE(2), Apellido2) from tbl_pacientes where IdPaciente LIKE '%" + busqueda +"%' LIMIT 10;";
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
     * Método que permite obtener los profesionales coincidentes con la búsqueda
     * @param busqueda
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerProfesionales(String busqueda) throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select NumRegistro, CONCAT(Nombre, SPACE(2), Apellido1, SPACE(2), Apellido2) from tbl_profesionales WHERE NumRegistro LIKE '%" + busqueda +"%' and Estado = 'Activo' LIMIT 10;";
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
     * Método que permite obtener el código autogenerado del consentimiento
     * @return result
     * @throws SQLException 
     */
    public static String obtenerCodigo() throws SQLException {
        String result = "";
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "SHOW TABLE STATUS where name = 'tbl_consentimientos'";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();

            while (r.next()) {
                result = r.getString("Auto_increment");
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return result;
    }
    
    /**
     * Método que permite guardar un registro en la base de datos
     * @param fecha
     * @param hc
     * @param profesional
     * @param adjunto
     * @throws FileNotFoundException 
     */
    public static void guardar(String fecha, String hc, String profesional, File adjunto) throws FileNotFoundException {
        Connection conectar; 
        conectar = Conexion.getConexionMysql();
        FileInputStream fis = null;
        try {
            String sql = "insert into tbl_consentimientos(IdHistoriaClinica, CodigoConsentimiento, Fecha, IdProfesional, Adjunto) values (?,?,?,?,?);";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            fis = new FileInputStream(adjunto);
            cmd.setString(1, hc);
            cmd.setString(2, null);
            cmd.setString(3, fecha);
            cmd.setString(4, profesional);
            cmd.setBinaryStream(5, fis);
            cmd.execute();
            JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Método que permite obtener toda la información de un consentimiento
     * @param codigoC 
     */
    public static void buscar(String codigoC) { 
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select * from tbl_consentimientos where CodigoConsentimiento = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, codigoC);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                idHistoriaClinica = r.getString(1);
                codigo = r.getString(2);
                fecha = r.getString(3);
                idProfesional = r.getString(4);
                Blob blob = r.getBlob(5);
                byte[] data = blob.getBytes(1, (int)blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {
                    Logger.getLogger(OpConsentimientos.class.getName()).log(Level.SEVERE, null, ex);
                }
                adjunto = img;
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que obtiene todos los consentimientos registrados en la base de datos
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "SELECT tbl_consentimientos.CodigoConsentimiento, tbl_consentimientos.Fecha, tbl_consentimientos.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_consentimientos INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_consentimientos.IdProfesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_consentimientos.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
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
     * Método que permite buscar un consentimiento específico según una fecha o un paciente
     * @param fecha
     * @param IdPaciente
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String fecha, String IdPaciente) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql;
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            if (fecha != null && IdPaciente != null) {
                sql = "SELECT tbl_consentimientos.CodigoConsentimiento, tbl_consentimientos.Fecha, tbl_consentimientos.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_consentimientos INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_consentimientos.IdProfesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_consentimientos.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_consentimientos.Fecha ='" + fecha + "' and tbl_pacientes.IdPaciente =" + IdPaciente + ";";
            }else{
                if(fecha != null){
                    sql = "SELECT tbl_consentimientos.CodigoConsentimiento, tbl_consentimientos.Fecha, tbl_consentimientos.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_consentimientos INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_consentimientos.IdProfesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_consentimientos.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_consentimientos.Fecha ='" + fecha + "';";
                }else{
                    sql = "SELECT tbl_consentimientos.CodigoConsentimiento, tbl_consentimientos.Fecha, tbl_consentimientos.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_consentimientos INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_consentimientos.IdProfesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_consentimientos.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente =" + IdPaciente + ";";
                }
            }
            
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
}
