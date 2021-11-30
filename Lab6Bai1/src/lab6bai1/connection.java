/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6bai1;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Cao Trinh
 */
public class connection {
    Connection conn = null;
    public connection() throws SQLException{
        String url ="jdbc:mysql://localhost:8080/login";
        this.conn = DriverManager.getConnection(url,"root","");
    }
    public ResultSet laydl(String tenbang) throws  SQLException{
        ResultSet kq = null;
        Statement st = this.conn.createStatement();
        String sql ="select * form thongtin";
        kq =st.executeQuery((sql));
        return kq;
    }
}
