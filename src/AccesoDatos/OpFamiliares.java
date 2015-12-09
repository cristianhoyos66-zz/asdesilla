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
 * Esta clase permite realizar las distintas operaciones correspondientes al formulario Familiares y Grupo Familiar
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class OpFamiliares {

    private static Statement instruccion;

    private static String Id = "", Parentesco = "", Nombre = "", Apellido1 = "", Apellido2 = "", fechaNacimiento = "", Eps = "", Telefono = "", Celular = "", Departamento = "", Municipio = "", Barrio = "", Direccion = "", GrupoFamiliar = "", Estado = "";

    /**
     * @return Id
     */
    public static String getIdFamiliar() {
        return Id;
    }

    /**
     * @return Parentesco
     */
    public static String getParentesco() {
        return Parentesco;
    }

    /**
     * @return Celular
     */
    public static String getCelular() {
        return Celular;
    }

    /**
     * @return Municipio
     */
    public static String getMunicipio() {
        return Municipio;
    }

    /**
     * @return Eps
     */
    public static String getEps() {
        return Eps;
    }

    /**
     * @return Nombre
     */
    public static String getNombre() {
        return Nombre;
    }

    /**
     * @return Telefono
     */
    public static String getTelefono() {
        return Telefono;
    }

    /**
     * @return Direccion
     */
    public static String getDireccion() {
        return Direccion;
    }

    /**
     * @return Barrio
     */
    public static String getBarrio() {
        return Barrio;
    }

    /**
     * @param IdFamiliar the Id to set
     */
    public static void setIdFamiliar(String IdFamiliar) {
        Id = IdFamiliar;
    }

    /**
     * @param parentesco to Parentesco to set
     */
    public static void setParentesco(String parentesco) {
        Parentesco = parentesco;
    }

    /**
     * @param celular to Celular to set
     */
    public static void setCelular(String celular) {
        Celular = celular;
    }

    /**
     * @param municipio to Municipio to set
     */
    public static void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    /**
     * @param eps to Eps to set
     */
    public static void setEps(String eps) {
        Eps = eps;
    }

    /**
     * @param nombre to Nombre to set
     */
    public static void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * @param telefono to Telefono to set
     */
    public static void setTelefono(String telefono) {
        Telefono = telefono;
    }

    /**
     * @param direccion to Direccion to set
     */
    public static void setDireccion(String direccion) {
        Direccion = direccion;
    }

    /**
     * @param barrio to Barrio to set
     */
    public static void setBarrio(String barrio) {
        Barrio = barrio;
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
     * @return the Apellido1
     */
    public static String getApellido1() {
        return Apellido1;
    }

    /**
     * @param aApellido1 the Apellido1 to set
     */
    public static void setApellido1(String aApellido1) {
        Apellido1 = aApellido1;
    }

    /**
     * @return the Apellido2
     */
    public static String getApellido2() {
        return Apellido2;
    }

    /**
     * @param aApellido2 the Apellido2 to set
     */
    public static void setApellido2(String aApellido2) {
        Apellido2 = aApellido2;
    }
    
    /**
     * @return the Departamento
     */
    public static String getDepartamento() {
        return Departamento;
    }

    /**
     * @param aDepartamento the Departamento to set
     */
    public static void setDepartamento(String aDepartamento) {
        Departamento = aDepartamento;
    }

    /**
     * @return GrupoFamiliar
     */
    public static String getGrupoFamiliar() {
        return GrupoFamiliar;
    }

    /**
     * @param aGrupoFamiliar the GrupoFamiliar set
     */
    public static void setGrupoFamiliar(String aGrupoFamiliar) {
        GrupoFamiliar = aGrupoFamiliar;
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
     * @param IdFamiliar
     * @param Nombre
     * @param Apll1
     * @param Apll2
     * @param fechaNacimiento
     * @param Eps
     * @param Parentesco
     * @param Telefono
     * @param Celular
     * @param Departamento 
     * @param Municipio
     * @param Barrio
     * @param Direccion 
     * @param GrupoFamiliar 
     * @return aux 
     */
    public static int guardar(String IdFamiliar, String Nombre, String Apll1, String Apll2, String fechaNacimiento, String Eps, String Parentesco, String Telefono, String Celular, String Departamento, String Municipio, String Barrio, String Direccion, String GrupoFamiliar) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet r = conectar.prepareStatement("Select * from tbl_familiares").executeQuery();
            while (r.next()) {
                if (IdFamiliar.equals(r.getString("IdFamiliar"))) {
                    JOptionPane.showMessageDialog(null, "El registro ya existe en el sistema", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
                    aux = 1;
                }
            }
            if (aux != 1) {
                String sql = "insert into tbl_familiares (IdFamiliar, Parentesco, Nombre, Apellido1, Apellido2, FechaNacimiento, Eps, Telefono, Celular, Departamento, Municipio, Barrio, Direccion, GrupoFamiliar, Estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement cmd = conectar.prepareStatement(sql);
                cmd.setString(1, IdFamiliar);
                cmd.setString(2, Parentesco);
                cmd.setString(3, Nombre);
                cmd.setString(4, Apll1);
                cmd.setString(5, Apll2);
                cmd.setString(6, fechaNacimiento);
                cmd.setString(7, Eps);
                cmd.setString(8, Telefono);
                cmd.setString(9, Celular);
                cmd.setString(10, Departamento);
                cmd.setString(11, Municipio);
                cmd.setString(12, Barrio);
                cmd.setString(13, Direccion);
                cmd.setString(14, GrupoFamiliar);
                cmd.setString(15, "Activo");
                cmd.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aux;
    }

    /**
     * Método que permite buscar la información de un familiar en la base de
     * datos, de acuerdo a la identificación.
     * @param idFamiliar
     */
    public static void buscar(String idFamiliar) {
        int aux = 0;
        Id = idFamiliar;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_familiares").executeQuery();
            while (rs.next()) {
                if (Id.equals(rs.getString("IdFamiliar"))) {
                    String sql = "select * from tbl_familiares where IdFamiliar = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);
                    cmd.setString(1, idFamiliar);
                    ResultSet r = cmd.executeQuery();

                    while (r.next()) {
                        Id = r.getString(1);
                        Parentesco = r.getString(2);
                        Nombre = r.getString(3);
                        Apellido1 = r.getString(4);
                        Apellido2 = r.getString(5);
                        fechaNacimiento = r.getString(6);
                        Eps = r.getString(7);
                        Telefono = r.getString(8);
                        Celular = r.getString(9);
                        Departamento = r.getString(10);
                        Municipio = r.getString(11);
                        Barrio = r.getString(12);
                        Direccion = r.getString(13);
                        GrupoFamiliar = r.getString(14);
                        Estado = r.getString(15);
                    }

                    cmd.close();
                 
                    //JOptionPane.showMessageDialog(null, "El registro se encontró con éxito");
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
     * Método que permite cambiar el estado de un familiar de la base de datos, de acuerdo a
     * la identificación.
     * @param IdFamiliar
     */
    public static void cambiarEstado(String IdFamiliar) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_familiares").executeQuery();
            while (rs.next()) {
                if (IdFamiliar.equals(rs.getString("IdFamiliar"))) {
                    if(validarPacientes(IdFamiliar) == 0){
                        instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String sql = "update tbl_familiares set Estado = ? where IdFamiliar = ?";
                        PreparedStatement cmd = conectar.prepareStatement(sql);
                        if (rs.getString("Estado").equals("Activo")) {
                            cmd.setString(1, "Inactivo");
                        }else{
                            cmd.setString(1, "Activo");
                        }
                        cmd.setString(2, IdFamiliar);
                        cmd.executeUpdate();
                        aux = 1;
                        JOptionPane.showMessageDialog(null, "El estado del registro se actualizó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "El registro no puede deshabilitarse ya que se encuentran pacientes activos asociados", "Gestión Asdesilla", JOptionPane.WARNING_MESSAGE);
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
     * Método que permite validar la cantidad de pacientes activos que tiene el familiar
     * @param IdFamiliar
     * @return c
     */
    public static int validarPacientes(String IdFamiliar){
        int c = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            String sql = "select count(*) FROM tbl_acompanamiento INNER JOIN tbl_pacientes ON tbl_pacientes.IdPaciente = tbl_acompanamiento.IdPaciente INNER JOIN tbl_familiares ON tbl_familiares.GrupoFamiliar = tbl_acompanamiento.IdFamiliar WHERE tbl_familiares.IdFamiliar = ? and tbl_pacientes.Estado = 'Activo'";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, IdFamiliar);
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
     * Método que permite actualizar un registro en la base de datos, con
     * respecto a la información suministrada.
     * @param IdFamiliar
     * @param Nombre
     * @param Apll1
     * @param Apll2
     * @param fechaNacimiento
     * @param Eps
     * @param Parentesco
     * @param Telefono
     * @param Celular
     * @param Departamento
     * @param Municipio
     * @param Barrio
     * @param Direccion
     */
    public static void modificar(String IdFamiliar, String Nombre, String Apll1, String Apll2, String fechaNacimiento, String Eps, String Parentesco, String Telefono, String Celular, String Departamento, String Municipio, String Barrio, String Direccion) {
        int aux = 0;
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            ResultSet rs = conectar.prepareStatement("Select * from tbl_familiares").executeQuery();
            while (rs.next()) {
                if (IdFamiliar.equals(rs.getString("IdFamiliar"))) {
                    instruccion = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    String sql = "update tbl_familiares set Parentesco = ?, Nombre = ?, Apellido1 = ?, Apellido2 = ?, FechaNacimiento = ?, Eps = ?, Telefono = ?, Celular = ?, Departamento = ?, Municipio = ?, Barrio = ?, Direccion = ? where IdFamiliar = ?";
                    PreparedStatement cmd = conectar.prepareStatement(sql);

                    cmd.setString(1, Parentesco);
                    cmd.setString(2, Nombre);
                    cmd.setString(3, Apll1);
                    cmd.setString(4, Apll2);
                    cmd.setString(5, fechaNacimiento);
                    cmd.setString(6, Eps);
                    cmd.setString(7, Telefono);
                    cmd.setString(8, Celular);
                    cmd.setString(9, Departamento);
                    cmd.setString(10, Municipio);
                    cmd.setString(11, Barrio);
                    cmd.setString(12, Direccion);
                    cmd.setString(13, IdFamiliar);

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
     * Método que permite obtener todos los familiares coincidentes con la búsqueda
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
            String sql = "select IdFamiliar, CONCAT(Nombre, SPACE(2), Apellido1, SPACE(2), Apellido2) from tbl_familiares WHERE IdFamiliar LIKE '%" + busqueda +"%' LIMIT 10;";
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
     * Método que permite obtener todos los registros de la base de datos
     * @return data
     */
    public static ArrayList<Object[]> obtenerRegistros() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select tbl_familiares.IdFamiliar, tbl_familiares.Nombre, tbl_familiares.Apellido1, tbl_familiares.Apellido2, tbl_grupo_familiar.NombreGrupoFamiliar, tbl_familiares.Estado from tbl_familiares INNER JOIN tbl_grupo_familiar ON tbl_grupo_familiar.IdGrupoFamiliar = tbl_familiares.GrupoFamiliar";
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
     * Método que permite filtrar los registros según un familiar o un grupo familiar específico
     * @param IdFamiliar
     * @param GrupoFamiliar
     * @return data
     */
    public static ArrayList<Object[]> buscarRegistros(String IdFamiliar, String GrupoFamiliar) {
        ArrayList<Object[]> data = new ArrayList<>();
        String sql = "";
        int o = 0;
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            if (IdFamiliar != null && GrupoFamiliar != null) {
                sql = "select tbl_familiares.IdFamiliar, tbl_familiares.Nombre, tbl_familiares.Apellido1, tbl_familiares.Apellido2, tbl_grupo_familiar.NombreGrupoFamiliar, tbl_familiares.Estado from tbl_familiares INNER JOIN tbl_grupo_familiar ON tbl_grupo_familiar.IdGrupoFamiliar = tbl_familiares.GrupoFamiliar where tbl_familiares.IdFamiliar ='"+IdFamiliar+"' and tbl_familiares.GrupoFamiliar = "+GrupoFamiliar+";";
            }else{ 
                if(IdFamiliar != null){
                    sql = "select tbl_familiares.IdFamiliar, tbl_familiares.Nombre, tbl_familiares.Apellido1, tbl_familiares.Apellido2, tbl_grupo_familiar.NombreGrupoFamiliar, tbl_familiares.Estado from tbl_familiares INNER JOIN tbl_grupo_familiar ON tbl_grupo_familiar.IdGrupoFamiliar = tbl_familiares.GrupoFamiliar where tbl_familiares.IdFamiliar ='"+IdFamiliar+"';";
                }else if(GrupoFamiliar != null){
                    sql = "select tbl_familiares.IdFamiliar, tbl_familiares.Nombre, tbl_familiares.Apellido1, tbl_familiares.Apellido2, tbl_grupo_familiar.NombreGrupoFamiliar, tbl_familiares.Estado from tbl_familiares INNER JOIN tbl_grupo_familiar ON tbl_grupo_familiar.IdGrupoFamiliar = tbl_familiares.GrupoFamiliar where tbl_familiares.GrupoFamiliar = "+GrupoFamiliar+";";
                }
            }
            
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
     * Método que permite obtener todos los registros de parentesco a fin de cargarlos en el formulario
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerParentesco() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdParentesco, Nombre from tbl_parentescos";
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
     * Método que permite obtener todos los registros de departamento a fin de cargarlos en el formulario
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
     * Método que permite obtener todos los registros de municipio según el departamento seleccionado a fin de cargarlos en el formulario
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
     * Método que permite obtener todos los registros de grupo familiar existentes
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerGrupoFamiliar() throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdGrupoFamiliar, NombreGrupoFamiliar from tbl_grupo_familiar";
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
     * Método que permite obtener los registros de grupo familiar coincidentes con la búsqueda
     * @param busqueda
     * @return result
     * @throws SQLException 
     */
    public static TreeMap obtenerGruposFamiliares(String busqueda) throws SQLException {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        //ArrayList result = new ArrayList();
        try {
            Connection conectar;
            conectar = Conexion.getConexionMysql();
            String sql = "select IdGrupoFamiliar, NombreGrupoFamiliar from tbl_grupo_familiar WHERE NombreGrupoFamiliar LIKE '%" + busqueda +"%' LIMIT 10;";
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
     * Método que permite guardar el grupo familiar en la base de datos
     * @param Nombre 
     */
    public static void guardarGrupoFamiliar(String Nombre) {
        Connection conectar;
        conectar = Conexion.getConexionMysql();
        try {
            String sql = "insert into tbl_grupo_familiar(IdGrupoFamiliar, NombreGrupoFamiliar) values (?,?);";
            PreparedStatement cmd = conectar.prepareStatement(sql);
            cmd.setString(1, null);
            cmd.setString(2, Nombre);
            cmd.executeUpdate();
            JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Gestión Asdesilla", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
