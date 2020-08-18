/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onthi1;

/**
 *
 * @author Admin
 */
public abstract  class NhanVien {
    //fields
    private int maSo;
    private String hoTen;
    private int namSinh;
    //properties
    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    //constructor

    public NhanVien() {
    }
    
    public NhanVien(int maSo, String hoTen, int namSinh) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }
    //Methods
    //tinh luong
    public abstract long getLuong();
    @Override
    public abstract String toString();
                    
}
