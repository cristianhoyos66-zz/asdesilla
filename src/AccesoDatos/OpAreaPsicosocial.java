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
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Área Psicosocial
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpAreaPsicosocial {
    private static Statement instruccion;
    
    private static String Fecha = "", IdHistoriaClinica = "", EntPadres = "", EntFamiliares = "", EntCompaneros = "", EntExtranos = "", PerMayorT = "", Fortalezas = "", Debilidades = "", 
            ResptNorma = "", TransgNorma = "", ObdOrdenes = "", Autoridad = "", ActPreferida = "", DiaCotidiano = "", Escolaridad = "", Horario = "", Lugar = "", FBanoCorp = "", FVestirse = "", 
            FLavarse = "", FAlimentacion = "", FPeinarse = "", FAbotonarse = "", FDormir = "", FAmarrarse = "", Observaciones = "", Profesional = "";

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
     * @return the EntPadres
     */
    public static String getEntPadres() {
        return EntPadres;
    }

    /**
     * @param aEntPadres the EntPadres to set
     */
    public static void setEntPadres(String aEntPadres) {
        EntPadres = aEntPadres;
    }

    /**
     * @return the EntFamiliares
     */
    public static String getEntFamiliares() {
        return EntFamiliares;
    }

    /**
     * @param aEntFamiliares the EntFamiliares to set
     */
    public static void setEntFamiliares(String aEntFamiliares) {
        EntFamiliares = aEntFamiliares;
    }

    /**
     * @return the EntCompaneros
     */
    public static String getEntCompaneros() {
        return EntCompaneros;
    }

    /**
     * @param aEntCompaneros the EntCompaneros to set
     */
    public static void setEntCompaneros(String aEntCompaneros) {
        EntCompaneros = aEntCompaneros;
    }

    /**
     * @return the EntExtranos
     */
    public static String getEntExtranos() {
        return EntExtranos;
    }

    /**
     * @param aEntExtranos the EntExtranos to set
     */
    public static void setEntExtranos(String aEntExtranos) {
        EntExtranos = aEntExtranos;
    }

    /**
     * @return the PerMayorT
     */
    public static String getPerMayorT() {
        return PerMayorT;
    }

    /**
     * @param aPerMayorT the PerMayorT to set
     */
    public static void setPerMayorT(String aPerMayorT) {
        PerMayorT = aPerMayorT;
    }

    /**
     * @return the Fortalezas
     */
    public static String getFortalezas() {
        return Fortalezas;
    }

    /**
     * @param aFortalezas the Fortalezas to set
     */
    public static void setFortalezas(String aFortalezas) {
        Fortalezas = aFortalezas;
    }

    /**
     * @return the Debilidades
     */
    public static String getDebilidades() {
        return Debilidades;
    }

    /**
     * @param aDebilidades the Debilidades to set
     */
    public static void setDebilidades(String aDebilidades) {
        Debilidades = aDebilidades;
    }

    /**
     * @return the ResptNorma
     */
    public static String getResptNorma() {
        return ResptNorma;
    }

    /**
     * @param aResptNorma the ResptNorma to set
     */
    public static void setResptNorma(String aResptNorma) {
        ResptNorma = aResptNorma;
    }

    /**
     * @return the TransgNorma
     */
    public static String getTransgNorma() {
        return TransgNorma;
    }

    /**
     * @param aTransgNorma the TransgNorma to set
     */
    public static void setTransgNorma(String aTransgNorma) {
        TransgNorma = aTransgNorma;
    }

    /**
     * @return the ObdOrdenes
     */
    public static String getObdOrdenes() {
        return ObdOrdenes;
    }

    /**
     * @param aObdOrdenes the ObdOrdenes to set
     */
    public static void setObdOrdenes(String aObdOrdenes) {
        ObdOrdenes = aObdOrdenes;
    }

    /**
     * @return the Autoridad
     */
    public static String getAutoridad() {
        return Autoridad;
    }

    /**
     * @param aAutoridad the Autoridad to set
     */
    public static void setAutoridad(String aAutoridad) {
        Autoridad = aAutoridad;
    }

    /**
     * @return the ActPreferida
     */
    public static String getActPreferida() {
        return ActPreferida;
    }

    /**
     * @param aActPreferida the ActPreferida to set
     */
    public static void setActPreferida(String aActPreferida) {
        ActPreferida = aActPreferida;
    }

    /**
     * @return the DiaCotidiano
     */
    public static String getDiaCotidiano() {
        return DiaCotidiano;
    }

    /**
     * @param aDiaCotidiano the DiaCotidiano to set
     */
    public static void setDiaCotidiano(String aDiaCotidiano) {
        DiaCotidiano = aDiaCotidiano;
    }

    /**
     * @return the Escolaridad
     */
    public static String getEscolaridad() {
        return Escolaridad;
    }

    /**
     * @param aEscolaridad the Escolaridad to set
     */
    public static void setEscolaridad(String aEscolaridad) {
        Escolaridad = aEscolaridad;
    }

    /**
     * @return the Horario
     */
    public static String getHorario() {
        return Horario;
    }

    /**
     * @param aHorario the Horario to set
     */
    public static void setHorario(String aHorario) {
        Horario = aHorario;
    }

    /**
     * @return the Lugar
     */
    public static String getLugar() {
        return Lugar;
    }

    /**
     * @param aLugar the Lugar to set
     */
    public static void setLugar(String aLugar) {
        Lugar = aLugar;
    }

    /**
     * @return the FBanoCorp
     */
    public static String getFBanoCorp() {
        return FBanoCorp;
    }

    /**
     * @param aFBanoCorp the FBanoCorp to set
     */
    public static void setFBanoCorp(String aFBanoCorp) {
        FBanoCorp = aFBanoCorp;
    }

    /**
     * @return the FVestirse
     */
    public static String getFVestirse() {
        return FVestirse;
    }

    /**
     * @param aFVestirse the FVestirse to set
     */
    public static void setFVestirse(String aFVestirse) {
        FVestirse = aFVestirse;
    }

    /**
     * @return the FLavarse
     */
    public static String getFLavarse() {
        return FLavarse;
    }

    /**
     * @param aFLavarse the FLavarse to set
     */
    public static void setFLavarse(String aFLavarse) {
        FLavarse = aFLavarse;
    }

    /**
     * @return the FAlimentacion
     */
    public static String getFAlimentacion() {
        return FAlimentacion;
    }

    /**
     * @param aFAlimentacion the FAlimentacion to set
     */
    public static void setFAlimentacion(String aFAlimentacion) {
        FAlimentacion = aFAlimentacion;
    }

    /**
     * @return the FPeinarse
     */
    public static String getFPeinarse() {
        return FPeinarse;
    }

    /**
     * @param aFPeinarse the FPeinarse to set
     */
    public static void setFPeinarse(String aFPeinarse) {
        FPeinarse = aFPeinarse;
    }

    /**
     * @return the FAbotonarse
     */
    public static String getFAbotonarse() {
        return FAbotonarse;
    }

    /**
     * @param aFAbotonarse the FAbotonarse to set
     */
    public static void setFAbotonarse(String aFAbotonarse) {
        FAbotonarse = aFAbotonarse;
    }

    /**
     * @return the FDormir
     */
    public static String getFDormir() {
        return FDormir;
    }

    /**
     * @param aFDormir the FDormir to set
     */
    public static void setFDormir(String aFDormir) {
        FDormir = aFDormir;
    }

    /**
     * @return the FAmarrarse
     */
    public static String getFAmarrarse() {
        return FAmarrarse;
    }

    /**
     * @param aFAmarrarse the FAmarrarse to set
     */
    public static void setFAmarrarse(String aFAmarrarse) {
        FAmarrarse = aFAmarrarse;
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
     * Método que obtiene el id de todos los pacientes coincidentes registrados en la tabla pacientes, 
     * que tienen asignado por lo menos una evaluación, 
     * a fin de cargarlos en el JCombo del formulario Área psicosocial.
     * @param busqueda
     * @param fecha
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerPacientes(String busqueda, String fecha) throws SQLException {
        Map<Integer, String> result = new HashMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select tbl_evaluacion.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_evaluacion INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_evaluacion.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente LIKE '%"+busqueda+"%' and tbl_evaluacion.Fecha = ? LIMIT 10;";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, fecha);
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
     * Método que obtiene el id de todos los pacientes registrados en la tabla pacientes, 
     * que tienen asignado por lo menos una evaluación, 
     * a fin de cargarlos en el JCombo del formulario Área psicosocial.
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
     * Método que consulta los pacientes coincidentes a fin de cargarlos en el registro del área psicosocial
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
     * Método que consulta los profesionales coincidentes a fin de cargarlos en el registro del área psicosocial
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
     * @param entPadres
     * @param entFamiliares
     * @param entCompaneros
     * @param entExtranos
     * @param perMayorT
     * @param fortalezas
     * @param debilidades
     * @param resptNorma
     * @param transgNorma
     * @param obdOrdenes
     * @param autoridad
     * @param actPreferida
     * @param diaCotidiano
     * @param escolaridad
     * @param horario
     * @param lugar
     * @param fBanoCorp
     * @param fVestirse
     * @param fLavarse
     * @param fAlimentacion
     * @param fPeinarse
     * @param fAbotonarse
     * @param fDormir
     * @param fAmarrarse
     * @param Observaciones
     * @param profesional 
     * @return aux
     */
    public static int guardar(String fecha, String hc, String entPadres, String entFamiliares, String entCompaneros, String entExtranos, String perMayorT, String fortalezas, String debilidades, 
            String resptNorma, String transgNorma, String obdOrdenes, String autoridad, String actPreferida, String diaCotidiano, String escolaridad, String horario, String lugar, String fBanoCorp, String fVestirse, 
            String fLavarse, String fAlimentacion, String fPeinarse, String fAbotonarse, String fDormir, String fAmarrarse, String Observaciones, String profesional) {
        int aux = 0;
        Connection conectar; 
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_area_psicosocial").executeQuery();
            while (r.next()) {
                if (fecha.equals(r.getString("Fecha")) && hc.equals(r.getString("IdHistoriaClinica"))) {
                    JOptionPane.showMessageDialog(null, "El registro del área psicosocial ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                //instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "INSERT INTO tbl_area_psicosocial(IdHistoriaClinica, Fecha, EntPadres, EntFamiliares, EntCompaneros, EntExtranos, PerMayorT, Fortalezas, Debilidades, ResptNorma, TransgNorma, ObdOrdenes, Autoridad, ActPreferida, DiaCotidiano, Escolaridad, Horario, Lugar, FBanoCorp, FVestirse, FLavarse, FAlimentacion, FPeinarse, FAbotonarse, FDormir, FAmarrarse, Observaciones, Profesional) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, hc);
                cmd.setString(2, fecha);
                cmd.setString(3, entPadres);
                cmd.setString(4, entFamiliares);
                cmd.setString(5, entCompaneros);
                cmd.setString(6, entExtranos);
                cmd.setString(7, perMayorT);
                cmd.setString(8, fortalezas);
                cmd.setString(9, debilidades);
                cmd.setString(10, resptNorma);
                cmd.setString(11, transgNorma);
                cmd.setString(12, obdOrdenes);
                cmd.setString(13, autoridad);
                cmd.setString(14, actPreferida);
                cmd.setString(15, diaCotidiano);
                cmd.setString(16, escolaridad);
                cmd.setString(17, horario);
                cmd.setString(18, lugar);
                cmd.setString(19, fBanoCorp);
                cmd.setString(20, fVestirse);
                cmd.setString(21, fLavarse);
                cmd.setString(22, fAlimentacion);
                cmd.setString(23, fPeinarse);
                cmd.setString(24, fAbotonarse);
                cmd.setString(25, fDormir);
                cmd.setString(26, fAmarrarse);
                cmd.setString(27, Observaciones);
                cmd.setString(28, profesional);
                cmd.execute();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }
            //JOptionPane.showMessageDialog(null, "se guardó");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
    }
    
    /**
     * Método que obtiene todos los registros de la base de datos
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "SELECT tbl_area_psicosocial.Fecha, tbl_area_psicosocial.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_area_psicosocial INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_area_psicosocial.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_area_psicosocial.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
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
     * Método que permite buscar un registro específico en la base de datos, por fecha o paciente
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
                sql = "SELECT tbl_area_psicosocial.Fecha, tbl_area_psicosocial.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_area_psicosocial INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_area_psicosocial.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_area_psicosocial.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_area_psicosocial.Fecha ='" + fecha + "' and tbl_pacientes.IdPaciente =" + IdPaciente + ";";
            }else{
                if(fecha != null){
                    sql = "SELECT tbl_area_psicosocial.Fecha, tbl_area_psicosocial.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_area_psicosocial INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_area_psicosocial.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_area_psicosocial.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_area_psicosocial.Fecha ='" + fecha + "';";
                }else{
                    sql = "SELECT tbl_area_psicosocial.Fecha, tbl_area_psicosocial.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_area_psicosocial INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_area_psicosocial.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_area_psicosocial.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente =" + IdPaciente + ";";
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
     * Método que permite traer toda la información de un registro
     * @param fecha
     * @param hc 
     */
    public static void buscar(String fecha, String hc) {
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select * from tbl_area_psicosocial where Fecha = ? and IdHistoriaClinica = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, fecha);
            cmd.setString(2, hc);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                IdHistoriaClinica = r.getString(1);
                Fecha = r.getString(2);
                EntPadres = r.getString(3);
                EntFamiliares = r.getString(4);
                EntCompaneros = r.getString(5);
                EntExtranos = r.getString(6);
                PerMayorT = r.getString(7);
                Fortalezas = r.getString(8);
                Debilidades = r.getString(9);
                ResptNorma = r.getString(10);
                TransgNorma = r.getString(11);
                ObdOrdenes = r.getString(12);
                Autoridad = r.getString(13);
                ActPreferida = r.getString(14);
                DiaCotidiano = r.getString(15);
                Escolaridad = r.getString(16);
                Horario = r.getString(17);
                Lugar = r.getString(18);
                FBanoCorp = r.getString(19);
                FVestirse = r.getString(20);
                FLavarse = r.getString(21);
                FAlimentacion = r.getString(22);
                FPeinarse = r.getString(23);
                FAbotonarse = r.getString(24);
                FDormir = r.getString(25);
                FAmarrarse = r.getString(26);
                Observaciones = r.getString(27);
                Profesional = r.getString(28);
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que permite validar si el paciente tiene asiganada dicha terapia
     * @param hc
     * @return result
     */
    public static boolean validarTerapias(String hc) {
        boolean result = false;
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            String sql = "SELECT * FROM tbl_estudios_compl e inner join tbl_terapias t on t.IdTerapia = e.IdTerapia where e.IdHistoriaClinica = ? and t.IdTerapia = 3";
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
    
    /**
     * Método que permite cargar todos los registros de autoridad en el formulario área psicosocial
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerAutoridad() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdPAutoridad, Nombre from tbl_autoridad";
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
}
