/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestThi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyGiayDepController {

    private QuanLyGiayDep model;
    private FormQuanLyGiayDep view;

    public QuanLyGiayDep getModel() {
        return model;
    }

    public void setModel(QuanLyGiayDep model) {
        this.model = model;
    }

    public FormQuanLyGiayDep getView() {
        return view;
    }

    public void setView(FormQuanLyGiayDep view) {
        this.view = view;
    }

    public QuanLyGiayDepController() {
        model = new QuanLyGiayDep();
        view = new FormQuanLyGiayDep();
    }

    public QuanLyGiayDepController(QuanLyGiayDep model, FormQuanLyGiayDep view) {
        this.model = model;
        this.view = view;
        init(); 
        this.view.setVisible(true);
    }

    public void init() {

        ///them
        view.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!model.checkMa(model, view.getTxtMa().getText())) {
                    GiayDep gd = themSanPham(view);
                    model.themSanPham(gd);
                    showTable(model.getDsgd());
                } else {
                    JOptionPane.showMessageDialog(null, "Khong thanh cong");
                }
            }
        });

        //xoa
        view.getBtnXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (model.checkMa(model, view.getTxtMa().getText())) {
                    int selection = JOptionPane.showConfirmDialog(null, "Xac nhan xoa");
                    if (selection == 0) {
                        model.xoaSanPham(view.getTxtMa().getText());
                        showTable(model.getDsgd());
                    }
                }
            }
        });
        //luu
        view.getBtnLuu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IOFile.writeFile(model.getDsgd(), "testa.txt");
                JOptionPane.showMessageDialog(null, "Luu thanh cong");
            }
        });
        //doc file
        view.getBtnDoc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                model.setDsgd(IOFile.readFile("danhsach_giaydep.txt"));
                JOptionPane.showMessageDialog(null, "Doc thanh cong");
                showTable(model.getDsgd());

            }
        });
        //sua

        view.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (model.checkMa(model, view.getTxtMa().getText())) {
                    model.suaSanPham(themSanPham(view));
                    showTable(model.getDsgd());
                } else {
                    JOptionPane.showMessageDialog(null, "Khong thanh cong");
                }
            }
        });
    }

    //hien bang
    public void showTable(LinkedList<GiayDep> gd) {
        DefaultTableModel table = (DefaultTableModel) view.getDanhSach().getModel();
        table.setColumnCount(4);
        table.setRowCount(0);
        for (GiayDep giayDep : gd) {
            table.addRow(new Object[]{giayDep.getMa(), giayDep.getLoai(), giayDep.getSize(), giayDep.getGia()});
        }
        view.getDanhSach().setModel(table);
    }

    //them san pham
    public GiayDep themSanPham(FormQuanLyGiayDep view) {
        String ma = view.getTxtMa().getText();
        int loai = Integer.parseInt(view.getTxtLoai().getText());
        int size = Integer.parseInt(view.getTxtSize().getText());
        double gia = Double.parseDouble(view.getTxtGia().getText());
        return new GiayDep(ma, loai, size, gia);
    }

}
