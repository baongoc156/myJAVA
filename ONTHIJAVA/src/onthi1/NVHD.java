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
public class NVHD extends NhanVien{
    //fields
    private int tien1H;
    private int soHLam;
    //properties

    public int getTien1H() {
        return tien1H;
    }

    public void setTien1H(int tien1H) {
        this.tien1H = tien1H;
    }

    public int getSoHLam() {
        return soHLam;
    }

    public void setSoHLam(int soHLam) {
        this.soHLam = soHLam;
    }
    //constructors

    public NVHD() {
    }

    public NVHD(int maSo, String hoTen, int namSinh,int tien1H, int soHLam ) {
        super(maSo, hoTen, namSinh);
        this.tien1H = tien1H;
        this.soHLam = soHLam;
    }
    //tinh luong
    @Override
    public long getLuong() {
        return tien1H * soHLam;
    }
    //in
    @Override
    public String toString() {
        return String.format("%d-%s-%d-%d-%d-%d", getMaSo(), getHoTen(), getNamSinh(),getTien1H(),getSoHLam() ,getLuong());
    }
    
    
}
