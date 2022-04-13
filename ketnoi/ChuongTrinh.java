/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ketnoi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ChuongTrinh {
    

    public static void main(String[] args) throws SQLException {
        KetNoiSQL kn = new KetNoiSQL();
        System.out.println(" NGÂN HÀNG NHÀ NƯỚC VIỆT NAM");
        System.out.println("1. Tra cứu tài khoản");
        System.out.println("2. Hiển thị tất cả tài khoản");
        System.out.println("3. Thêm tài khoản");
        int n = ThuVien.getInt("Mời chọn giá trị: ");
        switch (n){
            case 1:
                int soTK=ThuVien.getInt("Mời nhập số tài khoản: ");
                kn.traCuuTaiKhoan(soTK);
                break;
            case 2:
                kn.infoAll();
                break;
            case 3:
                kn.createAccount();
                break;
            default:
                System.out.println("Chọn giá trị sai!!!");
                break;
    }
   }
}