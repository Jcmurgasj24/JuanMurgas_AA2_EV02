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
        
        String nombre = "Ricardo";
        String apellido = "Navarro";
        String tipo_documento = "Cedula";
        String numero_documento = "1002456789";
        String telefono = "3126271436";
        String email = "ricardo.navarro@example.com";
        String numero_apartamento = "B12";
        
        // 👉 Sentencia INSERT a la tabla Residente
        String sql = "INSERT INTO Residente (nombre, apellido, tipo_documento, numero_documento, telefono, email, numero_apartamento) "
                   + "VALUES ('"+nombre+"', '"+apellido+"', '"+tipo_documento+"', '"+numero_documento+"', '"+telefono+"', '"+email+"', '"+numero_apartamento+"')";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        }catch(ClassNotFoundException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try{
            cn = con.getConection();
            st = cn.createStatement();
            
            // ✅ Inserción
            st.executeUpdate(sql);
            System.out.println("✅ Registro insertado correctamente.");
            
            // ✅ Consulta para mostrar todos los registros en Residente
            rs = st.executeQuery("SELECT * FROM Residente");
            
            while (rs.next()){
                System.out.println(
                    rs.getInt("id_residente")+": "+
                    rs.getString("nombre")+" - "+
                    rs.getString("apellido")+" - "+
                    rs.getString("tipo_documento")+" - "+
                    rs.getString("numero_documento")+" - "+
                    rs.getString("telefono")+" - "+
                    rs.getString("email")+" - "+
                    rs.getString("numero_apartamento")
                );
            }
            
        }catch (SQLException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
