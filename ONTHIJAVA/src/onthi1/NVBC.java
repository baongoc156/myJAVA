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
public class NVBC extends NhanVien {

    //fields
    private int luongCoBan;
    private int heSoLuong;
    private int tienPhuCap;
    //properties

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int getTienPhuCap() {
        return tienPhuCap;
    }

    public void setTienPhuCap(int tienPhuCap) {
        this.tienPhuCap = tienPhuCap;
    }
    //constructors

    public NVBC() {
    }

    public NVBC(int maSo, String hoTen, int namSinh, int luongCoBan, int heSoLuong, int tienPhuCap){
        super(maSo, hoTen, namSinh);
        if (maSo < 0 || luongCoBan < 0 || heSoLuong < 0 || tienPhuCap < 0 || hoTen == null || namSinh < 0) {
            throw new IllegalArgumentException();
        }
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.tienPhuCap = tienPhuCap;
    }

    // tinh luong
    @Override
    public long getLuong() {
        return luongCoBan * heSoLuong * tienPhuCap;
    }

    // in
    @Override
    public String toString() {
        return String.format("%d-%s-%d-%d-%d-%d-%d", getMaSo(), getHoTen(), getNamSinh(), getLuongCoBan(), getHeSoLuong(), getTienPhuCap(), getLuong());
    }

}
