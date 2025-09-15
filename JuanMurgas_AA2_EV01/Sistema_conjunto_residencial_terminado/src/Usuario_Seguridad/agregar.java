/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario_Seguridad;

import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;    

/**
 *
 * @author Juanc
 */
public class agregar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
    
        // ✅ Datos para insertar
        String nombreUsuario = "ricardo123";
        String contrasena = "segura2025";  // ⚠️ Aquí puedes encriptarla con MD5 o SHA si deseas más seguridad
        String rol = "vigilante";
    
        // ✅ Sentencia SQL adaptada
        String sql = "INSERT INTO Usuario_Seguridad (nombre_usuario, contraseña, rol) " +
                     "VALUES ('" + nombreUsuario + "', '" + contrasena + "', '" + rol + "')";
    
        try {
            // ✅ Driver actualizado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            
            // ✅ Insertar registro
            st.executeUpdate(sql);
            System.out.println("✅ Usuario agregado correctamente.");
    
            // ✅ Consultar registros de Usuario_Seguridad
            rs = st.executeQuery("SELECT * FROM Usuario_Seguridad");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_usuario") + ": " +
                    rs.getString("nombre_usuario") + " - " +
                    rs.getString("contraseña") + " - " +
                    rs.getString("rol")
                );
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
