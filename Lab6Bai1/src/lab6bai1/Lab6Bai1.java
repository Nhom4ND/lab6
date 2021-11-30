/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cao Trinh
 */
public class Lab6Bai1 {

    /**
     * @param args the command line arguments
     */
    Connection conn = null;
    public Lab6Bai1() throws SQLException{
        String url ="jdbc:mysql://localhost:3306/login";
        this.conn = DriverManager.getConnection(url,"root","");
    }
    public ResultSet laydl(String tenbang) throws  SQLException{
        ResultSet kq = null;
        Statement st = this.conn.createStatement();
        String sql ="select * form thongtin";
        kq =st.executeQuery((sql));
        return kq;
    }
    public static void main(String[] args) {
       
    }
    
}
