/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Residente;

import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class eliminar {
    public static void main(String[] args) {
        conexion con = new conexion();
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ Driver actualizado
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ ELIMINAR (ejemplo: elimina el residente con id_residente = 1)
            String sqlEliminar = "DELETE FROM Residente WHERE id_residente = 1";
            int filas = st.executeUpdate(sqlEliminar);

            if (filas > 0) {
                System.out.println("✅ Registro eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el registro para eliminar.");
            }

            // ✅ MOSTRAR registros restantes en la tabla
            rs = st.executeQuery("SELECT * FROM Residente");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_residente") + ": " +
                    rs.getString("nombre") + " - " +
                    rs.getString("apellido") + " - " +
                    rs.getString("tipo_documento") + " - " +
                    rs.getString("numero_documento") + " - " +
                    rs.getString("telefono") + " - " +
                    rs.getString("email") + " - " +
                    rs.getString("numero_apartamento")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // ✅ Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                System.out.println("❌ Error al cerrar conexiones: " + e.getMessage());
            }
        }
    }
}
