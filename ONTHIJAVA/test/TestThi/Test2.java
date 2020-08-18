/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestThi;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class Test2 {

    // kiem tra constructor voi tham so hop le
    @Test
    public void testGiayDep_Normal() {
        GiayDep gd = new GiayDep("g1", 1, 1, 5.5);
        String actual = gd.toString();
        String expected = "g1-1-1-5.5";
        assertEquals(expected, actual);
    }

    //Kiem tra constuctor tham so khong hop le
    @Test(expected = IllegalArgumentException.class)
    public void testGiayDep_AbNormal() {
        GiayDep gd = new GiayDep(null, 1, 1, 5.5);
        GiayDep gd1 = new GiayDep("g1", 0, -1, 5.5);
        GiayDep gd2 = new GiayDep(null, 1, -1, -1);
        GiayDep gd3 = new GiayDep(null, -1, -1, -1);

    }

    // Kiem tra them san pham
    @Test
    public void testThemSanPham() {
        QuanLyGiayDep ds = new QuanLyGiayDep();
        GiayDep gd = new GiayDep("g1", 1, 1, 5.5);
        ds.themSanPham(gd);

        assertEquals(1, ds.getDsgd().size());
        assertEquals(gd, ds.get(0));
    }

    //Kiem ra xoa san pham
    @Test
    public void testXoaSanPham() {
        QuanLyGiayDep ds = new QuanLyGiayDep();
        GiayDep gd = new GiayDep("g1", 1, 1, 5.5);
        GiayDep gd2 = new GiayDep("g2", 2, 15, 10);
        GiayDep gd3 = new GiayDep("g3", 4, 2, 10.1);
        ds.themSanPham(gd);
        ds.themSanPham(gd2);
        ds.themSanPham(gd3);
        boolean test = ds.xoaSanPham("g1");
        assertEquals(2, ds.getDsgd().size());
        assertEquals(test, true);
        assertEquals(gd2, ds.get(0));
        assertEquals(gd3, ds.get(1));
    }
    //Sua 
    
    @Test
    public void testSuaSanPham() {
        QuanLyGiayDep ds = new QuanLyGiayDep();
        GiayDep gd = new GiayDep("g1", 1, 1, 5.5);
        GiayDep gd2 = new GiayDep("g2", 2, 15, 10);
        GiayDep gd3 = new GiayDep("g2", 4, 2, 10.1);
        ds.themSanPham(gd);
        ds.themSanPham(gd2);
        
        boolean test = ds.suaSanPham(gd3);
        assertEquals(test, true);
     
    }
    //Kiem tra sap xep tang dan theo loai neu cung gia sap xep giam dan heo
    @Test
    public void testSapXepTangDanTheoLoaiGiamDanTheoGia() {
        QuanLyGiayDep ds = new QuanLyGiayDep();
        GiayDep gd = new GiayDep("g1", 1, 1, 5.5);
        GiayDep gd2 = new GiayDep("g2", 2, 15, 10);
        GiayDep gd3 = new GiayDep("g3", 2, 2, 10.5);
        ds.themSanPham(gd);
        ds.themSanPham(gd2);
        ds.themSanPham(gd3);
        LinkedList<GiayDep> dsSauSX = ds.sapXepTangDanTheoLoaiGiamDanTheoGia();
        assertEquals(ds.get(0).toString(), dsSauSX.get(0).toString());
        assertEquals(ds.get(2).toString(), dsSauSX.get(1).toString());
        assertEquals(ds.get(1).toString(), dsSauSX.get(2).toString());

    }

    //Kiem tra tim giay min
    @Test
    public void testTimCacGiayDepGiaMin() {
        QuanLyGiayDep ds = new QuanLyGiayDep();
        GiayDep gd = new GiayDep("g1", 1, 1, 5.5);
        GiayDep gd2 = new GiayDep("g2", 2, 2, 10.5);
        GiayDep gd3 = new GiayDep("g3", 1, 1, 5.5);
        ds.themSanPham(gd);
        ds.themSanPham(gd2);
        ds.themSanPham(gd3);
        LinkedList<GiayDep> dsGiaMin = ds.timCacGiayDepGiaMin();
        assertEquals(2, dsGiaMin.size());
        assertEquals(ds.get(0).toString(), dsGiaMin.get(0).toString());
        assertEquals(ds.get(2).toString(), dsGiaMin.get(1).toString());
    }

    @Test
    public void testDocFile() {
        QuanLyGiayDep ds = new QuanLyGiayDep();
        GiayDep gd = new GiayDep("g1", 1, 1, 5.5);
        GiayDep gd2 = new GiayDep("g2", 2, 2, 10.5);
        GiayDep gd3 = new GiayDep("g3", 1, 1, 5.5);
        ds.themSanPham(gd);
        ds.themSanPham(gd2);
        ds.themSanPham(gd3);
        LinkedList<GiayDep> docFile = IOFile.readFile("danhsach_giaydep.txt");
        assertEquals(ds.get(0).toString(), docFile.get(0).toString());
        assertEquals(ds.get(1).toString(), docFile.get(1).toString());
        assertEquals(ds.get(2).toString(), docFile.get(2).toString());
    }

    @Test
    public void testGhiFile() {
        QuanLyGiayDep ds = new QuanLyGiayDep();
        GiayDep gd = new GiayDep("g1", 1, 1, 5.5);
        GiayDep gd2 = new GiayDep("g2", 2, 2, 10.5);
        GiayDep gd3 = new GiayDep("g3", 1, 1, 5.5);
        ds.themSanPham(gd);
        ds.themSanPham(gd2);
        ds.themSanPham(gd3);
        IOFile.writeFile(ds.getDsgd(), "danhsach_giaydepNew.txt");
        LinkedList<GiayDep> docFile = IOFile.readFile("danhsach_giaydepNew.txt");
        assertEquals(ds.get(0).toString(), docFile.get(0).toString());
        assertEquals(ds.get(1).toString(), docFile.get(1).toString());
        assertEquals(ds.get(2).toString(), docFile.get(2).toString());

    }

}
