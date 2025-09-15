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
            
            // ✅ Consulta a la tabla Usuario_Seguridad
            rs = st.executeQuery("SELECT * FROM Usuario_Seguridad");
            
            if (rs.next()) {
                do {
                    System.out.println(
                        rs.getInt("id_usuario") + ": " +
                        rs.getString("nombre_usuario") + " - " +
                        rs.getString("contraseña") + " - " +
                        rs.getString("rol")
                    );
                } while (rs.next());
            } else {
                System.out.println("⚠️ No existen usuarios en la tabla Usuario_Seguridad.");
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
