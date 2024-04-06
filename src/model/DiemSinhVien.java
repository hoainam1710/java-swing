/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hoai Nam
 */
public class DiemSinhVien {
    
    private SinhVien sinhVien;
    private int tiengAnh, tinHoc, giaoDucTC;

    public DiemSinhVien() {
    }

    public DiemSinhVien(SinhVien sinhVien, int tiengAnh, int tinHoc, int giaoDucTC) {
        this.sinhVien = sinhVien;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.giaoDucTC = giaoDucTC;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGiaoDucTC() {
        return giaoDucTC;
    }

    public void setGiaoDucTC(int giaoDucTC) {
        this.giaoDucTC = giaoDucTC;
    }

  
    public float getDiemTB(int tiengAnh, int tinHoc, int giaoDucTC){
        return (float)(tiengAnh + tinHoc + giaoDucTC)/3;
        }
 
}
