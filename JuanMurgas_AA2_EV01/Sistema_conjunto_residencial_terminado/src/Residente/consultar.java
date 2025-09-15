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
public class consultar {
    public static void main(String[] args) {
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            // lo ideal es usar "com.mysql.cj.jdbc.Driver"
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ Consultamos la tabla Residente
            rs = st.executeQuery("SELECT * FROM Residente");

            // ✅ Recorremos los registros
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
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}