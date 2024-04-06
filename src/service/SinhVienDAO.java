/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import database.DBcontext;
import java.sql.*;
import java.util.ArrayList;
import model.SinhVien;

public class SinhVienDAO {

    Connection conn = null;
    Statement stm = null;
    PreparedStatement psm = null;
    ResultSet rs = null;

    public int save(SinhVien sv) {
        String sql = "INSERT INTO STUDENTS(MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, Hinh)\n"
                + "VALUES\n"
                + "(?,?, ?, ?, ?, ?, ?)";
        try {
            conn = DBcontext.getConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, sv.getMaSV());
            psm.setString(2, sv.getHoTen());
            psm.setString(3, sv.getEmail());
            psm.setString(4, sv.getSoDT());
            psm.setBoolean(5, sv.isGioiTinh());
            psm.setString(6, sv.getDiaChi());
            psm.setString(7, sv.getHinh());
            
            int row = psm.executeUpdate();
            return row;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                psm.close();
                conn.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return -1;
    }
    
    public int delete(SinhVien sv) {
        String sql = "delete STUDENTS where MaSV = ?";
        try {
            conn = DBcontext.getConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, sv.getMaSV());
            
            int row = psm.executeUpdate();
            return row;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                psm.close();
                conn.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return -1;
    }
    
    public int update(SinhVien sv) {
        String sql = "update STUDENTS set HoTen = ?, Email = ?, SDT = ?, GioiTinh = ?, DiaChi = ?, Hinh = ? where MaSV = ?";
        try {
            conn = DBcontext.getConnection();
            psm = conn.prepareStatement(sql);
            
            psm.setString(1, sv.getHoTen());
            psm.setString(2, sv.getEmail());
            psm.setString(3, sv.getSoDT());
            psm.setBoolean(4, sv.isGioiTinh());
            psm.setString(5, sv.getDiaChi());
            psm.setString(6, sv.getHinh());
            psm.setString(7, sv.getMaSV());
            
            int row = psm.executeUpdate();
            return row;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                psm.close();
                conn.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return -1;
    }
    
    public ArrayList<String> getAllMaSV(){
        ArrayList<String> listMaSV = new ArrayList<>();
        
        String sql = "select MaSV from STUDENTS";
        try {
            conn = DBcontext.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                listMaSV.add(rs.getString(1)); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return listMaSV;
    }
    
    
    
    
    
    

}
