/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Visitante;
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
        
        // Datos de ejemplo para insertar en la tabla Visitante
        String nombre = "Ricardo";
        String apellido = "Navarro";
        String tipoDocumento = "Cedula";
        String numeroDocumento = "123456789";
        String motivoVisita = "Reunión de negocios";
        
        // ✅ Consulta SQL ajustada a la tabla Visitante
        String sql = "INSERT INTO Visitante (nombre, apellido, tipo_documento, numero_documento, motivo_visita) " +
                     "VALUES ('" + nombre + "', '" + apellido + "', '" + tipoDocumento + "', '" + numeroDocumento + "', '" + motivoVisita + "')";
        
        try {
            // ✅ Driver actualizado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            
            // Ejecutar la inserción
            st.executeUpdate(sql);
            System.out.println("✅ Visitante agregado correctamente.");
            
            // ✅ Mostrar todos los visitantes
            rs = st.executeQuery("SELECT * FROM Visitante");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_visitante") + ": " +
                    rs.getString("nombre") + " - " +
                    rs.getString("apellido") + " - " +
                    rs.getString("tipo_documento") + " - " +
                    rs.getString("numero_documento") + " - " +
                    rs.getString("motivo_visita")
                );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
