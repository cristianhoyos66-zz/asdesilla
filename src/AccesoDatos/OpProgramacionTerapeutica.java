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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Programación Terapéutica
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpProgramacionTerapeutica {
    private static Statement instruccion;
    
    private static String Fecha = "", IdHistoriaClinica = "", TipoMonta = "", Antecedentes = "", ObjetivoGeneral = "", ObjetivosEspecificos = "", Estrategias = "", MaterialDidactico = "", Comentarios = "";

    /**
     * @return the Fecha
     */
    public static String getFecha() {
        return Fecha;
    }

    /**
     * @param aFecha the Fecha to set
     */
    public static void setFecha(String aFecha) {
        Fecha = aFecha;
    }

    /**
     * @return the IdHistoriaClinica
     */
    public static String getIdHistoriaClinica() {
        return IdHistoriaClinica;
    }

    /**
     * @param aIdHistoriaClinica the IdHistoriaClinica to set
     */
    public static void setIdHistoriaClinica(String aIdHistoriaClinica) {
        IdHistoriaClinica = aIdHistoriaClinica;
    }

    /**
     * @return the TipoMonta
     */
    public static String getTipoMonta() {
        return TipoMonta;
    }

    /**
     * @param aFormaEnsenanza the TipoMonta to set
     */
    public static void setTipoMonta(String aFormaEnsenanza) {
        TipoMonta = aFormaEnsenanza;
    }

    /**
     * @return the Antecedentes
     */
    public static String getAntecedentes() {
        return Antecedentes;
    }

    /**
     * @param aAntecedentes the Antecedentes to set
     */
    public static void setAntecedentes(String aAntecedentes) {
        Antecedentes = aAntecedentes;
    }

    /**
     * @return the ObjetivoGeneral
     */
    public static String getObjetivoGeneral() {
        return ObjetivoGeneral;
    }

    /**
     * @param aObjetivoGeneral the ObjetivoGeneral to set
     */
    public static void setObjetivoGeneral(String aObjetivoGeneral) {
        ObjetivoGeneral = aObjetivoGeneral;
    }

    /**
     * @return the ObjetivosEspecificos
     */
    public static String getObjetivosEspecificos() {
        return ObjetivosEspecificos;
    }

    /**
     * @param aObjetivosEspecificos the ObjetivosEspecificos to set
     */
    public static void setObjetivosEspecificos(String aObjetivosEspecificos) {
        ObjetivosEspecificos = aObjetivosEspecificos;
    }

    /**
     * @return the Estrategias
     */
    public static String getEstrategias() {
        return Estrategias;
    }

    /**
     * @param aEstrategias the Estrategias to set
     */
    public static void setEstrategias(String aEstrategias) {
        Estrategias = aEstrategias;
    }

    /**
     * @return the MaterialDidactico
     */
    public static String getMaterialDidactico() {
        return MaterialDidactico;
    }

    /**
     * @param aMaterialDidactico the MaterialDidactico to set
     */
    public static void setMaterialDidactico(String aMaterialDidactico) {
        MaterialDidactico = aMaterialDidactico;
    }

    /**
     * @return the Comentarios
     */
    public static String getComentarios() {
        return Comentarios;
    }

    /**
     * @param aComentarios the Comentarios to set
     */
    public static void setComentarios(String aComentarios) {
        Comentarios = aComentarios;
    }
    
    /**
     * Método que permite obtener los pacientes coincidentes con la búsqueda que se encuentran activos
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
     * Método que permite obtener todos los pacientes registrados
     * @return
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
     * Método que permite obtener todos los registros de forma de enseñanza a fin de cargarlos en el formulario
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerFormaEnsenanza() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdFormaEnsenanza, NombreFormaEnsenanza from tbl_forma_ensenanza";
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
     * Método que permite guardar el registro de la programación terapéutica en la base de datos
     * @param fecha
     * @param mes
     * @param anno
     * @param hc
     * @param formaEnsenanza
     * @param antecedentes
     * @param objGeneral
     * @param objEspecificos
     * @param estrategias
     * @param materialDidactico
     * @param comentarios 
     * @return aux 
     */
    public static int Guardar(String fecha, String mes, String anno, String hc, String formaEnsenanza, String antecedentes, String objGeneral, String objEspecificos, String estrategias, String materialDidactico, String comentarios) {
        int aux = 0;
        Connection conectar; 
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("select date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%Y') as año, date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%m') as mes, IdHistoriaClinica from tbl_planeacion_terapeutica").executeQuery();
            while (r.next()) {
                if (hc.equals(r.getString("IdHistoriaClinica"))) {
                    if (Integer.parseInt(mes) == r.getInt("mes")) {
                        if (Integer.parseInt(anno) == r.getInt("año")) {
                            JOptionPane.showMessageDialog(null, "El registro de la programación terapéutica ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                            aux = 1;
                        }
                    }
                }
            }
            if (aux != 1) {
                //instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "insert into tbl_planeacion_terapeutica(IdHistoriaClinica, FechaDiligencia, FormaEnsenanza, Antecedentes, ObjGeneral, ObjEspecificos, Estrategia, MaterialDidactico, Comentarios) values (?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, hc);
                cmd.setString(2, fecha);
                cmd.setString(3, formaEnsenanza);
                cmd.setString(4, antecedentes);
                cmd.setString(5, objGeneral);
                cmd.setString(6, objEspecificos);
                cmd.setString(7, estrategias);
                cmd.setString(8, materialDidactico);
                cmd.setString(9, comentarios);
                cmd.execute();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
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
            String sql = "SELECT tbl_planeacion_terapeutica.FechaDiligencia, tbl_planeacion_terapeutica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_planeacion_terapeutica INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_planeacion_terapeutica.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                Object[] columnas = new Object[3];
                for (int i = 0; i < 3; i++) {
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
     * Método que permite filtrar los registros por un paciente, un mes o un año específico
     * @param IdPaciente
     * @param mes
     * @param anno
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String IdPaciente, int mes, int anno) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql = "";
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            if (IdPaciente != null && mes != 0 && anno != 0) {
                sql = "SELECT tbl_planeacion_terapeutica.FechaDiligencia, tbl_planeacion_terapeutica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_planeacion_terapeutica INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_planeacion_terapeutica.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente = '"+IdPaciente+"' and date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%m') = "+mes+" and date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%Y') = "+anno+";";
            }else{
                if (IdPaciente != null && mes != 0) {
                    sql = "SELECT tbl_planeacion_terapeutica.FechaDiligencia, tbl_planeacion_terapeutica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_planeacion_terapeutica INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_planeacion_terapeutica.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente = '"+IdPaciente+"' and date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%m') = "+mes+";";
                }else if (IdPaciente != null && anno != 0) {
                    sql = "SELECT tbl_planeacion_terapeutica.FechaDiligencia, tbl_planeacion_terapeutica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_planeacion_terapeutica INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_planeacion_terapeutica.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente = '"+IdPaciente+"' and date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%Y') = "+anno+";";
                }else if (mes != 0 && anno != 0) {
                    sql = "SELECT tbl_planeacion_terapeutica.FechaDiligencia, tbl_planeacion_terapeutica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_planeacion_terapeutica INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_planeacion_terapeutica.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%m') = "+mes+" and date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%Y') = "+anno+";"; 
                }else if(IdPaciente != null){
                    sql = "SELECT tbl_planeacion_terapeutica.FechaDiligencia, tbl_planeacion_terapeutica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_planeacion_terapeutica INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_planeacion_terapeutica.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente = '"+IdPaciente+"';";
                }else if(mes != 0){
                    sql = "SELECT tbl_planeacion_terapeutica.FechaDiligencia, tbl_planeacion_terapeutica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_planeacion_terapeutica INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_planeacion_terapeutica.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%m') = "+mes+";";
                }else if(anno != 0){
                    sql = "SELECT tbl_planeacion_terapeutica.FechaDiligencia, tbl_planeacion_terapeutica.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_planeacion_terapeutica INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_planeacion_terapeutica.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where date_format(str_to_date(FechaDiligencia, '%d/%m/%Y'), '%Y') = "+anno+";";
                } 
            }
            
            PreparedStatement cmd = conectar.prepareStatement(sql);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                Object[] columnas = new Object[3];
                for (int i = 0; i < 3; i++) {
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
     * Método que permite obtener toda la información de una programación terapéutica
     * @param fecha
     * @param hc 
     */
    public static void buscar(String fecha, String hc) { 
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select * from tbl_planeacion_terapeutica where FechaDiligencia = ? and IdHistoriaClinica = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, fecha);
            cmd.setString(2, hc);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                IdHistoriaClinica = r.getString(1);
                Fecha = r.getString(2);
                TipoMonta = r.getString(3);
                Antecedentes = r.getString(4);
                ObjetivoGeneral = r.getString(5);
                ObjetivosEspecificos = r.getString(6);
                Estrategias = r.getString(7);
                MaterialDidactico = r.getString(8);
                Comentarios = r.getString(9);
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que permite generar un informe de la programación terapéutica de un paciente
     * @param is
     * @param parametro
     * @param ruta 
     */
    public static void imprimir(InputStream is, Map parametro, String ruta){
        try {
            Connection con;
            con = Conexion.getConexionMysql();
            JasperReport jr = (JasperReport) JRLoader.loadObject(is);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con);
            JasperExportManager.exportReportToPdfFile(jp, ruta);
        } catch (JRException ex) {
            Logger.getLogger(OpProgramacionTerapeutica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
