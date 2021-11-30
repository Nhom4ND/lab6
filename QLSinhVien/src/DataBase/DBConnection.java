/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Welcome
 */
public class DBConnection {

    /**
     * @param args the command line arguments
     */
    String dbName = "QLSinhVien"; //tên cơ sở dữ liệu cần kết nối
    String connString = "jdbc:sqlserver://localhost:1433;integratedSecurity=true; databaseName=" + dbName;
    public Connection GetConnection()
    {
        Connection conn;
        try 
        {
            conn = DriverManager.getConnection(connString);
            return conn;
        } catch (SQLException ex) 
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } 
    }
     public ResultSet GetData(String query)
     {
        Connection conn = GetConnection();
        if(conn==null) //nếu không thể mở kết nối
        {
            CloseConnection(conn); //Đóng kết nối
            return null;
        }
        Statement stm;
        try
        {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
            CloseConnection(conn); //đóng kết nối
            return null;
        }

     }
     public boolean UpdateData(String query)
     {
        Connection conn = GetConnection();
        if(conn==null)
            return false;
            Statement stm;
        try
        {
            stm = conn.createStatement();
            stm.executeUpdate(query);
            return true;
        }catch(SQLException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
     }
     public void CloseConnection(Connection conn)
     {
         try
         {
             conn.close();
         }catch(SQLException ex)
         {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
         }
     }
}
