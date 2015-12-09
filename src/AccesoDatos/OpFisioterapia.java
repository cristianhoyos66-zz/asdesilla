/*
 * To change this template, choose Tools | Templates
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
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Fisioterapia
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpFisioterapia {
    private static Statement instruccion;
    
    private static String Fecha = "", IdHistoriaClinica = "", ControlCefalico = "", Rolados = "", Arrastre = "", Gateo = "", 
            Sedestesacion = "", Bipedestacion = "", Marcha = "", Apoyo = "", PartesCuerpo = "", DPartesCuerpo = "", TonoMuscular = "", Observaciones = "", Profesional = "";

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
     * @return the Paciente
     */
    public static String getIdHistoriaClinica() {
        return IdHistoriaClinica;
    }

    /**
     * @param aIdHistoriaClinica
     */
    public static void setIdHistoriaClinica(String aIdHistoriaClinica) {
        IdHistoriaClinica = aIdHistoriaClinica;
    }

    /**
     * @return the ControlCefalico
     */
    public static String getControlCefalico() {
        return ControlCefalico;
    }

    /**
     * @param aControlCefalico the ControlCefalico to set
     */
    public static void setControlCefalico(String aControlCefalico) {
        ControlCefalico = aControlCefalico;
    }

    /**
     * @return the Rolados
     */
    public static String getRolados() {
        return Rolados;
    }

    /**
     * @param aRolados the Rolados to set
     */
    public static void setRolados(String aRolados) {
        Rolados = aRolados;
    }

    /**
     * @return the Arrastre
     */
    public static String getArrastre() {
        return Arrastre;
    }

    /**
     * @param aArrastre the Arrastre to set
     */
    public static void setArrastre(String aArrastre) {
        Arrastre = aArrastre;
    }

    /**
     * @return the Gateo
     */
    public static String getGateo() {
        return Gateo;
    }

    /**
     * @param aGateo the Gateo to set
     */
    public static void setGateo(String aGateo) {
        Gateo = aGateo;
    }

    /**
     * @return the Sedestesacion
     */
    public static String getSedestesacion() {
        return Sedestesacion;
    }

    /**
     * @param aSedestesacion the Sedestesacion to set
     */
    public static void setSedestesacion(String aSedestesacion) {
        Sedestesacion = aSedestesacion;
    }

    /**
     * @return the Bipedestacion
     */
    public static String getBipedestacion() {
        return Bipedestacion;
    }

    /**
     * @param aBipedestacion the Bipedestacion to set
     */
    public static void setBipedestacion(String aBipedestacion) {
        Bipedestacion = aBipedestacion;
    }

    /**
     * @return the Marcha
     */
    public static String getMarcha() {
        return Marcha;
    }

    /**
     * @param aMarcha the Marcha to set
     */
    public static void setMarcha(String aMarcha) {
        Marcha = aMarcha;
    }

    /**
     * @return the Apoyo
     */
    public static String getApoyo() {
        return Apoyo;
    }

    /**
     * @param aApoyo the Apoyo to set
     */
    public static void setApoyo(String aApoyo) {
        Apoyo = aApoyo;
    }

    /**
     * @return the PartesCuerpo
     */
    public static String getPartesCuerpo() {
        return PartesCuerpo;
    }

    /**
     * @param aPartesCuerpo the PartesCuerpo to set
     */
    public static void setPartesCuerpo(String aPartesCuerpo) {
        PartesCuerpo = aPartesCuerpo;
    }

    /**
     * @return the DPartesCuerpo
     */
    public static String getDPartesCuerpo() {
        return DPartesCuerpo;
    }

    /**
     * @param aDPartesCuerpo the DPartesCuerpo to set
     */
    public static void setDPartesCuerpo(String aDPartesCuerpo) {
        DPartesCuerpo = aDPartesCuerpo;
    }

    /**
     * @return the TonoMuscular
     */
    public static String getTonoMuscular() {
        return TonoMuscular;
    }

    /**
     * @param aTonoMuscular the TonoMuscular to set
     */
    public static void setTonoMuscular(String aTonoMuscular) {
        TonoMuscular = aTonoMuscular;
    }

    /**
     * @return the Observaciones
     */
    public static String getObservaciones() {
        return Observaciones;
    }

    /**
     * @param aObservaciones the Observaciones to set
     */
    public static void setObservaciones(String aObservaciones) {
        Observaciones = aObservaciones;
    }

    /**
     * @return the Profesional
     */
    public static String getProfesional() {
        return Profesional;
    }

    /**
     * @param aProfesional the Profesional to set
     */
    public static void setProfesional(String aProfesional) {
        Profesional = aProfesional;
    }
    
    /**
     * Método que permite obtener los pacientes coincidentes con la búsqueda que tienen asignada una evaluación en dicha fecha
     * @param busqueda
     * @param fecha
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerPacientes(String busqueda, String fecha) throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select tbl_evaluacion.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_evaluacion INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_evaluacion.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente LIKE '%"+busqueda+"%' and tbl_evaluacion.Fecha = ? LIMIT 10;";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, fecha);
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
     * Método que permite obtener todos los pacientes registrados en la base de datos
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerPacientes() throws SQLException {
        Map<Integer, String> result = new HashMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select tbl_evaluacion.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_evaluacion INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_evaluacion.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
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
     * Método que permite guardar la información obtenida en la base de datos.
     * @param fecha
     * @param hc
     * @param controlCefalico
     * @param rolados
     * @param arrastre
     * @param gateo
     * @param sedestesacion
     * @param bipedestacion
     * @param marcha
     * @param apoyo
     * @param partesCuerpo
     * @param dPartesCuerpo
     * @param tonoMuscular 
     * @param Observaciones
     * @param profesional 
     * @return aux 
     */
    public static int guardar(String fecha, String hc, String controlCefalico, String rolados, String arrastre, String gateo, String sedestesacion, String bipedestacion, String marcha, String apoyo, String partesCuerpo, String dPartesCuerpo, String tonoMuscular, String Observaciones, String profesional) {
        int aux = 0;
        Connection conectar; 
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_fisioterapia").executeQuery();
            while (r.next()) {
                if (fecha.equals(r.getString("Fecha")) && hc.equals(r.getString("IdHistoriaClinica"))) {
                    JOptionPane.showMessageDialog(null, "El registro de la fisioterapia ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                String sql = "INSERT INTO tbl_fisioterapia(IdHistoriaClinica, Fecha, ControlCefalico, Rolados, Arrastre, Gateo, Sedestesacion, Bipedestacion, Marcha, Apoyo, PartesCuerpo, DPartesCuerpo, TonoMuscular, Observaciones, Profesional) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, hc);
                cmd.setString(2, fecha);
                cmd.setString(3, controlCefalico);
                cmd.setString(4, rolados);
                cmd.setString(5, arrastre);
                cmd.setString(6, gateo);
                cmd.setString(7, sedestesacion);
                cmd.setString(8, bipedestacion);
                cmd.setString(9, marcha);
                cmd.setString(10, apoyo);
                cmd.setString(11, partesCuerpo);
                cmd.setString(12, dPartesCuerpo);
                cmd.setString(13, tonoMuscular);
                cmd.setString(14, Observaciones);
                cmd.setString(15, profesional);
                cmd.execute();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
    }
    
    /**
     * Método que permite filtrar los registros por una fecha o un paciente específico
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
                sql = "SELECT tbl_fisioterapia.Fecha, tbl_fisioterapia.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_fisioterapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_fisioterapia.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_fisioterapia.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_fisioterapia.Fecha ='" + fecha + "' and tbl_pacientes.IdPaciente =" + IdPaciente + ";";
            }else{
                if(fecha != null){
                    sql = "SELECT tbl_fisioterapia.Fecha, tbl_fisioterapia.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_fisioterapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_fisioterapia.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_fisioterapia.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_fisioterapia.Fecha ='" + fecha + "';";
                }else{
                    sql = "SELECT tbl_fisioterapia.Fecha, tbl_fisioterapia.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_fisioterapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_fisioterapia.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_fisioterapia.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente =" + IdPaciente + ";";
                }
            }
            
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
     * Método que permite buscar la información de un registro de una fisioterapia en la base de datos, 
     * de acuerdo a la fecha e historia clínica
     * @param fecha 
     * @param hc 
     */
    public static void buscar(String fecha, String hc) { 
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select * from tbl_fisioterapia where Fecha = ? and IdHistoriaClinica = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, fecha);
            cmd.setString(2, hc);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                IdHistoriaClinica = r.getString(1);
                Fecha = r.getString(2);
                ControlCefalico = r.getString(3);
                Rolados = r.getString(4);
                Arrastre = r.getString(5);
                Gateo = r.getString(6);
                Sedestesacion = r.getString(7);
                Bipedestacion = r.getString(8);
                Marcha = r.getString(9);
                Apoyo = r.getString(10);
                PartesCuerpo = r.getString(11);
                DPartesCuerpo = r.getString(12);
                TonoMuscular = r.getString(13);
                Observaciones = r.getString(14);
                Profesional = r.getString(15);
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }   
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
            String sql = "SELECT tbl_fisioterapia.Fecha, tbl_fisioterapia.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_fisioterapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_fisioterapia.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_fisioterapia.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
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
     * Método que permite validar si el paciente tiene asignada dicha terapia
     * @param hc
     * @return result
     */
    public static boolean validarTerapias(String hc) {
        boolean result = false;
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            String sql = "SELECT * FROM tbl_estudios_compl e inner join tbl_terapias t on t.IdTerapia = e.IdTerapia where e.IdHistoriaClinica = ? and t.IdTerapia = 1";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, hc);
            ResultSet r = cmd.executeQuery();
            if (r.next()) {
                result = true;
                aux = 1;
            }
            if (aux == 0) {
                //JOptionPane.showMessageDialog(null, "No se encontró el registro");
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return result;
    }
}
