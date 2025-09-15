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

public class eliminar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            // ✅ Driver actualizado
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ ELIMINAR usuario con id_usuario = 1
            String sqlEliminar = "DELETE FROM Usuario_Seguridad WHERE id_usuario = 1";
            int filas = st.executeUpdate(sqlEliminar);
            if (filas > 0) {
                System.out.println("✅ Registro eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el registro para eliminar.");
            }

            // ✅ MOSTRAR registros restantes
            rs = st.executeQuery("SELECT * FROM Usuario_Seguridad");
            while (rs.next()){
                 System.out.println(
                    rs.getInt("id_usuario") + ": " +
                    rs.getString("nombre_usuario") + " - " +
                    rs.getString("contraseña") + " - " +
                    rs.getString("rol")
                );
            }   
        } catch (SQLException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


