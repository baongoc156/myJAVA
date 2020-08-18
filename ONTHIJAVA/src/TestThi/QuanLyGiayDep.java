/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestThi;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class QuanLyGiayDep {
    //fields

    private LinkedList<GiayDep> dsgd;

    //properties
    public GiayDep get(int i) {
        int j = 0;
        for (GiayDep giayDep : dsgd) {
            if (i == j) {
                return giayDep;
            }
            j++;
        }
        return null;

    }

    public LinkedList<GiayDep> getDsgd() {
        return dsgd;
    }

    public void setDsgd(LinkedList<GiayDep> dsgd) {
        this.dsgd = dsgd;
    }

    //constructor
    public QuanLyGiayDep() {
        dsgd = new LinkedList<GiayDep>();
    }

    //Methods
    //Them san pham
    public void themSanPham(GiayDep gd) {
        dsgd.add(gd);
    }

    //Xoa san pham khi biet ma
    public boolean xoaSanPham(String ma) {
        for (GiayDep giayDep : dsgd) {
            if (giayDep.getMa().equals(ma)) {
                dsgd.remove(giayDep);
                return true;
            }
        }
        return false;
    }

    public boolean suaSanPham(GiayDep gd) {
        for (int i = 0; i < dsgd.size(); i++) {
            if (dsgd.get(i).getMa().equals(gd.getMa())) {
                dsgd.set(i, gd);
                return true;
            }
        }
        return false;
    }

    //Sap xep danh sach theo loai cung loai sap xep giam dan theo gia
    public LinkedList<GiayDep> sapXepTangDanTheoLoaiGiamDanTheoGia() {
        LinkedList<GiayDep> ds = (LinkedList<GiayDep>) dsgd.clone();
        ds.sort(new Comparator<GiayDep>() {
            @Override
            public int compare(GiayDep t, GiayDep t1) {
                if (t.getLoai() == t1.getLoai()) {
                    if (t.getGia() == t1.getGia()) {
                        return 0;
                    } else if (t.getGia() < t1.getGia()) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return t.getLoai() - t1.getLoai();
                }
            }
        });
        return ds;
    }

    //Tim cac giay dep co gia nho nhat
    public LinkedList<GiayDep> timCacGiayDepGiaMin() {
        LinkedList<GiayDep> dsMin = new LinkedList<GiayDep>();
        double min = Collections.min(dsgd, new Comparator<GiayDep>() {
            @Override
            public int compare(GiayDep t, GiayDep t1) {
                if (t.getGia() == t1.getGia()) {
                    return 0;
                } else if (t.getGia() < t1.getGia()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }).getGia();
        for (GiayDep giayDep : dsgd) {
            if (min == giayDep.getGia()) {
                dsMin.add(giayDep);
            }
        }
        return dsMin;
    }

    public boolean checkMa(QuanLyGiayDep ql, String ma) {
        for (GiayDep gd : ql.getDsgd()) {
            if (gd.getMa().equals(ma)) {
                return true;
            }
        }
        return false;
    }

}
