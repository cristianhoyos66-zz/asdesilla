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
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Fonoaudiología
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpFonoaudiologia {
    private static Statement instruccion;
    
    private static String Fecha = "", IdHistoriaClinica = "", ActPrelinguisticas = "", ActLinguisticas = "", TipoLenguaje = "", RespNombre = "", ConoceNombre = "", AlimentacionActual = "", ControlEsfinteres = "", VesicalDiurno = "", VesicalNocturno = "", AnalDiurno = "", AnalNocturno = "", Observaciones = "", Profesional = "";

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
     * @return the ActPrelinguisticas
     */
    public static String getActPrelinguisticas() {
        return ActPrelinguisticas;
    }

    /**
     * @param aActPrelinguisticas the ActPrelinguisticas to set
     */
    public static void setActPrelinguisticas(String aActPrelinguisticas) {
        ActPrelinguisticas = aActPrelinguisticas;
    }

    /**
     * @return the ActLinguisticas
     */
    public static String getActLinguisticas() {
        return ActLinguisticas;
    }

    /**
     * @param aActLinguisticas the ActLinguisticas to set
     */
    public static void setActLinguisticas(String aActLinguisticas) {
        ActLinguisticas = aActLinguisticas;
    }

    /**
     * @return the TipoLenguaje
     */
    public static String getTipoLenguaje() {
        return TipoLenguaje;
    }

    /**
     * @param aTipoLenguaje the TipoLenguaje to set
     */
    public static void setTipoLenguaje(String aTipoLenguaje) {
        TipoLenguaje = aTipoLenguaje;
    }

    /**
     * @return the RespNombre
     */
    public static String getRespNombre() {
        return RespNombre;
    }

    /**
     * @param aRespNombre the RespNombre to set
     */
    public static void setRespNombre(String aRespNombre) {
        RespNombre = aRespNombre;
    }

    /**
     * @return the ConoceNombre
     */
    public static String getConoceNombre() {
        return ConoceNombre;
    }

    /**
     * @param aConoceNombre the ConoceNombre to set
     */
    public static void setConoceNombre(String aConoceNombre) {
        ConoceNombre = aConoceNombre;
    }

    /**
     * @return the AlimentacionActual
     */
    public static String getAlimentacionActual() {
        return AlimentacionActual;
    }

    /**
     * @param aAlimentacionActual the AlimentacionActual to set
     */
    public static void setAlimentacionActual(String aAlimentacionActual) {
        AlimentacionActual = aAlimentacionActual;
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
     * @return the ControlEsfinteres
     */
    public static String getControlEsfinteres() {
        return ControlEsfinteres;
    }

    /**
     * @param aControlEsfinteres the ControlEsfinteres to set
     */
    public static void setControlEsfinteres(String aControlEsfinteres) {
        ControlEsfinteres = aControlEsfinteres;
    }

    /**
     * @return the VesicalDiurno
     */
    public static String getVesicalDiurno() {
        return VesicalDiurno;
    }

    /**
     * @param aVesicalDiurno the VesicalDiurno to set
     */
    public static void setVesicalDiurno(String aVesicalDiurno) {
        VesicalDiurno = aVesicalDiurno;
    }

    /**
     * @return the VesicalNocturno
     */
    public static String getVesicalNocturno() {
        return VesicalNocturno;
    }

    /**
     * @param aVesicalNocturno the VesicalNocturno to set
     */
    public static void setVesicalNocturno(String aVesicalNocturno) {
        VesicalNocturno = aVesicalNocturno;
    }

    /**
     * @return the AnalDiurno
     */
    public static String getAnalDiurno() {
        return AnalDiurno;
    }

    /**
     * @param aAnalDiurno the AnalDiurno to set
     */
    public static void setAnalDiurno(String aAnalDiurno) {
        AnalDiurno = aAnalDiurno;
    }

    /**
     * @return the AnalNocturno
     */
    public static String getAnalNocturno() {
        return AnalNocturno;
    }

    /**
     * @param aAnalNocturno the AnalNocturno to set
     */
    public static void setAnalNocturno(String aAnalNocturno) {
        AnalNocturno = aAnalNocturno;
    }
    
    /**
     * Método que permite guardar la información obtenida en la base de datos.
     * @param fecha
     * @param hc
     * @param actPrelinguisticas
     * @param actLinguisticas
     * @param tipoLenguaje
     * @param respNombre
     * @param conoceNombre
     * @param alimentacionActual
     * @param controlEsfinteres
     * @param vesicalDiurno
     * @param vesicalNocturno
     * @param analDiurno
     * @param analNocturno
     * @param Observaciones
     * @param profesional 
     * @return aux 
     */
    public static int guardar(String fecha, String hc, String actPrelinguisticas, String actLinguisticas, String tipoLenguaje, String respNombre, String conoceNombre, String alimentacionActual, String controlEsfinteres, String vesicalDiurno, String vesicalNocturno, String analDiurno, String analNocturno, String Observaciones, String profesional) {
        int aux = 0;
        Connection conectar; 
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_fonoaudiologia").executeQuery();
            while (r.next()) {
                if (fecha.equals(r.getString("Fecha")) && hc.equals(r.getString("IdHistoriaClinica"))) {
                    JOptionPane.showMessageDialog(null, "El registro de la fonoaudiología ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                String sql = "INSERT INTO tbl_fonoaudiologia(IdHistoriaClinica, Fecha, ActPrelinguisticas, ActLinguisticas, TipoLenguaje, RespNombre, ConoceNombre, AlimentacionActual, Observaciones, ControlEsfinteres, VesicalDiurno, VesicalNocturno, AnalDiurno, AnalNocturno, Profesional) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, hc);
                cmd.setString(2, fecha);
                cmd.setString(3, actPrelinguisticas);
                cmd.setString(4, actLinguisticas);
                cmd.setString(5, tipoLenguaje);
                cmd.setString(6, respNombre);
                cmd.setString(7, conoceNombre);
                cmd.setString(8, alimentacionActual);
                cmd.setString(9, Observaciones);
                cmd.setString(10, controlEsfinteres);
                cmd.setString(11, vesicalDiurno);
                cmd.setString(12, vesicalNocturno);
                cmd.setString(13, analDiurno);
                cmd.setString(14, analNocturno);
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
                sql = "SELECT tbl_fonoaudiologia.Fecha, tbl_fonoaudiologia.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_fonoaudiologia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_fonoaudiologia.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_fonoaudiologia.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_fonoaudiologia.Fecha ='" + fecha + "' and tbl_pacientes.IdPaciente =" + IdPaciente + ";";
            }else{
                if(fecha != null){
                    sql = "SELECT tbl_fonoaudiologia.Fecha, tbl_fonoaudiologia.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_fonoaudiologia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_fonoaudiologia.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_fonoaudiologia.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_fonoaudiologia.Fecha ='" + fecha + "';";
                }else{
                    sql = "SELECT tbl_fonoaudiologia.Fecha, tbl_fonoaudiologia.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_fonoaudiologia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_fonoaudiologia.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_fonoaudiologia.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente =" + IdPaciente + ";";
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
     * Método que permite buscar la información de un registro de fonoaudiología en la base de datos, 
     * de acuerdo a la fecha y la historia clínica.
     * @param fecha 
     * @param hc 
     */
    public static void buscar(String fecha, String hc) { 
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select * from tbl_fonoaudiologia where Fecha = ? and IdHistoriaClinica = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, fecha);
            cmd.setString(2, hc);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                IdHistoriaClinica = r.getString(1);
                Fecha = r.getString(2);
                ActPrelinguisticas = r.getString(3);
                ActLinguisticas = r.getString(4);
                TipoLenguaje = r.getString(5);
                RespNombre = r.getString(6);
                ConoceNombre = r.getString(7);
                AlimentacionActual = r.getString(8);
                Observaciones = r.getString(9);
                ControlEsfinteres = r.getString(10);
                VesicalDiurno = r.getString(11);
                VesicalNocturno = r.getString(12);
                AnalDiurno = r.getString(13);
                AnalNocturno = r.getString(14);
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
            String sql = "SELECT tbl_fonoaudiologia.Fecha, tbl_fonoaudiologia.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_fonoaudiologia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_fonoaudiologia.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_fonoaudiologia.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
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
     * Método que permite obtener los pacientes coincidentes con la búsqueda y que tengan asignada una evaluación en dicha fecha
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
     * Método que permite obtener todos los pacientes registrados
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
            String sql = "SELECT * FROM tbl_estudios_compl e inner join tbl_terapias t on t.IdTerapia = e.IdTerapia where e.IdHistoriaClinica = ? and t.IdTerapia = 2";
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
