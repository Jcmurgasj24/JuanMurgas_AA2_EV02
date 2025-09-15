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
public class agregar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
    
        // ✅ Datos de ejemplo para insertar
        String placa = "ABC123";
        String marca = "Toyota";
        String modelo = "Corolla";
        String color = "Rojo";
        int id_residente = 1; // debe existir en la tabla Residente
    
        String sql = "INSERT INTO Vehiculo (placa, marca, modelo, color, id_residente) " +
                     "VALUES ('"+placa+"','"+marca+"','"+modelo+"','"+color+"',"+id_residente+")";
    
        try {
            // ✅ Driver actualizado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
        }
    
        try {
            cn = con.getConection();
            st = cn.createStatement();
            
            // ✅ Insertar el vehículo
            st.executeUpdate(sql);
            System.out.println("✅ Vehículo agregado correctamente.");
    
            // ✅ Consultar todos los vehículos
            rs = st.executeQuery("SELECT * FROM Vehiculo");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id_vehiculo") + ": " +
                    rs.getString("placa") + " - " +
                    rs.getString("marca") + " - " +
                    rs.getString("modelo") + " - " +
                    rs.getString("color") + " - " +
                    rs.getInt("id_residente")
                );
            }
    
        } catch (SQLException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // ✅ Cerrar conexiones
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
