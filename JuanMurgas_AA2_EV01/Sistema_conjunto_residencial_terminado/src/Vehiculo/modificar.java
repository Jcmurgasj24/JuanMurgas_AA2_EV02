/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;

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
public class modificar{
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            // ✅ Driver actualizado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ MODIFICAR vehículo (ejemplo: cambiar color del id_vehiculo = 1)
            String sqlModificar = "UPDATE Vehiculo SET color = 'Negro' WHERE id_vehiculo = 1";
            int filas = st.executeUpdate(sqlModificar);

            if (filas > 0) {
                System.out.println("✅ Vehículo modificado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el vehículo para modificar.");
            }

            // ✅ MOSTRAR los vehículos después de la modificación
            rs = st.executeQuery("SELECT * FROM Vehiculo");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_vehiculo") + ": " +
                    rs.getString("placa") + " - " +
                    rs.getString("marca") + " - " +
                    rs.getString("modelo") + " - " +
                    rs.getString("color") + " - " +
                    rs.getInt("id_residente")
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}

