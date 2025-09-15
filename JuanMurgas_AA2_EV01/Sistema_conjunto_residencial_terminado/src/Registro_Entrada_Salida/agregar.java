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
public class agregar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        
        // ✅ Datos a insertar en Registro_Entrada_Salida
        String tipo_registro = "entrada";   // puede ser 'entrada' o 'salida'
        String fecha_hora = "2025-08-22 15:30:00"; // formato DATETIME
        int id_vehiculo = 1;     // ejemplo: vehículo con id = 1
        int id_visitante = 1;    // ejemplo: visitante con id = 2
        int autorizado_por = 1;  // id_usuario de Usuario_Seguridad

        String sql = "INSERT INTO Registro_Entrada_Salida " +
                     "(tipo_registro, fecha_hora, id_vehiculo, id_visitante, autorizado_por) " +
                     "VALUES ('" + tipo_registro + "', '" + fecha_hora + "', " + id_vehiculo + ", " + id_visitante + ", " + autorizado_por + ")";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ driver actualizado
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ Ejecutar inserción
            st.executeUpdate(sql);
            System.out.println("✅ Registro agregado correctamente.");

            // ✅ Mostrar todos los registros en la tabla
            rs = st.executeQuery("SELECT * FROM Registro_Entrada_Salida");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id_registro") + ": " +
                    rs.getString("tipo_registro") + " - " +
                    rs.getString("fecha_hora") + " - Vehículo: " +
                    rs.getString("id_vehiculo") + " - Visitante: " +
                    rs.getString("id_visitante") + " - Autorizado por: " +
                    rs.getString("autorizado_por")
                );
            }

        } catch (SQLException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}

