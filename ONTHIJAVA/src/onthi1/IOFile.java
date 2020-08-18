/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onthi1;

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
    public static void writeFile(QuanLyNhanVien dsnv, String fileName) {
        LinkedList<NhanVien> list = dsnv.getDsnv();
        try {
            FileWriter fw = new FileWriter(fileName);
            NhanVien nv;
            for (int i = 0; i < list.size(); i++) {
                nv = list.get(i);
                fw.write(nv.toString());
                if (i < list.size() - 1) {
                    fw.write("\r\n");
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("loi ghi file");
        }

    }

    public static LinkedList<NhanVien> readFile(String fileName) {
        LinkedList<NhanVien> dsnv = new LinkedList<NhanVien>();
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line;
            NhanVien nv;
            String[] thongTinNV;
            while ((line = br.readLine()) != null) {
                thongTinNV = line.split("-");
                if (thongTinNV.length == 6) {
                    nv = new NVHD(Integer.parseInt(thongTinNV[0]), thongTinNV[1], Integer.parseInt(thongTinNV[2]), Integer.parseInt(thongTinNV[3]), Integer.parseInt(thongTinNV[4]));
                } else {
                    nv = new NVBC(Integer.parseInt(thongTinNV[0]), thongTinNV[1], Integer.parseInt(thongTinNV[2]), Integer.parseInt(thongTinNV[3]), Integer.parseInt(thongTinNV[4]), Integer.parseInt(thongTinNV[5]));
                }
                dsnv.add(nv);
            }
            br.close();
            fr.close();
        } catch (IOException io) {

        }

        return dsnv;

    }
}
