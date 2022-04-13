/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ketnoi;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ThuVien {
    public static int getInt(String mess){
        Scanner sc = new Scanner(System.in);
        System.out.println(mess);
        return sc.nextInt();
    }
    
    public static double getDouble(String mess){
        Scanner sc = new Scanner(System.in);
        System.out.println(mess);
        return sc.nextDouble();
    }
    
    public static String getString(String mess){
        Scanner sc = new Scanner(System.in);
        System.out.println(mess);
        return sc.nextLine();
    }
}
