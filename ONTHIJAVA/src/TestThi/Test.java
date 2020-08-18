/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestThi;

/**
 *
 * @author Admin
 */
public class Test {

    public static void main(String[] args) {
        QuanLyGiayDep model = new QuanLyGiayDep();
        FormQLGD view = new FormQLGD();
        QLGDController qlgdc = new QLGDController(model, view);
    }
}
