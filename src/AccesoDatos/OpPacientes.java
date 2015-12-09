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
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Pacientes
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpPacientes {

    private static Statement instruccion;
    
    private static String id = "", tipoId = "", nombre = "", apellido1 = "", apellido2 = "", fechaNacimiento = "", genero = "", estadoCivil = "", lugarExpedicion = "", direccion = "", barrio = "", municipio = "", departamento = "", telefono = "", celular = "", ocupacion = "", eps = "", antPNatales = "", antMedicos = "", antFamiliares = "", antQuirurgicos = "", otrosAnt = "", tipoRemision = "", remitidoPor = "", estado = "", reqAcomp = "";
    
    /**
     * @return id
     */
    public static String getid(){
        return id;
    }
    
    /**
     * @return nombre
     */
    public static String getnombre(){
        return nombre;
    }
    
    /**
     * @return tipoId
     */
    public static String gettipoId(){
        return tipoId;
    }
    
    /**
     * @return fechaNacimiento
     */
    public static String getfechaNacimiento(){
        return fechaNacimiento;
    }
    
    /**
     * @return genero
     */
    public static String getgenero(){
        return genero;
    }
    
    /**
     * @return estadoCivil
     */
    public static String getestadoCivil(){
        return estadoCivil;
    }
    
    /**
     * @return lugarExpedicion
     */
    public static String getlugarExpedicion(){
        return lugarExpedicion;
    }
    
    /**
     * @return direccion
     */
    public static String getdireccion(){
        return direccion;
    }
    
    /**
     * @return barrio
     */
    public static String getbarrio(){
        return barrio;
    }
    
    /**
     * @return municipio
     */
    public static String getmunicipio(){
        return municipio;
    }
    
    /**
     * @return telefono
     */
    public static String gettelefono(){
        return telefono;
    }
    
    /**
     * @return celular
     */
    public static String getcelular(){
        return celular;
    }
    
    /**
     * @return ocupacion
     */
    public static String getocupacion(){
        return ocupacion;
    }
    
    /**
     * @return salud
     */
    public static String getEps(){
        return eps;
    }
    
    /**
     * @param Id to id to set
     */
    public static void setid(String Id){
        id = Id;
    }
    
    /**
     * @param Nombre to nombre to set
     */
    public static void setnombre(String Nombre){
        nombre = Nombre;
    }
    
    /**
     * @param TipodId to tipoId to set
     */
    public static void settipoId(String TipodId){
        tipoId = TipodId;
    }
    
    /**
     * @param FechaNacimiento to fechaNacimiento to set
     */
    public static void setfechaNacimiento(String FechaNacimiento){
       fechaNacimiento = FechaNacimiento;
    }
    
    /**
     * @param Genero tp genero to set
     */
    public static void setgenero(String Genero){
        genero = Genero;
    }
    
    /**
     * @param EstadoCivil to estadoCivil to set
     */
    public static void setestadoCivil(String EstadoCivil){
        estadoCivil = EstadoCivil;
    }
    
    /**
     * @param LugarExpedicion to lugarExpedicion
     */
    public static void setlugarExpedicion(String LugarExpedicion){
        lugarExpedicion = LugarExpedicion;
    }
    
    /**
     * @param Direccion to direccion to set
     */
    public static void setdireccion(String Direccion){
        direccion = Direccion;
    }
    
    /**
     * @param Barrio to barrio to set
     */
    public static void setbarrio(String Barrio){
        barrio = Barrio;
    }
    
    /**
     * @param Municipio to municipio to set
     */
    public static void setmunicipio(String Municipio){
        municipio = Municipio;
    }
    
    /**
     * @param Telefono to telefono to set
     */
    public static void settelefono(String Telefono){
       telefono = Telefono;
    }
    
    /**
     * @param Celular to celular to set
     */
    public static void setcelular(String Celular){
        celular = Celular;
    }
    
    /**
     * @param Ocupacion to ocupacion to set
     */
    public static void setocupacion(String Ocupacion){
        ocupacion = Ocupacion;
    }
    
    /**
     * @param Eps
     */
    public static void setEps(String Eps){
        eps = Eps;
    }
    
    /**
     * @return the apellido1
     */
    public static String getApellido1() {
        return apellido1;
    }

    /**
     * @param aApellido1 the apellido1 to set
     */
    public static void setApellido1(String aApellido1) {
        apellido1 = aApellido1;
    }

    /**
     * @return the apellido2
     */
    public static String getApellido2() {
        return apellido2;
    }

    /**
     * @param aApellido2 the apellido2 to set
     */
    public static void setApellido2(String aApellido2) {
        apellido2 = aApellido2;
    }
    
    /**
     * @return the antPNatales
     */
    public static String getAntPNatales() {
        return antPNatales;
    }

    /**
     * @param aAntPNatales the antPNatales to set
     */
    public static void setAntPNatales(String aAntPNatales) {
        antPNatales = aAntPNatales;
    }

    /**
     * @return the antMedicos
     */
    public static String getAntMedicos() {
        return antMedicos;
    }

    /**
     * @param aAntMedicos the antMedicos to set
     */
    public static void setAntMedicos(String aAntMedicos) {
        antMedicos = aAntMedicos;
    }

    /**
     * @return the antFamiliares
     */
    public static String getAntFamiliares() {
        return antFamiliares;
    }

    /**
     * @param aAntFamiliares the antFamiliares to set
     */
    public static void setAntFamiliares(String aAntFamiliares) {
        antFamiliares = aAntFamiliares;
    }

    /**
     * @return the antQuirurgicos
     */
    public static String getAntQuirurgicos() {
        return antQuirurgicos;
    }

    /**
     * @param aAntQuirurgicos the antQuirurgicos to set
     */
    public static void setAntQuirurgicos(String aAntQuirurgicos) {
        antQuirurgicos = aAntQuirurgicos;
    }

    /**
     * @return the otrosAnt
     */
    public static String getOtrosAnt() {
        return otrosAnt;
    }

    /**
     * @param aOtrosAnt the otrosAnt to set
     */
    public static void setOtrosAnt(String aOtrosAnt) {
        otrosAnt = aOtrosAnt;
    }
    
    /**
     * @return the departamento
     */
    public static String getDepartamento() {
        return departamento;
    }

    /**
     * @param aDepartamento the departamento to set
     */
    public static void setDepartamento(String aDepartamento) {
        departamento = aDepartamento;
    }
    
    /**
     * @return the tipoRemision
     */
    public static String getTipoRemision() {
        return tipoRemision;
    }

    /**
     * @param aTipoRemision 
     */
    public static void setTipoRemision(String aTipoRemision) {
        tipoRemision = aTipoRemision;
    }

    /**
     * @return the remitidoPor
     */
    
    public static String getRemitidoPor() {
        return remitidoPor;
    }
    
    /**
     * @param remitidoPor 
     */

    public static void setRemitidoPor(String remitidoPor) {
        OpPacientes.remitidoPor = remitidoPor;
    }
    
    /**
     * @return the estado
     */
    public static String getEstado() {
        return estado;
    }

    /**
     * @param aEstado the estado to set
     */
    public static void setEstado(String aEstado) {
        estado = aEstado;
    }

    public static String getReqAcomp() {
        return reqAcomp;
    }

    public static void setReqAcomp(String reqAcomp) {
        OpPacientes.reqAcomp = reqAcomp;
    }
 
    /**
     * Método que permite guardar la información obtenida en la base de datos.
     * @param id
     * @param tipoId
     * @param nombre
     * @param apll1
     * @param apll2
     * @param fechaNacimiento
     * @param genero
     * @param estadoCivil
     * @param lugarExpedicion
     * @param departamento
     * @param direccion
     * @param barrio
     * @param municipio
     * @param telefono
     * @param celular
     * @param ocupacion
     * @param salud
     * @param antPNatales 
     * @param antMedicos 
     * @param antFamiliares 
     * @param antQuirurgicos 
     * @param otrosAnt 
     * @param tipoRemision 
     * @param remitidoPor 
     * @param familiar 
     * @param discapacidad 
     * @return aux 
     */
    public static int guardar(String id, String tipoId, String nombre, String apll1, String apll2, String fechaNacimiento, String genero, String estadoCivil, String lugarExpedicion, String departamento, String municipio, String barrio, String direccion, String telefono, String celular, String ocupacion, String salud, String antPNatales, String antMedicos, String antFamiliares, String antQuirurgicos, String otrosAnt, String tipoRemision, String remitidoPor, String familiar, String discapacidad) {
        int aux = 0;
        String sql;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_pacientes").executeQuery();
            while (r.next()) {
                if (id.equals(r.getString("IdPaciente"))) {
                    JOptionPane.showMessageDialog(null, "La identificación del paciente ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                //instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                sql = "insert into tbl_pacientes (IdPaciente,TipoId,LugarExpedicion,Nombre,Apellido1,Apellido2,FechaNacimiento,Genero,EstadoCivil,Departamento,Municipio,Barrio,Direccion,Telefono,Celular,Ocupacion,Eps,AntPNatales,AntMed,AntFamiliares,AntQuirurgicos,OtrosAnt,TipoRemision,RemitidoPor,Discapacidad,Estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, id);
                cmd.setString(2, tipoId);
                cmd.setString(3, lugarExpedicion);
                cmd.setString(4, nombre);
                cmd.setString(5, apll1);
                cmd.setString(6, apll2);
                cmd.setString(7, fechaNacimiento);
                cmd.setString(8, genero);
                cmd.setString(9, estadoCivil);
                cmd.setString(10, departamento);
                cmd.setString(11, municipio);
                cmd.setString(12, barrio);
                cmd.setString(13, direccion);
                cmd.setString(14, telefono);
                cmd.setString(15, celular);
                cmd.setString(16, ocupacion);
                cmd.setString(17, salud);
                cmd.setString(18, antPNatales);
                cmd.setString(19, antMedicos);
                cmd.setString(20, antFamiliares);
                cmd.setString(21, antQuirurgicos);
                cmd.setString(22, otrosAnt);
                cmd.setString(23, tipoRemision);
                cmd.setString(24, remitidoPor);
                cmd.setString(25, discapacidad);
                cmd.setString(26, "Activo");
                cmd.executeUpdate();

                if (discapacidad.equals("Sí")) {
                    sql = "insert into tbl_acompanamiento(IdPaciente,IdFamiliar)values(?,?);";
                    PreparedStatement cd = conectar.prepareStatement(sql);
                    cd.setString(1, id);
                    cd.setString(2, familiar);
                    cd.executeUpdate();
                }else if(discapacidad.equals("No") && !familiar.equals("Seleccione")){
                    sql = "insert into tbl_acompanamiento(IdPaciente,IdFamiliar)values(?,?);";
                    PreparedStatement cd = conectar.prepareStatement(sql);
                    cd.setString(1, id);
                    cd.setString(2, familiar);
                    cd.executeUpdate();
                }

                sql = "insert into tbl_historia_clinica(IdHistoriaClinica,IdPaciente,Estado)values(?,?,?);";
                PreparedStatement cdh = conectar.prepareStatement(sql);
                cdh.setString(1, null);
                cdh.setString(2, id);
                cdh.setString(3, "Activo");
                cdh.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
    }
    
    /**
     * Método que permite buscar la información de un paciente en la base de datos, de acuerdo a la identificación.
     * @param ide 
     */
    public static void buscar(String ide) {
        int aux = 0;
        id = ide;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_pacientes").executeQuery();
            while (rs.next()) {
                if (id.equals(rs.getString("IdPaciente"))) {
                    String sql = "select * from tbl_pacientes where IdPaciente = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, ide);
                    ResultSet r = cmd.executeQuery();

                    while (r.next()) {
                        id = r.getString(1);
                        tipoId = r.getString(2);
                        lugarExpedicion = r.getString(3);
                        nombre = r.getString(4);
                        apellido1 = r.getString(5);
                        apellido2 = r.getString(6);
                        fechaNacimiento = r.getString(7);
                        genero = r.getString(8);
                        estadoCivil = r.getString(9);
                        departamento = r.getString(10);
                        municipio = r.getString(11);
                        barrio = r.getString(12);
                        direccion = r.getString(13);
                        telefono = r.getString(14);
                        celular = r.getString(15);
                        ocupacion = r.getString(16);
                        eps = r.getString(17);
                        antPNatales = r.getString(18);
                        antMedicos = r.getString(19);
                        antFamiliares = r.getString(20);
                        antQuirurgicos = r.getString(21);
                        otrosAnt = r.getString(22);
                        tipoRemision = r.getString(23);
                        remitidoPor = r.getString(24);
                        reqAcomp = r.getString(25);
                        estado = r.getString(26);
                    }
                    //JOptionPane.showMessageDialog(null, "El registro se encontró con éxito");    
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
     * Método que permite cambiar el estado de un paciente de la base de datos, de acuerdo a la identificación.
     * @param ide 
     */
    public static void cambiarEstado(String ide) {
        int aux = 0;
        int b = 0;
        String estado = "Inactivo";
        String sql;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_pacientes").executeQuery();
            while (rs.next()) {
                if (ide.equals(rs.getString("IdPaciente"))) {
                    //instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    //String sql = "delete from  tbl_pacientes where  IdPaciente= ?";
                    if (rs.getString("Estado").equals("Activo")) {
                        estado = "Inactivo";
                    }else{
                        if (validarAcompanamiento(ide)== 1) {
                            if (validarFamiliares(ide)>0) {
                                b = 0;
                                estado = "Activo";
                            }else{
                                b = 1;
                                JOptionPane.showMessageDialog(null, "El registro no puede habilitarse, ya que el grupo familiar asociado se encuentra deshabilitado", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                    if (b == 0) {
                        sql = "update tbl_pacientes set Estado = ? where IdPaciente = ?";
                        PreparedStatement cmd = conectar.prepareStatement(sql);
                        cmd.setString(1, estado);
                        cmd.setString(2, ide);
                        cmd.executeUpdate();
                        sql = "update tbl_historia_clinica set Estado = ? where IdPaciente = ?";
                        PreparedStatement cd = conectar.prepareStatement(sql);
                        cd.setString(1, estado);
                        cd.setString(2, ide);
                        cd.executeUpdate();
                        aux = 1;
                        JOptionPane.showMessageDialog(null, "El estado del registro se actualizó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
                    }
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
     * @param id
     * @param tipoId
     * @param nombre
     * @param apll1
     * @param apll2
     * @param fechaNacimiento
     * @param genero
     * @param estadoCivil
     * @param lugarExpedicion
     * @param departamento
     * @param direccion
     * @param barrio
     * @param municipio
     * @param telefono
     * @param celular
     * @param ocupacion
     * @param salud 
     * @param antPNatales 
     * @param antMedicos 
     * @param antFamiliares 
     * @param antQuirurgicos 
     * @param otrosAnt  
     */
    public static void modificar(String id, String tipoId, String nombre, String apll1, String apll2, String fechaNacimiento, String genero, String estadoCivil, String lugarExpedicion, String departamento, String municipio, String barrio, String direccion, String telefono, String celular, String ocupacion, String salud, String antPNatales, String antMedicos, String antFamiliares, String antQuirurgicos, String otrosAnt, String familiar, String discapacidad) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_pacientes").executeQuery();
            while (rs.next()) {
                if (id.equals(rs.getString("IdPaciente"))) {
                    String discapacidadActual = rs.getString("Discapacidad");
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "update tbl_pacientes set TipoId = ?, LugarExpedicion = ?, Nombre = ?, Apellido1 = ?, Apellido2 = ?, FechaNacimiento = ?, Genero = ?, EstadoCivil = ?, Departamento = ?, Municipio = ?, Barrio = ?, Direccion = ?, Telefono = ?, Celular = ?, Ocupacion = ?, Eps = ?, AntPNatales = ?, AntMed = ?, AntFamiliares = ?, AntQuirurgicos = ?, OtrosAnt = ?, Discapacidad = ? where IdPaciente = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, tipoId);
                    cmd.setString(2, lugarExpedicion);
                    cmd.setString(3, nombre);
                    cmd.setString(4, apll1);
                    cmd.setString(5, apll2);
                    cmd.setString(6, fechaNacimiento);
                    cmd.setString(7, genero);
                    cmd.setString(8, estadoCivil);
                    cmd.setString(9, departamento);
                    cmd.setString(10, municipio);
                    cmd.setString(11, barrio);
                    cmd.setString(12, direccion);
                    cmd.setString(13, telefono);
                    cmd.setString(14, celular);
                    cmd.setString(15, ocupacion);
                    cmd.setString(16, salud);
                    cmd.setString(17, antPNatales);
                    cmd.setString(18, antMedicos);
                    cmd.setString(19, antFamiliares);
                    cmd.setString(20, antQuirurgicos);
                    cmd.setString(21, otrosAnt);
                    cmd.setString(22, discapacidad);
                    cmd.setString(23, id);
                    cmd.executeUpdate();
                    
                    if (discapacidad.equals("Sí") && discapacidadActual.equals("No")) {
                        sql = "insert into tbl_acompanamiento(IdPaciente,IdFamiliar)values(?,?);";
                        PreparedStatement cd = conectar.prepareStatement(sql);
                        cd.setString(1, id);
                        cd.setString(2, familiar);
                        cd.executeUpdate();
                    }else if(discapacidad.equals("Sí") && discapacidadActual.equals("Sí")){
                        sql = "update tbl_acompanamiento set IdFamiliar = ? where IdPaciente = ?";
                        PreparedStatement cd = conectar.prepareStatement(sql);
                        cd.setString(1, familiar);
                        cd.setString(2, id);
                        cd.executeUpdate();
                    }else if(discapacidad.equals("No") && !familiar.equals("Seleccione") && discapacidadActual.equals("Sí")){
                        sql = "update tbl_acompanamiento set IdFamiliar = ? where IdPaciente = ?";
                        PreparedStatement cd = conectar.prepareStatement(sql);
                        cd.setString(1, familiar);
                        cd.setString(2, id);
                        cd.executeUpdate();
                    }else if(discapacidad.equals("No") && !familiar.equals("Seleccione") && discapacidadActual.equals("No")){
                        int c = validarAcompanamiento(id);
                        if (c == 0) {
                            sql = "insert into tbl_acompanamiento(IdPaciente,IdFamiliar)values(?,?);";
                            PreparedStatement cd = conectar.prepareStatement(sql);
                            cd.setString(1, id);
                            cd.setString(2, familiar);
                            cd.executeUpdate();
                        }else{
                            sql = "update tbl_acompanamiento set IdFamiliar = ? where IdPaciente = ?";
                            PreparedStatement cd = conectar.prepareStatement(sql);
                            cd.setString(1, familiar);
                            cd.setString(2, id);
                            cd.executeUpdate();
                        }
                    }else{
                        sql = "delete from tbl_acompanamiento where IdPaciente = ?";
                        PreparedStatement cd = conectar.prepareStatement(sql);
                        cd.setString(1, id);
                        cd.executeUpdate();
                    }
                    
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
     * Método que permite obtener todos los registros de la base de datos
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select tbl_pacientes.IdPaciente, tbl_pacientes.Nombre, tbl_pacientes.Apellido1, tbl_pacientes.Apellido2, tbl_pacientes.Estado from tbl_pacientes";
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
     * Método que permite obtener los pacientes coincidentes con la búsqueda
     * @param busqueda
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerPacientes(String busqueda) throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdPaciente, CONCAT(Nombre, SPACE(2), Apellido1, SPACE(2), Apellido2) from tbl_pacientes WHERE IdPaciente LIKE '%" + busqueda +"%' LIMIT 10;";
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
     * Método que permite filtrar los registros por un paciente específico
     * @param IdPaciente
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String IdPaciente) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql = "";
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            sql = "select tbl_pacientes.IdPaciente, tbl_pacientes.Nombre, tbl_pacientes.Apellido1, tbl_pacientes.Apellido2, tbl_pacientes.Estado from tbl_pacientes where tbl_pacientes.IdPaciente = '"+IdPaciente+"';";
            
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
     * Método que permite obtener los familiares coincidentes con la búsqueda
     * @param busqueda
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerFamiliares(String busqueda) throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdGrupoFamiliar, NombreGrupoFamiliar from tbl_grupo_familiar INNER JOIN tbl_familiares ON tbl_familiares.GrupoFamiliar = tbl_grupo_familiar.IdGrupoFamiliar WHERE tbl_familiares.IdFamiliar LIKE '%"+busqueda+"%' LIMIT 10;";
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
     * Método que permite obtener todos los familiares registrados en la base de datos
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerFamiliares() throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdGrupoFamiliar, NombreGrupoFamiliar from tbl_grupo_familiar INNER JOIN tbl_familiares ON tbl_familiares.GrupoFamiliar = tbl_grupo_familiar.IdGrupoFamiliar";
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
     * Método que permite obtener todos los registros de eps a fin de cargarlos en el formulario
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerEps() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdEps, Nombre from tbl_eps";
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
     * Método que permite obtener todos los tipos documento a fin de cargarlos en el formulario
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
     * Método que permite obtener todos los géneros a fin de cargarlos en el formulario
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerGeneros() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdGenero, Nombre from tbl_generos";
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
     * Método que permite obtener todos los estados civiles a fin de cargarlos en el formulario
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerEstadoCivil() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdEstCivil, Nombre from tbl_estado_civil";
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
     * Método que permite obtener todos los departamentos registrados en la base de datos
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerDepartamentos() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select iddepartamento, nombre from tbl_departamento";
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
     * Método que permite obtener todos los municipios registrados en la base de datos según el departamento seleccionado
     * @param departamento
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerMunicipios(String departamento) throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select idmunicipio, nombreMunicipio from tbl_municipio where departamento_iddepartamento = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, departamento);
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
     * Método que permite obtener los familiares asignados como acompañamiento del paciente
     * @param paciente
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerFamiliar(String paciente) throws SQLException {
        Map<String, String> result = new HashMap<String, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "SELECT tbl_familiares.IdFamiliar,CONCAT(tbl_familiares.Nombre, SPACE(2), tbl_familiares.Apellido1, SPACE(2), tbl_familiares.Apellido2) FROM tbl_acompanamiento INNER JOIN tbl_familiares ON tbl_acompanamiento.IdFamiliar = tbl_familiares.IdFamiliar where tbl_acompanamiento.IdPaciente = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, paciente);
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
     * Método que permite obtener todos los registros de tipo de remisión registrados a fin de cargarlos en el formulario
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerTipoRemision() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdTipoRemision, NombreTipoRemision from tbl_tipo_remision";
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
     * Método que permite validar la cantidad de familiares activos como acompañamiento del paciente
     * @param IdPaciente
     * @return c
     */
    public static int validarFamiliares(String IdPaciente){
        int c = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            String sql = "select count(*) FROM tbl_familiares INNER JOIN tbl_grupo_familiar ON tbl_grupo_familiar.IdGrupoFamiliar = tbl_familiares.GrupoFamiliar INNER JOIN tbl_acompanamiento ON tbl_acompanamiento.IdFamiliar = tbl_grupo_familiar.IdGrupoFamiliar INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_acompanamiento.IdPaciente WHERE tbl_pacientes.IdPaciente = ? and tbl_familiares.Estado = 'Activo'";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, IdPaciente);
            ResultSet r = cmd.executeQuery();

            while (r.next()) {
                c = r.getInt(1);
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }
    
    /**
     * Método que permite obtener los grupos familiares coincidentes con la búsqueda
     * @param Id
     * @return result
     * @throws SQLException 
     */
    public static Map obtenerGrupoFamiliar(String Id) throws SQLException {
        Map<Integer, String> result = new HashMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "SELECT tbl_acompanamiento.IdFamiliar, tbl_grupo_familiar.NombreGrupoFamiliar FROM tbl_acompanamiento INNER JOIN tbl_grupo_familiar ON tbl_grupo_familiar.IdGrupoFamiliar = tbl_acompanamiento.IdFamiliar where tbl_acompanamiento.IdPaciente = '"+Id+"'";
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
     * Método que permite validar si un paciente tiene asignado un familiar como acompañamiento
     * @param IdPaciente
     * @return c
     */
    public static int validarAcompanamiento(String IdPaciente){
        int c = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            String sql = "SELECT count(*) from tbl_acompanamiento where IdPaciente = ?";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, IdPaciente);
            ResultSet r = cmd.executeQuery();

            while (r.next()) {
                c = r.getInt(1);
            }
            cmd.close();
            conectar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }
}
