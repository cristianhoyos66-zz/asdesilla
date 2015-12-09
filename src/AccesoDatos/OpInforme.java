/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import Utilidades.Conexion;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Esta clase permite generar el informe de la historia clínica de un paciente
 * de acuerdo a las opciones seleccionadas en el formulario Informe
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpInforme {
    
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
     * Método que permite obtener todos los pacientes registrados
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select tbl_historia_clinica.IdHistoriaClinica, tbl_pacientes.IdPaciente, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), tbl_historia_clinica.Estado from tbl_historia_clinica inner join tbl_pacientes on tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                Object[] columnas = new Object[4];
                for (int i = 0; i < 4; i++) {
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
     * Método que permite filtrar los registros según el paciente
     * @param IdPaciente
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String IdPaciente) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql;
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            sql = "select tbl_historia_clinica.IdHistoriaClinica, tbl_pacientes.IdPaciente, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), tbl_historia_clinica.Estado from tbl_historia_clinica inner join tbl_pacientes on tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente =" + IdPaciente + ";";
            
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                Object[] columnas = new Object[4];
                for (int i = 0; i < 4; i++) {
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
     * Método que permite obtener todas las terapias
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerTerapias() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdTerapia, Nombre from tbl_terapias";
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
     * Método que permite obtener toda la información de los antecedentes de un paciente
     * @param ide 
     */
    public static void buscar(String ide) {
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            String sql = "select AntPNatales, AntMed, AntFamiliares, AntQuirurgicos, OtrosAnt from tbl_pacientes where IdPaciente = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, ide);
            ResultSet r = cmd.executeQuery();

            while (r.next()) {
                OpPacientes.setAntPNatales(r.getString(1));
                OpPacientes.setAntMedicos(r.getString(2));
                OpPacientes.setAntFamiliares(r.getString(3));
                OpPacientes.setAntQuirurgicos(r.getString(4));
                OpPacientes.setOtrosAnt(r.getString(5));  
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que permite generar el reporte de la historia clínica de un paciente en el año actual, así como visualizarla
     * @param isHC
     * @param isEquino
     * @param isEduEsp
     * @param parametro
     * @param filtro 
     */
    public static void imprimir(InputStream isHC, InputStream isEquino, InputStream isEduEsp, Map parametro, String filtro){
        try {
            Connection con;
            con = Conexion.getConexionMysql();
            JasperReport jr = (JasperReport) JRLoader.loadObject(isHC);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Historia Clínica " + filtro);
            jv.setVisible(true);
            
            JasperReport jrequino = (JasperReport) JRLoader.loadObject(isEquino);
            JasperPrint jpequino = JasperFillManager.fillReport(jrequino, parametro, con);
            JasperViewer jvequino = new JasperViewer(jpequino, false);
            jvequino.setTitle("Historia Clínica Equinoterapia " + filtro);
            jvequino.setVisible(true);
            
            JasperReport jreduesp = (JasperReport) JRLoader.loadObject(isEduEsp);
            JasperPrint jpeduesp = JasperFillManager.fillReport(jreduesp, parametro, con);
            JasperViewer jveduesp = new JasperViewer(jpeduesp, false);
            jveduesp.setTitle("Historia Clínica Educación Especial " + filtro);
            jveduesp.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(OpProgramacionTerapeutica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que permite generar el reporte de la historia clínica de un paciente en un rango de fechas específico, así como visualizarla
     * @param isHC
     * @param isEquino
     * @param isEduEsp
     * @param parametro 
     * @param fechaInicial 
     * @param fechaFinal 
     */
    public static void imprimir(InputStream isHC, InputStream isEquino, InputStream isEduEsp, Map parametro, String fechaInicial, String fechaFinal){
        try {
            Connection con;
            con = Conexion.getConexionMysql();
            JasperReport jr = (JasperReport) JRLoader.loadObject(isHC);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Historia Clínica " + fechaInicial + " - " + fechaFinal);
            jv.setVisible(true);
            
            JasperReport jrequino = (JasperReport) JRLoader.loadObject(isEquino);
            JasperPrint jpequino = JasperFillManager.fillReport(jrequino, parametro, con);
            JasperViewer jvequino = new JasperViewer(jpequino, false);
            jvequino.setTitle("Historia Clínica Equinoterapia " + fechaInicial + " - " + fechaFinal);
            jvequino.setVisible(true);
            
            JasperReport jreduesp = (JasperReport) JRLoader.loadObject(isEduEsp);
            JasperPrint jpeduesp = JasperFillManager.fillReport(jreduesp, parametro, con);
            JasperViewer jveduesp = new JasperViewer(jpeduesp, false);
            jveduesp.setTitle("Historia Clínica Educación Especial " + fechaInicial + " - " + fechaFinal);
            jveduesp.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(OpProgramacionTerapeutica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que permite generar el reporte de la historia clínica de un paciente en una terapia específica, así como visualizarla
     * @param is
     * @param parametro
     * @param filtro 
     */
    public static void imprimir(InputStream is, Map parametro, String filtro){
        try {
            Connection con;
            con = Conexion.getConexionMysql();
            JasperReport jr = (JasperReport) JRLoader.loadObject(is);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Evolución " + filtro);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(OpProgramacionTerapeutica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que permite generar el reporte de la historia clínica de un paciente en una terapia específica y en un rango de fechas específico, 
     * así como visualizarla
     * @param is
     * @param parametro
     * @param filtro 
     * @param fechaInicial 
     * @param fechaFinal 
     */
    public static void imprimir(InputStream is, Map parametro, String filtro, String fechaInicial, String fechaFinal){
        try {
            Connection con;
            con = Conexion.getConexionMysql();
            JasperReport jr = (JasperReport) JRLoader.loadObject(is);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Evolución " + filtro + " " + fechaInicial + " - " + fechaFinal);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(OpProgramacionTerapeutica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
