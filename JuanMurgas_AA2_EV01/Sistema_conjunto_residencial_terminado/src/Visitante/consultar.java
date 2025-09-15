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
public class consultar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        
        try {
            // ✅ Driver actualizado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            
            // ✅ Consultar todos los visitantes
            rs = st.executeQuery("SELECT * FROM Visitante");
            
            // Recorremos los resultados
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
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
