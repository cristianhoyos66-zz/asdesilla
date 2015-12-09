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
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Terapias Alternativas(Equinoterapia y Educación Especial)
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpTerapiasAlternativas {
    
    private static Statement instruccion;
    
    private static String Fecha = "", IdHistoriaClinica = "", Caballo = "", Terapia = "", PostPaso = "", PostTrote = "", PostGalope = "", AsientoProf = "", AsientoLig = "", Tronco = "", Cabeza = "", Brazos = "", Codos = "", Manos = "", Pelvis = "", Piernas = "", Pies = "", AyudMontPelvis = "", AyudMontPiernas = "", AyudMontManos = "", AyudMontAsientoProf = "", 
            SalidTrote = "", SalidGalopeTr = "", SalidGalopePaso = "", AltoPaso = "", AltoTrote = "", AltoGalope = "", Circulos = "", Serpentinas = "", Apoyos = "", Equilibrio = "", Flexibilidad = "", CoordPsicomotriz = "", FuerzaMuscular = "", ManejoEsp = "", Observaciones = "", Profesional = "";

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
     * @return the Caballo
     */
    public static String getCaballo() {
        return Caballo;
    }

    /**
     * @param aCaballo the Caballo to set
     */
    public static void setCaballo(String aCaballo) {
        Caballo = aCaballo;
    }

    /**
     * @return the PostPaso
     */
    public static String getPostPaso() {
        return PostPaso;
    }

    /**
     * @param aPostPaso the PostPaso to set
     */
    public static void setPostPaso(String aPostPaso) {
        PostPaso = aPostPaso;
    }

    /**
     * @return the PostTrote
     */
    public static String getPostTrote() {
        return PostTrote;
    }

    /**
     * @param aPostTrote the PostTrote to set
     */
    public static void setPostTrote(String aPostTrote) {
        PostTrote = aPostTrote;
    }

    /**
     * @return the PostGalope
     */
    public static String getPostGalope() {
        return PostGalope;
    }

    /**
     * @param aPostGalope the PostGalope to set
     */
    public static void setPostGalope(String aPostGalope) {
        PostGalope = aPostGalope;
    }

    /**
     * @return the AsientoProf
     */
    public static String getAsientoProf() {
        return AsientoProf;
    }

    /**
     * @param aAsientoProf the AsientoProf to set
     */
    public static void setAsientoProf(String aAsientoProf) {
        AsientoProf = aAsientoProf;
    }

    /**
     * @return the AsientoLig
     */
    public static String getAsientoLig() {
        return AsientoLig;
    }

    /**
     * @param aAsientoLig the AsientoLig to set
     */
    public static void setAsientoLig(String aAsientoLig) {
        AsientoLig = aAsientoLig;
    }

    /**
     * @return the Tronco
     */
    public static String getTronco() {
        return Tronco;
    }

    /**
     * @param aTronco the Tronco to set
     */
    public static void setTronco(String aTronco) {
        Tronco = aTronco;
    }

    /**
     * @return the Cabeza
     */
    public static String getCabeza() {
        return Cabeza;
    }

    /**
     * @param aCabeza the Cabeza to set
     */
    public static void setCabeza(String aCabeza) {
        Cabeza = aCabeza;
    }

    /**
     * @return the Brazos
     */
    public static String getBrazos() {
        return Brazos;
    }

    /**
     * @param aBrazos the Brazos to set
     */
    public static void setBrazos(String aBrazos) {
        Brazos = aBrazos;
    }

    /**
     * @return the Codos
     */
    public static String getCodos() {
        return Codos;
    }

    /**
     * @param aCodos the Codos to set
     */
    public static void setCodos(String aCodos) {
        Codos = aCodos;
    }

    /**
     * @return the Manos
     */
    public static String getManos() {
        return Manos;
    }

    /**
     * @param aManos the Manos to set
     */
    public static void setManos(String aManos) {
        Manos = aManos;
    }

    /**
     * @return the Pelvis
     */
    public static String getPelvis() {
        return Pelvis;
    }

    /**
     * @param aPelvis the Pelvis to set
     */
    public static void setPelvis(String aPelvis) {
        Pelvis = aPelvis;
    }

    /**
     * @return the Pies
     */
    public static String getPies() {
        return Pies;
    }

    /**
     * @param aPies the Pies to set
     */
    public static void setPies(String aPies) {
        Pies = aPies;
    }

    /**
     * @return the AyudMontPelvis
     */
    public static String getAyudMontPelvis() {
        return AyudMontPelvis;
    }

    /**
     * @param aAyudMontPelvis the AyudMontPelvis to set
     */
    public static void setAyudMontPelvis(String aAyudMontPelvis) {
        AyudMontPelvis = aAyudMontPelvis;
    }

    /**
     * @return the AyudMontPiernas
     */
    public static String getAyudMontPiernas() {
        return AyudMontPiernas;
    }

    /**
     * @param aAyudMontPiernas the AyudMontPiernas to set
     */
    public static void setAyudMontPiernas(String aAyudMontPiernas) {
        AyudMontPiernas = aAyudMontPiernas;
    }

    /**
     * @return the AyudMontManos
     */
    public static String getAyudMontManos() {
        return AyudMontManos;
    }

    /**
     * @param aAyudMontManos the AyudMontManos to set
     */
    public static void setAyudMontManos(String aAyudMontManos) {
        AyudMontManos = aAyudMontManos;
    }

    /**
     * @return the AyudMontAsientoProf
     */
    public static String getAyudMontAsientoProf() {
        return AyudMontAsientoProf;
    }

    /**
     * @param aAsientoFlex the AyudMontAsientoProf to set
     */
    public static void setAyudMontAsientoProf(String aAsientoFlex) {
        AyudMontAsientoProf = aAsientoFlex;
    }

    /**
     * @return the SalidTrote
     */
    public static String getSalidTrote() {
        return SalidTrote;
    }

    /**
     * @param aSalidTrote the SalidTrote to set
     */
    public static void setSalidTrote(String aSalidTrote) {
        SalidTrote = aSalidTrote;
    }

    /**
     * @return the SalidGalopeTr
     */
    public static String getSalidGalopeTr() {
        return SalidGalopeTr;
    }

    /**
     * @param aSalidGalopeTr the SalidGalopeTr to set
     */
    public static void setSalidGalopeTr(String aSalidGalopeTr) {
        SalidGalopeTr = aSalidGalopeTr;
    }

    /**
     * @return the SalidGalopePaso
     */
    public static String getSalidGalopePaso() {
        return SalidGalopePaso;
    }

    /**
     * @param aSalidGalopePaso the SalidGalopePaso to set
     */
    public static void setSalidGalopePaso(String aSalidGalopePaso) {
        SalidGalopePaso = aSalidGalopePaso;
    }

    /**
     * @return the AltoTrote
     */
    public static String getAltoTrote() {
        return AltoTrote;
    }

    /**
     * @param aAltoTrote the AltoTrote to set
     */
    public static void setAltoTrote(String aAltoTrote) {
        AltoTrote = aAltoTrote;
    }

    /**
     * @return the AltoGalope
     */
    public static String getAltoGalope() {
        return AltoGalope;
    }

    /**
     * @param aAltoGalope the AltoGalope to set
     */
    public static void setAltoGalope(String aAltoGalope) {
        AltoGalope = aAltoGalope;
    }

    /**
     * @return the Circulos
     */
    public static String getCirculos() {
        return Circulos;
    }

    /**
     * @param aCirculos the Circulos to set
     */
    public static void setCirculos(String aCirculos) {
        Circulos = aCirculos;
    }

    /**
     * @return the Serpentinas
     */
    public static String getSerpentinas() {
        return Serpentinas;
    }

    /**
     * @param aSerpentinas the Serpentinas to set
     */
    public static void setSerpentinas(String aSerpentinas) {
        Serpentinas = aSerpentinas;
    }

    /**
     * @return the Apoyos
     */
    public static String getApoyos() {
        return Apoyos;
    }

    /**
     * @param aApoyos the Apoyos to set
     */
    public static void setApoyos(String aApoyos) {
        Apoyos = aApoyos;
    }

    /**
     * @return the Equilibrio
     */
    public static String getEquilibrio() {
        return Equilibrio;
    }

    /**
     * @param aEquilibrio the Equilibrio to set
     */
    public static void setEquilibrio(String aEquilibrio) {
        Equilibrio = aEquilibrio;
    }

    /**
     * @return the Flexibilidad
     */
    public static String getFlexibilidad() {
        return Flexibilidad;
    }

    /**
     * @param aFlexibilidad the Flexibilidad to set
     */
    public static void setFlexibilidad(String aFlexibilidad) {
        Flexibilidad = aFlexibilidad;
    }

    /**
     * @return the CoordPsicomotriz
     */
    public static String getCoordPsicomotriz() {
        return CoordPsicomotriz;
    }

    /**
     * @param aCoordPsicomotriz the CoordPsicomotriz to set
     */
    public static void setCoordPsicomotriz(String aCoordPsicomotriz) {
        CoordPsicomotriz = aCoordPsicomotriz;
    }

    /**
     * @return the FuerzaMuscular
     */
    public static String getFuerzaMuscular() {
        return FuerzaMuscular;
    }

    /**
     * @param aFuerzaMuscular the FuerzaMuscular to set
     */
    public static void setFuerzaMuscular(String aFuerzaMuscular) {
        FuerzaMuscular = aFuerzaMuscular;
    }

    /**
     * @return the ManejoEsp
     */
    public static String getManejoEsp() {
        return ManejoEsp;
    }

    /**
     * @param aManejoEsp the ManejoEsp to set
     */
    public static void setManejoEsp(String aManejoEsp) {
        ManejoEsp = aManejoEsp;
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
     * @return the AltoPaso
     */
    public static String getAltoPaso() {
        return AltoPaso;
    }

    /**
     * @param aAltoPaso the AltoPaso to set
     */
    public static void setAltoPaso(String aAltoPaso) {
        AltoPaso = aAltoPaso;
    }
    
    /**
     * @return the Piernas
     */
    public static String getPiernas() {
        return Piernas;
    }

    /**
     * @param aPiernas the Piernas to set
     */
    public static void setPiernas(String aPiernas) {
        Piernas = aPiernas;
    }
    
    /**
     * @return the Terapia
     */
    public static String getTerapia() {
        return Terapia;
    }

    /**
     * @param aTerapia the Terapia to set
     */
    public static void setTerapia(String aTerapia) {
        Terapia = aTerapia;
    }
    
    /**
     * Método que permite obtener los pacientes que coincidan con la búsqueda y que tengan asignada una evaluación en dicha fecha
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
     * Método que permite guardar la información obtenida en la base de datos.
     * @param fecha
     * @param hc
     * @param terapia
     * @param idCaballo
     * @param postPaso
     * @param postTrote
     * @param postGalope
     * @param asientoProf
     * @param asientoLig
     * @param tronco
     * @param cabeza
     * @param brazos
     * @param codos
     * @param manos
     * @param pelvis
     * @param piernas
     * @param pies
     * @param ayudMontPelvis
     * @param ayudMontPiernas
     * @param ayudMontManos
     * @param asientoFlex
     * @param salidTrote
     * @param salidGalopeTr
     * @param salidGalopePaso
     * @param altoPaso
     * @param altoTrote
     * @param altoGalope
     * @param circulos
     * @param serpentinas
     * @param apoyos
     * @param equilibrio
     * @param flexibilidad
     * @param coordPsicomotriz
     * @param fuerzaMuscular
     * @param manejoEsp
     * @param observaciones
     * @param profesional 
     * @return aux 
     */
    public static int guardar(String fecha, String hc, String terapia, String idCaballo, String postPaso, String postTrote, String postGalope, String asientoProf, String asientoLig, String tronco, String cabeza, String brazos, String codos, String manos, String pelvis, String piernas, String pies, String ayudMontPelvis, String ayudMontPiernas, String ayudMontManos, String asientoFlex, 
            String salidTrote, String salidGalopeTr, String salidGalopePaso, String altoPaso, String altoTrote, String altoGalope, String circulos, String serpentinas, String apoyos, String equilibrio, String flexibilidad, String coordPsicomotriz, String fuerzaMuscular, String manejoEsp, String observaciones, String profesional) {
        int aux = 0;
        Connection conectar; 
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_terapias_alternativas").executeQuery();
            while (r.next()) {
                if (fecha.equals(r.getString("Fecha")) && hc.equals(r.getString("IdHistoriaClinica")) && terapia.equals(r.getString("Terapia"))) {
                    JOptionPane.showMessageDialog(null, "El registro de la terapia alternativa ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                //instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "insert into tbl_terapias_alternativas(IdHistoriaClinica, Fecha, Caballo, Terapia, PostPaso, PostTrote, PostGalope, AsientoProf, AsientoLig, Tronco, Cabeza, Brazos, Codos, Manos, Pelvis, Piernas, Pies, AyudMontPelvis, AyudMontPiernas, AyudMontManos, AsientoFlex, SalidTrote, SalidGalopeTr, SalidGalopePaso, AltoPaso, AltoTrote, AltoGalope, Circulos, Serpentinas, Apoyos, Equilibrio, Flexibilidad, CoordPsicomotriz, FuerzaMuscular, ManejoEsp, Observaciones, Profesional) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, hc);
                cmd.setString(2, fecha);
                cmd.setString(3, idCaballo);
                cmd.setString(4, terapia);
                cmd.setString(5, postPaso);
                cmd.setString(6, postTrote);
                cmd.setString(7, postGalope);
                cmd.setString(8, asientoProf);
                cmd.setString(9, asientoLig);
                cmd.setString(10, tronco);
                cmd.setString(11, cabeza);
                cmd.setString(12, brazos);
                cmd.setString(13, codos);
                cmd.setString(14, manos);
                cmd.setString(15, pelvis);
                cmd.setString(16, piernas);
                cmd.setString(17, pies);
                cmd.setString(18, ayudMontPelvis);
                cmd.setString(19, ayudMontPiernas);
                cmd.setString(20, ayudMontManos);
                cmd.setString(21, asientoFlex);
                cmd.setString(22, salidTrote);
                cmd.setString(23, salidGalopeTr);
                cmd.setString(24, salidGalopePaso);
                cmd.setString(25, altoPaso);
                cmd.setString(26, altoTrote);
                cmd.setString(27, altoGalope);
                cmd.setString(28, circulos);
                cmd.setString(29, serpentinas);
                cmd.setString(30, apoyos);
                cmd.setString(31, equilibrio);
                cmd.setString(32, flexibilidad);
                cmd.setString(33, coordPsicomotriz);
                cmd.setString(34, fuerzaMuscular);
                cmd.setString(35, manejoEsp);
                cmd.setString(36, observaciones);
                cmd.setString(37, profesional);
                cmd.execute();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }
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
            String sql = "SELECT tbl_terapias_alternativas.Fecha, tbl_terapias_alternativas.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2), tbl_terapias.Nombre FROM tbl_terapias_alternativas INNER JOIN tbl_terapias ON tbl_terapias.IdTerapia = tbl_terapias_alternativas.Terapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_terapias_alternativas.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_terapias_alternativas.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente";
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
     * Método que permite filtrar los registros por una fecha, un paciente o una terapia alternativa específica
     * @param fecha
     * @param IdPaciente
     * @param IdTerapia
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String fecha, String IdPaciente, String IdTerapia) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql = "";
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            if (fecha != null && IdPaciente != null && IdTerapia != null) {
                sql = "SELECT tbl_terapias_alternativas.Fecha, tbl_terapias_alternativas.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2), tbl_terapias.Nombre FROM tbl_terapias_alternativas INNER JOIN tbl_terapias ON tbl_terapias.IdTerapia = tbl_terapias_alternativas.Terapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_terapias_alternativas.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_terapias_alternativas.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_terapias_alternativas.Fecha = '"+fecha+"' and tbl_pacientes.IdPaciente = '"+IdPaciente+"' and tbl_terapias_alternativas.Terapia = "+IdTerapia+";";
            }else{
                if (fecha != null && IdPaciente != null) {
                    sql = "SELECT tbl_terapias_alternativas.Fecha, tbl_terapias_alternativas.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2), tbl_terapias.Nombre FROM tbl_terapias_alternativas INNER JOIN tbl_terapias ON tbl_terapias.IdTerapia = tbl_terapias_alternativas.Terapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_terapias_alternativas.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_terapias_alternativas.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_terapias_alternativas.Fecha = '"+fecha+"' and tbl_pacientes.IdPaciente = '"+IdPaciente+"';";
                }else if (IdPaciente != null && IdTerapia != null) {
                    sql = "SELECT tbl_terapias_alternativas.Fecha, tbl_terapias_alternativas.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2), tbl_terapias.Nombre FROM tbl_terapias_alternativas INNER JOIN tbl_terapias ON tbl_terapias.IdTerapia = tbl_terapias_alternativas.Terapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_terapias_alternativas.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_terapias_alternativas.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente = '"+IdPaciente+"' and tbl_terapias_alternativas.Terapia = "+IdTerapia+";";
                }else if (fecha != null && IdTerapia != null) {
                    sql = "SELECT tbl_terapias_alternativas.Fecha, tbl_terapias_alternativas.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2), tbl_terapias.Nombre FROM tbl_terapias_alternativas INNER JOIN tbl_terapias ON tbl_terapias.IdTerapia = tbl_terapias_alternativas.Terapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_terapias_alternativas.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_terapias_alternativas.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_terapias_alternativas.Fecha = '"+fecha+"' and tbl_terapias_alternativas.Terapia = "+IdTerapia+";"; 
                }else if(fecha != null){
                    sql = "SELECT tbl_terapias_alternativas.Fecha, tbl_terapias_alternativas.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2), tbl_terapias.Nombre FROM tbl_terapias_alternativas INNER JOIN tbl_terapias ON tbl_terapias.IdTerapia = tbl_terapias_alternativas.Terapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_terapias_alternativas.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_terapias_alternativas.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_terapias_alternativas.Fecha = '"+fecha+"';";
                }else if(IdPaciente != null){
                    sql = "SELECT tbl_terapias_alternativas.Fecha, tbl_terapias_alternativas.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2), tbl_terapias.Nombre FROM tbl_terapias_alternativas INNER JOIN tbl_terapias ON tbl_terapias.IdTerapia = tbl_terapias_alternativas.Terapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_terapias_alternativas.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_terapias_alternativas.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_pacientes.IdPaciente = '"+IdPaciente+"';";
                }else if(IdTerapia != null){
                    sql = "SELECT tbl_terapias_alternativas.Fecha, tbl_terapias_alternativas.IdHistoriaClinica, CONCAT(tbl_pacientes.Nombre, SPACE(2), tbl_pacientes.Apellido1, SPACE(2), tbl_pacientes.Apellido2), CONCAT(tbl_profesionales.Nombre, SPACE(2), tbl_profesionales.Apellido1, SPACE(2), tbl_profesionales.Apellido2), tbl_terapias.Nombre FROM tbl_terapias_alternativas INNER JOIN tbl_terapias ON tbl_terapias.IdTerapia = tbl_terapias_alternativas.Terapia INNER JOIN tbl_profesionales ON tbl_profesionales.NumRegistro = tbl_terapias_alternativas.Profesional INNER JOIN tbl_historia_clinica ON tbl_historia_clinica.IdHistoriaClinica = tbl_terapias_alternativas.IdHistoriaClinica INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_historia_clinica.IdPaciente where tbl_terapias_alternativas.Terapia = "+IdTerapia+";";
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
    
    /**
     * Método que permite buscar la información de una terapia alternativa en la base de datos, 
     * de acuerdo a la fecha, historia clínica y terapia.
     * @param fecha 
     * @param hc 
     * @param terapia 
     */
    public static void buscar(String fecha, String hc, String terapia) { 
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select * from tbl_terapias_alternativas where Fecha = ? and IdHistoriaClinica = ? and Terapia = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, fecha);
            cmd.setString(2, hc);
            cmd.setString(3, terapia);
            ResultSet r = cmd.executeQuery();
        
            while (r.next()) {
                IdHistoriaClinica = r.getString(1);
                Fecha = r.getString(2);
                Caballo = r.getString(3);
                Terapia = r.getString(4);
                PostPaso = r.getString(5);
                PostTrote = r.getString(6);
                PostGalope = r.getString(7);
                AsientoProf = r.getString(8);
                AsientoLig = r.getString(9);
                Tronco = r.getString(10);
                Cabeza = r.getString(11);
                Brazos = r.getString(12);
                Codos = r.getString(13);
                Manos = r.getString(14);
                Pelvis = r.getString(15);
                Piernas = r.getString(16);
                Pies = r.getString(17);
                AyudMontPelvis = r.getString(18);
                AyudMontPiernas = r.getString(19);
                AyudMontManos = r.getString(20);
                AyudMontAsientoProf = r.getString(21); 
                SalidTrote = r.getString(22);
                SalidGalopeTr = r.getString(23);
                SalidGalopePaso = r.getString(24);
                AltoPaso = r.getString(25);
                AltoTrote = r.getString(26);
                AltoGalope = r.getString(27);
                Circulos = r.getString(28);
                Serpentinas = r.getString(29);
                Apoyos = r.getString(30);
                Equilibrio = r.getString(31);
                Flexibilidad = r.getString(32);
                CoordPsicomotriz = r.getString(33);
                FuerzaMuscular = r.getString(34);
                ManejoEsp = r.getString(35);
                Observaciones = r.getString(36);
                Profesional = r.getString(37);
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    /**
     * Método que permite obtener todos los caballos coincidentes con la búsqueda que se encuentren activos
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
            String sql = "select Nrege, Nombre from tbl_caballos WHERE Nrege LIKE '%" + busqueda +"%' and Anem = 'No' and Estado = 'Activo' LIMIT 10;";
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
     * Método que permite obtener todos los caballos registrados
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerCaballos() throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select Nrege, Nombre from tbl_caballos";
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
     * Método que permite validar que dicho paciente si tenga asignada la terapia
     * @param hc
     * @param terapia
     * @return result
     */
    public static boolean validarTerapias(String hc, String terapia) {
        boolean result = false;
        int aux = 0;
        String sql = "";
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            if (terapia.equals("4")) {
                sql = "SELECT * FROM tbl_estudios_compl WHERE IdHistoriaClinica = ? and IdTerapia = 4";
            }else if(terapia.equals("5")){
                sql = "SELECT * FROM tbl_estudios_compl WHERE IdHistoriaClinica = ? and IdTerapia = 5";
            }
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
     * Método que permite obtener todas las terapias cuyo tipo es alternativa
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerTerapias() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdTerapia, Nombre from tbl_terapias where Tipo = 2";
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
