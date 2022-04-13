/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ketnoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KetNoi {
    private Connection con = null;

    public KetNoi() throws SQLException {
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
           String dbUrl = "jdbc:jtds:sqlserver://ADMIN:1433/abc_2050531200327;instance=SQLEXPRESS;user=sa;password=123";          
           con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public ResultSet GetResultSet(String tableName) throws SQLException {
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        String sql = "select * from " + tableName;
        rs = stmt.executeQuery(sql);
        return rs;
    }

            public void Close() throws Exception {
        con.close();
    }

         public static void main(String[] args) throws SQLException {
             KetNoi kn =new KetNoi();
                   try {
            ResultSet rs= kn.GetResultSet("KhachHang");//Table Name
            while(rs.next())
            {
                System.out.println(rs.getString("tenKH"));//Field Name
            }
            kn.Close();
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


