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
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Evaluaciones
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpEvaluaciones {
    
    private static Statement instruccion;
    
    private static String Fecha = "", IdHistoriaClinica = "", MotivoConsulta = "", DiagMed = "", 
            TratMedActual = "", Peso = "", FC = "", FR = "", PA = "", Talla = "", IMC = "", Profesional = ""; 

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
     * @return the IdPaciente
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
     * @return the MC
     */
    public static String getMotivoConsulta() {
        return MotivoConsulta;
    }

    /**
     * @param aMotivoConsulta
     */
    public static void setMotivoConsulta(String aMotivoConsulta) {
        MotivoConsulta = aMotivoConsulta;
    }

    /**
     * @return the DiagMed
     */
    public static String getDiagMed() {
        return DiagMed;
    }

    /**
     * @param aDiagMed the DiagMed to set
     */
    public static void setDiagMed(String aDiagMed) {
        DiagMed = aDiagMed;
    }

    /**
     * @return the TratMedActual
     */
    public static String getTratMedActual() {
        return TratMedActual;
    }

    /**
     * @param aTratMedActual the TratMedActual to set
     */
    public static void setTratMedActual(String aTratMedActual) {
        TratMedActual = aTratMedActual;
    }

    /**
     * @return the Peso
     */
    public static String getPeso() {
        return Peso;
    }

    /**
     * @param aPeso the Peso to set
     */
    public static void setPeso(String aPeso) {
        Peso = aPeso;
    }

    /**
     * @return the FC
     */
    public static String getFC() {
        return FC;
    }

    /**
     * @param aFC the FC to set
     */
    public static void setFC(String aFC) {
        FC = aFC;
    }

    /**
     * @return the FR
     */
    public static String getFR() {
        return FR;
    }

    /**
     * @param aFR the FR to set
     */
    public static void setFR(String aFR) {
        FR = aFR;
    }

    /**
     * @return the PA
     */
    public static String getPA() {
        return PA;
    }

    /**
     * @param aPA the PA to set
     */
    public static void setPA(String aPA) {
        PA = aPA;
    }

    /**
     * @return the Talla
     */
    public static String getTalla() {
        return Talla;
    }

    /**
     * @param aTalla the Talla to set
     */
    public static void setTalla(String aTalla) {
        Talla = aTalla;
    }

    /**
     * @return the IMC
     */
    public static String getIMC() {
        return IMC;
    }

    /**
     * @param aIMC the IMC to set
     */
    public static void setIMC(String aIMC) {
        IMC = aIMC;
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
     * Método que permite guardar la informacion obtenida en la base de datos.
     * @param fecha
     * @param hc
     * @param mc
     * @param diagnMed
     * @param tratMedActual
     * @param peso
     * @param fc
     * @param fr
     * @param pa
     * @param talla
     * @param imc
     * @param profesional 
     * @return aux 
     */
    public static int guardar(String fecha, String hc, String mc, String diagnMed, String tratMedActual, String peso, String fc, String fr, String pa, String talla, String imc, String profesional) {
        int aux = 0;
        Connection conectar; 
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_evaluacion").executeQuery();
            while (r.next()) {
                if (fecha.equals(r.getString("Fecha")) && hc.equals(r.getString("IdHistoriaClinica"))) {
                    JOptionPane.showMessageDialog(null, "El registro de la evaluación ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                String sql = "INSERT INTO tbl_evaluacion(IdHistoriaClinica, Fecha, MotivoConsulta, DiagMed, TratMedActual, Peso, FC, FR, PA, Talla, IMC, Profesional) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, hc);
                cmd.setString(2, fecha);
                cmd.setString(3, mc);
                cmd.setString(4, diagnMed);
                cmd.setString(5, tratMedActual);
                cmd.setString(6, peso);
                cmd.setString(7, fc);
                cmd.setString(8, fr);
                cmd.setString(9, pa);
                cmd.setString(10, talla);
                cmd.setString(11, imc);
                cmd.setString(12, profesional);
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
     * Método que permite buscar una evaluación específica según una fecha o un paciente
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
                sql = "SELECT tbl_evaluacion.Fecha,tbl_evaluacion.IdHistoriaClinica,CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2),CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_evaluacion INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_evaluacion.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_evaluacion.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_evaluacion.Fecha ='" + fecha + "' and tbl_pacientes.IdPaciente =" + IdPaciente + ";";
            }else{
                if(fecha != null){
                    sql = "SELECT tbl_evaluacion.Fecha,tbl_evaluacion.IdHistoriaClinica,CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2),CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_evaluacion INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_evaluacion.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_evaluacion.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_evaluacion.Fecha ='" + fecha + "';";
                }else{
                    sql = "SELECT tbl_evaluacion.Fecha,tbl_evaluacion.IdHistoriaClinica,CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2),CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_evaluacion INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_evaluacion.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_evaluacion.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente =" + IdPaciente + ";";
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
     * Método que permite buscar la información de una evaluación en la base de datos, 
     * de acuerdo a la fecha e identificación del paciente.
     * @param fecha
     * @param hc
     */
    public static void buscar(String fecha, String hc) { 
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_evaluacion").executeQuery();
            while (rs.next()) {
                if (fecha.equals(rs.getString("Fecha")) && hc.equals(rs.getString("IdHistoriaClinica"))) {
            
                    String sql = "select * from tbl_evaluacion where Fecha = ? and IdHistoriaClinica = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, fecha);
                    cmd.setString(2, hc);
                    ResultSet r = cmd.executeQuery();

                    while (r.next()) {
                        IdHistoriaClinica = r.getString(1);
                        Fecha = r.getString(2);
                        MotivoConsulta = r.getString(3);
                        DiagMed = r.getString(4);
                        TratMedActual = r.getString(5);
                        Peso = r.getString(6);
                        FC = r.getString(7);
                        FR = r.getString(8);
                        PA = r.getString(9);
                        Talla = r.getString(10);
                        IMC = r.getString(11);
                        Profesional = r.getString(12);
                    }
                    cmd.close();
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
     * Método que obtiene todos los registros de la base de datos
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "SELECT tbl_evaluacion.Fecha,tbl_evaluacion.IdHistoriaClinica,CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2),CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2) FROM tbl_evaluacion INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_evaluacion.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_evaluacion.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
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
     * Método que obtiene los pacientes coincidentes con la búsqueda que están activos
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
            String sql = "SELECT tbl_historia_clinica.IdHistoriaClinica,CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_historia_clinica INNER JOIN tbl_pacientes ON tbl_historia_clinica.IdPaciente = tbl_pacientes.IdPaciente where tbl_pacientes.IdPaciente LIKE '%"+busqueda+"%' and tbl_historia_clinica.Estado = 'Activo' LIMIT 10;";
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
     * Método que permite obtener todos los profesionales coincidentes con la búsqueda
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
     * Método que permite obtener todos los pacientes registrados en la base de datos
     * @return result
     * @throws SQLException 
     */
    public static Map consultarPacientes() throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "SELECT tbl_historia_clinica.IdHistoriaClinica,CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2) FROM tbl_historia_clinica INNER JOIN tbl_pacientes ON tbl_historia_clinica.IdPaciente = tbl_pacientes.IdPaciente where tbl_historia_clinica.Estado = 'Activo' LIMIT 10";
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
     * Método que obtiene los pacientes coincidentes con la búsqueda
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
     * Método que permite obtener todos los profesionales registrados en la base de datos
     * @return result
     * @throws SQLException 
     */
    public static Map consultarProfesionales() throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select NumRegistro, CONCAT(Nombre, SPACE(2), Apellido1, SPACE(2), Apellido2) from tbl_profesionales;";
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
     * Método que permite obtener todas las terapias registradas a fin de utilizarlas en el estudio complementario
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerTerapias() throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdTerapia, Nombre from tbl_terapias;";
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
     * Método que permite guardar el estudio complementario de un paciente en la base de datos
     * @param hc
     * @param terapias 
     * @return aux 
     */
    public static int guardarEstCompl(String hc, ArrayList terapias) {
        int aux = 0;
        Connection conectar; 
        conectar = Conexion.getConexionMysql();
        try {
            //ResultSet r = conectar.prepareStatement("Select * from tbl_estudios_compl").executeQuery();
            //while (r.next()) {
                if (validarEstCompl(hc) == 1) {
                    JOptionPane.showMessageDialog(null, "El registro de los estudios complementarios ya existe en el sistema");
                    aux = 1;
                }
            //}
            if (aux != 1) {
                String sql = "INSERT INTO tbl_estudios_compl(IdHistoriaClinica, IdTerapia) VALUES (?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                for (int i = 0; i < terapias.size(); i++) {
                    cmd.setString(1, hc);
                    cmd.setString(2, terapias.get(i).toString());
                    cmd.execute();
                }
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente");
            }
            //JOptionPane.showMessageDialog(null, "se guardó");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
    }

    /**
     * Método que permite obtener las terapias asignadas a un paciente
     * @param hc
     * @return result
     */
    public static ArrayList obtenerTerapiasRegistros(String hc) {
        ArrayList result = new ArrayList();
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_estudios_compl").executeQuery();
            while (rs.next()) {
                if (hc.equals(rs.getString("IdHistoriaClinica"))) {
                    String sql = "SELECT IdTerapia FROM tbl_estudios_compl where IdHistoriaClinica = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, hc);
                    ResultSet r = cmd.executeQuery();

                    while (r.next()) {
                        result.add(r.getString(1));
                    }
                    cmd.close();
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
        return result;
    }
    
    /**
     * Método que permite validar si un paciente ya tiene un estudio complementario creado
     * @param hc
     * @return aux
     */
    public static int validarEstCompl(String hc) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_estudios_compl").executeQuery();
            while (rs.next()) {
                if (hc.equals(rs.getString("IdHistoriaClinica"))) {
                    return 1;
                }
            }
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return aux;
    }
}
