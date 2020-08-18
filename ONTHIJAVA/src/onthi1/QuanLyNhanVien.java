/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onthi1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class QuanLyNhanVien {

    private LinkedList<NhanVien> dsnv;
    public static int COUNT_NVBC;
    public static int COUNT_NVHD;

    public LinkedList<NhanVien> getDsnv() {
        return dsnv;
    }

    public QuanLyNhanVien() {
        dsnv = new LinkedList<NhanVien>();
        COUNT_NVBC = 0;
        COUNT_NVHD = 0;
    }

    //them nhan vien
    public void add(NhanVien nv) {
        dsnv.add(nv);
        if (nv instanceof NVBC) {
            COUNT_NVBC++;
        } else if (nv instanceof NVHD) {
            COUNT_NVHD++;
        }
    }

    public NhanVien get(int i) {
        int j = 0;
        for (NhanVien nhanVien : dsnv) {
            if (j == i) {
                return nhanVien;
            }
            j++;
        }
        return null;

    }

    //in danh sach
    public void inList() {
        for (NhanVien nhanVien : dsnv) {
            System.out.println(nhanVien.toString());
        }
    }

    //tinh tong luong phai tra
    public long getTongLuong() {
        long tong = 0;
        for (NhanVien nhanVien : dsnv) {
            tong += nhanVien.getLuong();
        }
        return tong;
    }

    //tim max luong
    public LinkedList<NhanVien> timMaxLuong() {
        LinkedList<NhanVien> ds = new LinkedList<NhanVien>();
        double max = Collections.max(dsnv, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien t, NhanVien t1) {
                if (t.getLuong() == t1.getLuong()) {
                    return 0;
                } else if (t.getLuong() < t1.getLuong()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }).getLuong();
        for (NhanVien nhanVien : dsnv) {
            if (nhanVien.getLuong() == max) {
                ds.add(nhanVien);
            }
        }
        return ds;
    }

    //tim min luong
    public LinkedList<NhanVien> timMinLuong() {
        LinkedList<NhanVien> ds = new LinkedList<NhanVien>();
        double min = Collections.min(dsnv, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien t, NhanVien t1) {
                if (t.getLuong() == t1.getLuong()) {
                    return 0;
                } else if (t.getLuong() < t1.getLuong()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }).getLuong();
        for (NhanVien nhanVien : dsnv) {
            if (nhanVien.getLuong() == min) {
                ds.add(nhanVien);
            }
        }
        return ds;
    }

    //sap xep nhan vien theo luong trung sap xep theo tuoi
    public LinkedList<NhanVien> sapXepNVTheoLuongTrungTheoTuoi() {
        LinkedList<NhanVien> ds = (LinkedList<NhanVien>) dsnv.clone();
        ds.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien t, NhanVien t1) {
                if (t.getLuong() == t1.getLuong()) {
                    return t.getNamSinh() - t1.getNamSinh();
                } else if (t.getLuong() < t1.getLuong()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return ds;
    }

    public LinkedList<NhanVien> sapXepNV() {
        LinkedList<NhanVien> ds = (LinkedList<NhanVien>) dsnv.clone();
        ds.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien t, NhanVien t1) {
                if (((t instanceof NVBC) && (t1 instanceof NVBC)) || ((t instanceof NVHD) && (t1 instanceof NVHD))) {
                    return 0;
                } else if ((t instanceof NVBC) && (t1 instanceof NVHD)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return ds;
    }

    //tim kiem nhan vien theo ma
    public NhanVien timNhanVienTheoMa(int maNV) {
        for (NhanVien nhanVien : dsnv) {
            if (maNV == nhanVien.getMaSo()) {
                return nhanVien;
            }
        }
        return null;
    }

}
