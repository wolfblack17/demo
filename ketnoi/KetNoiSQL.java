/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ketnoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KetNoiSQL {
     private Connection con = null;

    public KetNoiSQL() throws SQLException {
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
           String dbUrl = "jdbc:jtds:sqlserver://ADMIN:1433/nganhang;instance=SQLEXPRESS;user=sa;password=123";          
           con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void traCuuTaiKhoan(int noAccount) throws SQLException{
        String sql ="Select noAccount from dulieu where noAccount="+ noAccount;
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()==true){
            System.out.println("Tìm thấy tài khoản");
        }
        else{
            System.out.println("Không tìm thấy");
        }
    }
     
     public ResultSet GetResultSet(String tableName) throws SQLException {
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        String sql = "select * from " + tableName;
        rs = stmt.executeQuery(sql);
        return rs;
    }      
     
     public void infoAll() throws SQLException{
         NumberFormat df = new DecimalFormat("#,###");
           ResultSet rs = GetResultSet("dulieu"); //table
           System.out.println("Thông tin tài khoản");
           while(rs.next()){
               System.out.println(rs.getString("noAccount"));
               System.out.println(" - ");
               System.out.println(rs.getString("nameAccount"));
               System.out.println(" - ");
               System.out.println(df.format(Double.parseDouble(rs.getString("moneyAccount")))+ "VNĐ");
           }
         
     }
     
     public void createAccount() throws SQLException{
         List<NguoiDung> listuser = new ArrayList<NguoiDung>();
         int n = ThuVien.getInt("Nhập số lượng người thêm vào hệ thống");
         for (int i=0;i<n;i++){
             listuser.add(new NguoiDung(ThuVien.getInt("Số tài khoản: "),ThuVien.getString("Họ tên"), ThuVien.getDouble("Số tiền")));
             
         }
        String sql = "INSERT INTO Account (noAccount, name Account, money Account) VALUES (?, ?, ?);";
        PreparedStatement pstmt = con.prepareStatement(sql);
        for (NguoiDung user: listuser){
            pstmt.setInt(1, user.getNoAccount());
            pstmt.setString(2, user.getNameAccount());
            pstmt.setDouble(3, user.getMoneyAccount());
            pstmt.execute();
                     //stmt.executeUpdate("INSERT INTO Account (noAccount, nameAccount, moneyAccount) VALUES("+ user.getNoAccount() +", "+user.getNameAccount()+","+user.getMoneyAccount()+" ");
         }
     }
}
