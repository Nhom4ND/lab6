/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Welcome
 */
public class KetNoiCSDL 
    {
        Connection cn= null;
        public KetNoiCSDL() throws SQLException 
        {
            String url="jdbc:mysql://localhost:3306/csdl1";
            this.cn=DriverManager.getConnection(url,"root","");
        }
        public ResultSet LayDL (String tenbang) throws SQLException 
        {
            ResultSet kq=null;
            Statement st=this.cn.createStatement();
            String sql= "select * from taikhoan";
            kq=st.executeQuery(sql);
            return kq;
        } 
        public static void main(String[] args) throws SQLException
        {
            KetNoiCSDL a= new KetNoiCSDL();
            ResultSet rs=a.LayDL("taikhoan");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)); 
            }
        }
    }   

        
