/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onthi1;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Test {

    public static void main(String[] args) {
//        NVBC nv = new NVBC(1,"ngoc",2001,2000,1,1);
//        System.out.println(nv.toString());
//        
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 1, 1));
        list.add(new NVHD(2, "ngoc", 2001, 2000, 0));
        list.add(new NVBC(3, "ngoc", 2001, 2000, 1, 1));
        System.out.println(list.getTongLuong());
        LinkedList<NhanVien> ds = list.timMinLuong();
        System.out.println(ds.toString());
        IOFile.writeFile(list, "3k.txt");
        LinkedList<NhanVien> dsnv = IOFile.readFile("3k.txt");
        System.out.println(dsnv.toString());

    }
}
