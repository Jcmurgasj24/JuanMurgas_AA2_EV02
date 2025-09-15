/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro_Entrada_Salida;

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
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ Driver actualizado
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ ELIMINAR usando id_registro
            int idAEliminar = 1; // <-- aquí cambias el id_registro que quieras eliminar
            String sqlEliminar = "DELETE FROM Registro_Entrada_Salida WHERE id_registro = " + idAEliminar;
            
            int filas = st.executeUpdate(sqlEliminar);
            if (filas > 0) {
                System.out.println("✅ Registro con id_registro = " + idAEliminar + " eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el registro con id_registro = " + idAEliminar);
            }

            // ✅ MOSTRAR registros restantes
            rs = st.executeQuery("SELECT * FROM Registro_Entrada_Salida");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_registro") + ": " +
                    rs.getString("tipo_registro") + " | " +
                    rs.getString("fecha_hora") + " | Vehículo ID: " +
                    rs.getString("id_vehiculo") + " | Visitante ID: " +
                    rs.getString("id_visitante") + " | Autorizado por Usuario ID: " +
                    rs.getString("autorizado_por")
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

