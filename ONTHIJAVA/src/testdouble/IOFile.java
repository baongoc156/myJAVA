/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdouble;

import onthi1.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class IOFile {

    // ghi file
    public static void writeFile(double[] dsnv, String fileName) {
       
        try {
            FileWriter fw = new FileWriter(fileName);
            double nv;
            for (int i = 0; i < dsnv.length; i++) {
                nv = dsnv[i];
                fw.write(nv+"-");
                if (i < dsnv.length - 1) {
                    fw.write("\r\n");
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("loi ghi file");
        }

    }

//    public static LinkedList<NhanVien> readFile(String fileName) {
//        LinkedList<NhanVien> dsnv = new LinkedList<NhanVien>();
//        FileReader fr;
//        BufferedReader br;
//        try {
//            fr = new FileReader(fileName);
//            br = new BufferedReader(fr);
//            String line;
//            int nv;
//            String[] thongTinNV;
//            while ((line = br.readLine()) != null) {
//                thongTinNV = line.split("-");
//                nv = thongTinNV[0];
//            }
//            br.close();
//            fr.close();
//        } catch (IOException io) {
//
//        }
//
//        return dsnv;
//
//    }
}
