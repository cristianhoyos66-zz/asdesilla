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
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Profesionales
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpProfesionales {

    private static Statement instruccion;

    private static String numRegistro = "", id = "", tipoId = "", nombre = "", apellido1 = "", apellido2 = "", fechaNacimiento = "", genero = "", direccion = "", barrio = "", departamento = "", municipio = "", telefono = "", celular = "", ocupacion = "", horarioLaboral = "", Estado = "";

    /**
     * @return the id
     */
    public static String getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(String aId) {
        id = aId;
    }

    /**
     * @return the tipoId
     */
    public static String getTipoId() {
        return tipoId;
    }

    /**
     * @param aTipoId the tipoId to set
     */
    public static void setTipoId(String aTipoId) {
        tipoId = aTipoId;
    }

    /**
     * @return the nombre
     */
    public static String getNombre() {
        return nombre;
    }

    /**
     * @param aNombre the nombre to set
     */
    public static void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * @return the fechaNacimiento
     */
    public static String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param aFechaNacimiento the fechaNacimiento to set
     */
    public static void setFechaNacimiento(String aFechaNacimiento) {
        fechaNacimiento = aFechaNacimiento;
    }

    /**
     * @return the genero
     */
    public static String getGenero() {
        return genero;
    }

    /**
     * @param aGenero the genero to set
     */
    public static void setGenero(String aGenero) {
        genero = aGenero;
    }

    /**
     * @return the direccion
     */
    public static String getDireccion() {
        return direccion;
    }

    /**
     * @param aDireccion the direccion to set
     */
    public static void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

    /**
     * @return the barrio
     */
    public static String getBarrio() {
        return barrio;
    }

    /**
     * @param aBarrio the barrio to set
     */
    public static void setBarrio(String aBarrio) {
        barrio = aBarrio;
    }

    /**
     * @return the municipio
     */
    public static String getMunicipio() {
        return municipio;
    }

    /**
     * @param aMunicipio the municipio to set
     */
    public static void setMunicipio(String aMunicipio) {
        municipio = aMunicipio;
    }

    /**
     * @return the telefono
     */
    public static String getTelefono() {
        return telefono;
    }

    /**
     * @param aTelefono the telefono to set
     */
    public static void setTelefono(String aTelefono) {
        telefono = aTelefono;
    }

    /**
     * @return the celular
     */
    public static String getCelular() {
        return celular;
    }

    /**
     * @param aCelular the celular to set
     */
    public static void setCelular(String aCelular) {
        celular = aCelular;
    }

    /**
     * @return the ocupacion
     */
    public static String getOcupacion() {
        return ocupacion;
    }

    /**
     * @param aOcupacion the ocupacion to set
     */
    public static void setOcupacion(String aOcupacion) {
        ocupacion = aOcupacion;
    }

    /**
     * @return the horarioLaboral
     */
    public static String getHorarioLaboral() {
        return horarioLaboral;
    }

    /**
     * @param aHorarioLaboral the horarioLaboral to set
     */
    public static void setHorarioLaboral(String aHorarioLaboral) {
        horarioLaboral = aHorarioLaboral;
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
     * @return the numRegistro
     */
    public static String getNumRegistro() {
        return numRegistro;
    }

    /**
     * @param aNumRegistro the numRegistro to set
     */
    public static void setNumRegistro(String aNumRegistro) {
        numRegistro = aNumRegistro;
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
     * @param numRegistro
     * @param id
     * @param tipoId
     * @param nombre
     * @param apll1
     * @param apll2
     * @param fechaNacimiento
     * @param genero
     * @param direccion
     * @param barrio
     * @param departamento
     * @param municipio
     * @param telefono
     * @param celular
     * @param ocupacion
     * @param horarioLaboral 
     * @return aux 
     */
    public static int guardar(String numRegistro, String id, String tipoId, String nombre, String apll1, String apll2, String fechaNacimiento, String genero, String departamento, String municipio, String barrio, String direccion, String telefono, String celular, String ocupacion, String horarioLaboral) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_profesionales").executeQuery();
            while (r.next()) {
                if (numRegistro.equals(r.getString("NumRegistro"))) {
                    JOptionPane.showMessageDialog(null, "El número de registro ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }else if(id.equals(r.getString("IdProfesional"))){
                    JOptionPane.showMessageDialog(null, "La identificación del profesional ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                //instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "insert into tbl_profesionales (NumRegistro,IdProfesional,TipoId,Nombre,Apellido1,Apellido2,FechaNacimiento,Genero,Departamento,Municipio,Barrio,Direccion,Telefono,Celular,Ocupacion,HorarioLaboral,Estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, numRegistro);
                cmd.setString(2, id);
                cmd.setString(3, tipoId);
                cmd.setString(4, nombre);
                cmd.setString(5, apll1);
                cmd.setString(6, apll2);
                cmd.setString(7, fechaNacimiento);
                cmd.setString(8, genero);
                cmd.setString(9, departamento);
                cmd.setString(10, municipio);
                cmd.setString(11, barrio);
                cmd.setString(12, direccion);
                cmd.setString(13, telefono);
                cmd.setString(14, celular);
                cmd.setString(15, ocupacion);
                cmd.setString(16, horarioLaboral);
                cmd.setString(17, "Activo");
                cmd.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
    }

    /**
     * Método que permite buscar la información de un profesional en la base de
     * datos, de acuerdo a la identificación.
     * @param ide
     */
    public static void buscar(String ide) {
        id = ide;
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_profesionales").executeQuery();
            while (rs.next()) {
                if (ide.equals(rs.getString("NumRegistro"))) {
                    String sql = "select * from tbl_profesionales where NumRegistro = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, ide);
                    ResultSet r = cmd.executeQuery();
                    while (r.next()) {
                        numRegistro = r.getString(1);
                        id = r.getString(2);
                        tipoId = r.getString(3);
                        nombre = r.getString(4);
                        apellido1 = r.getString(5);
                        apellido2 = r.getString(6);
                        fechaNacimiento = r.getString(7);
                        genero = r.getString(8);
                        departamento = r.getString(9);
                        municipio = r.getString(10);
                        barrio = r.getString(11);
                        direccion = r.getString(12);
                        telefono = r.getString(13);
                        celular = r.getString(14);
                        ocupacion = r.getString(15);
                        horarioLaboral = r.getString(16);
                        Estado = r.getString(17);
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
     * Método que permite cambiar el estado de un profesional de la base de datos, de acuerdo a
     * la identificación.
     * @param ide
     */
    public static void cambiarEstado(String ide) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_profesionales").executeQuery();
            while (rs.next()) {
                if (ide.equals(rs.getString("NumRegistro"))) {
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "update tbl_profesionales set Estado = ? where NumRegistro = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    if (rs.getString("Estado").equals("Activo")) {
                        cmd.setString(1, "Inactivo");
                    }else{
                        cmd.setString(1, "Activo");
                    }
                    cmd.setString(2, ide);
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
     * Método que permite actualizar un registro en la base de datos, con
     * respecto a la información suministrada.
     * @param numRegistro
     * @param id
     * @param tipoId
     * @param nombre
     * @param apll1
     * @param apll2
     * @param fechaNacimiento
     * @param genero
     * @param departamento
     * @param direccion
     * @param barrio
     * @param municipio
     * @param telefono
     * @param celular
     * @param ocupacion
     * @param horarioLaboral 
     */
    public static void modificar(String numRegistro, String id, String tipoId, String nombre, String apll1, String apll2, String fechaNacimiento, String genero, String departamento, String municipio, String barrio, String direccion, String telefono, String celular, String ocupacion, String horarioLaboral) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_profesionales").executeQuery();
            while (rs.next()) {
                if (id.equals(rs.getString("IdProfesional"))) {
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "update tbl_profesionales set IdProfesional = ?, TipoId = ?, Nombre = ?, Apellido1 = ?, Apellido2 = ?, FechaNacimiento = ?, Genero = ?, Departamento = ?, Municipio = ?, Barrio = ?, Direccion = ?, Telefono = ?, Celular = ?, Ocupacion = ?, HorarioLaboral = ? where NumRegistro = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, id);
                    cmd.setString(2, tipoId);
                    cmd.setString(3, nombre);
                    cmd.setString(4, apll1);
                    cmd.setString(5, apll2);
                    cmd.setString(6, fechaNacimiento);
                    cmd.setString(7, genero);
                    cmd.setString(8, departamento);
                    cmd.setString(9, municipio);
                    cmd.setString(10, barrio);
                    cmd.setString(11, direccion);
                    cmd.setString(12, telefono);
                    cmd.setString(13, celular);
                    cmd.setString(14, ocupacion);
                    cmd.setString(15, horarioLaboral);
                    cmd.setString(16, numRegistro);
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
     * Método que permite obtener todos los registros de la base de datos
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select NumRegistro, IdProfesional, Nombre, Apellido1, Apellido2, Estado from tbl_profesionales order by NumRegistro";
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
            String sql = "select IdProfesional, CONCAT(Nombre, SPACE(2), Apellido1, SPACE(2), Apellido2) from tbl_profesionales WHERE IdProfesional LIKE '%" + busqueda +"%' LIMIT 10;";
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
     * Método que permite filtrar los registros por un profesional específico
     * @param IdProfesional
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String IdProfesional) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql;
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            
            sql = "select NumRegistro, IdProfesional, Nombre, Apellido1, Apellido2, Estado from tbl_profesionales where IdProfesional =" + IdProfesional + " order by NumRegistro;";
            
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
    
    /**
     * Método que permite obtener todos los tipos documento registrados en la base de datos
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
     * Método que permite obtener todos los géneros registrados en la base de datos
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
     * Método que permite obtener todos los municipios registrados en la base de datos 
     * y coincidentes con el departamento seleccionado
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
     * Método que permite obtener todos los cargos registrados en la base de datos
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerCargos() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdCargo, NombreCargo from tbl_cargo where TipoCargo = 2";
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
     * Método que permite obtener todos los horarios laborales registrados en la base de datos
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerHorarioLaboral() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdHorarioLaboralPM, NombreHorarioLaboralPM from tbl_horario_laboral_profesional";
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
