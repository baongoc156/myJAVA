/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onthi1;

import java.util.LinkedList;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class Test1 {

    @Test
    public void testNVBCNormal() {
        NVBC nv = new NVBC(1, "ngoc", 2001, 2000, 1, 1);
        String actual = nv.toString();
        String expected = "1-ngoc-2001-2000-1-1-2000";
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNVBCAbNormal() {
        NVBC nv = new NVBC(-1, null, -2001, -2000, -1, -1);
        NVBC nv1 = new NVBC(-1, "ngoc", 2001, 2000, 1, 1);
        NVBC nv2 = new NVBC(-1, null, -2001, 2000, 1, 1);
        NVBC nv3 = new NVBC(1, "ngoc", 2001, -2000, 1, 1);
        NVBC nv4 = new NVBC(1, "ngoc", 2001, 2000, -1, 1);
        NVBC nv5 = new NVBC(1, "ngoc", 2001, 2000, 1, -1);

    }

    @Test
    public void testThemNhanVien() {
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 1, 1));
        NhanVien nv = new NVBC(1, "ngoc", 2001, 2000, 1, 1);
        assertEquals(list.get(0).toString(), nv.toString());
    }

    @Test
    public void testTinhTongLuong() {
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 1, 1));
        list.add(new NVHD(2, "ngoc", 2001, 2000, 1));
        list.add(new NVBC(3, "ngoc", 2001, 2000, 1, 1));

        long actual = list.getTongLuong();
        long expected = 6000;
        assertEquals(expected, actual);

    }

    // test tim max luong
    @Test
    public void testTimMaxLuong() {
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 2, 1));
        list.add(new NVHD(2, "ngoc", 2001, 2000, 1));
        list.add(new NVBC(3, "ngoc", 2001, 2000, 2, 1));
        LinkedList<NhanVien> dsLuongMax = list.timMaxLuong();

        assertEquals(2, dsLuongMax.size());
        assertEquals(list.get(0).getLuong(), dsLuongMax.get(0).getLuong());
        assertEquals(list.get(2).getLuong(), dsLuongMax.get(1).getLuong());
    }
    // test tim min luong

    @Test
    public void testTimMinLuong() {
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 2, 1));
        list.add(new NVHD(2, "ngoc", 2001, 2000, 1));
        list.add(new NVBC(3, "ngoc", 2001, 2000, 2, 1));
        LinkedList<NhanVien> dsLuongMin = list.timMinLuong();

        assertEquals(1, dsLuongMin.size());
        assertEquals(list.get(1).getLuong(), dsLuongMin.get(0).getLuong());
    }

    @Test
    public void testSapXepNVTheoLuongTrungTheoTuoi() {
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 2, 1)); //4000
        list.add(new NVHD(2, "ngoc", 2003, 2000, 1));   //2000
        list.add(new NVBC(3, "ngoc", 2002, 2000, 2, 1)); //4000
        list.add(new NVBC(4, "ngoc", 2000, 2000, 1, 1)); //2000
        LinkedList<NhanVien> dsSauSX = list.sapXepNVTheoLuongTrungTheoTuoi();

        assertEquals(list.get(3).getLuong(), dsSauSX.get(0).getLuong());
        assertEquals(list.get(2).getLuong(), dsSauSX.get(3).getLuong());
        assertEquals(list.get(0).getLuong(), dsSauSX.get(2).getLuong());
        assertEquals(list.get(1).getLuong(), dsSauSX.get(1).getLuong());
    }

    @Test
    public void testTimNhanVienTheoMa() {
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 2, 1)); //4000
        list.add(new NVHD(2, "ngoc", 2003, 2000, 1));   //2000
        list.add(new NVBC(3, "ngoc", 2002, 2000, 2, 1)); //4000

        NhanVien timKiem = list.timNhanVienTheoMa(2);
        assertEquals(timKiem.toString(), list.get(1).toString());
    }

    @Test
    public void testDocFile() {
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 1, 1)); //4000
        list.add(new NVHD(2, "ngoc", 2001, 2000, 0));   //0
        list.add(new NVBC(3, "ngoc", 2001, 2000, 1, 1)); //4000
        LinkedList<NhanVien> docFile = IOFile.readFile("3k.txt");
        assertEquals(docFile.get(0).toString(), list.get(0).toString());
        assertEquals(docFile.get(1).toString(), list.get(1).toString());
        assertEquals(docFile.get(2).toString(), list.get(2).toString());

    }

    @Test
    public void testGhiFile() {
        QuanLyNhanVien list = new QuanLyNhanVien();
        list.add(new NVBC(1, "ngoc", 2001, 2000, 1, 1)); //4000
        list.add(new NVHD(2, "ngoc", 2001, 2000, 0));   //0
        list.add(new NVBC(3, "ngoc", 2001, 2000, 1, 1)); //4000
        IOFile.writeFile(list, "test.txt");
        LinkedList<NhanVien> docFile = IOFile.readFile("test.txt");
        assertEquals(docFile.get(0).toString(), list.get(0).toString());
        assertEquals(docFile.get(1).toString(), list.get(1).toString());
        assertEquals(docFile.get(2).toString(), list.get(2).toString());

    }
}
