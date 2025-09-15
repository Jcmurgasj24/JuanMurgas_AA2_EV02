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

/**
 *
 * @author Juanc
 */
public class modificar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ Driver actualizado
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ MODIFICAR (ejemplo: cambiar tipo_registro a 'salida' en el id_registro = 1)
            int idAModificar = 1; // <- aquí cambias el id_registro que quieras editar
            String sqlModificar = "UPDATE Registro_Entrada_Salida SET tipo_registro = 'salida' WHERE id_registro = " + idAModificar;
            
            int filas = st.executeUpdate(sqlModificar);
            if (filas > 0) {
                System.out.println("✅ Registro con id_registro = " + idAModificar + " modificado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el registro con id_registro = " + idAModificar);
            }

            // ✅ MOSTRAR los registros después de la modificación
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
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
