/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestThi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class IOFile {

    public static void writeFile(LinkedList<GiayDep> ds, String fileName) {
        try {
            
            FileWriter fw = new FileWriter(fileName);
            for (int i = 0; i < ds.size(); i++) {
                fw.write(ds.get(i).toString());
                if (i < ds.size() - 1) {
                    fw.write("\r\n");
                }
            }
            fw.close();
        } catch (IOException e) {
        }
    }

    public static LinkedList<GiayDep> readFile(String fileName) {
        LinkedList<GiayDep> ds = new LinkedList<GiayDep>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] thongTin;
            GiayDep gd;
            while ((line = br.readLine()) != null) {
                thongTin = line.split("-");
                gd = new GiayDep(thongTin[0], Integer.parseInt(thongTin[1]), Integer.parseInt(thongTin[2]), Double.parseDouble(thongTin[3]));
                ds.add(gd);
            }
        } catch (IOException e) {
        }
        return ds;
    }
}
