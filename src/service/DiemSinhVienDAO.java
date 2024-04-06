/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import database.DBcontext;
import java.sql.*;
import model.DiemSinhVien;

public class DiemSinhVienDAO {
    Connection conn = null;
    Statement stm = null;
    PreparedStatement psm = null;
    ResultSet rs = null;
    
    
    public int save(DiemSinhVien dsv){
        String sql = "insert into GRADE(MaSV, TiengAnh, TinHoc, GDTC) values (?, ?, ?, ?)";
        try {
            conn = DBcontext.getConnection();
            psm = conn.prepareStatement(sql);
            
            psm.setString(1, dsv.getSinhVien().getMaSV());
            psm.setInt(2, dsv.getTiengAnh());
            psm.setInt(3, dsv.getTinHoc());
            psm.setInt(4, dsv.getGiaoDucTC());
            
            int row = psm.executeUpdate();
            return  row;
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
   
        return -1;
    }
    
    public int update(DiemSinhVien dsv){
        String sql = "update GRADE set TiengAnh = ?, TinHoc = ?, GDTC = ? where MaSV = ?";
        try {
            conn = DBcontext.getConnection();
            psm = conn.prepareStatement(sql);
            psm.setInt(1, dsv.getTiengAnh());
            psm.setInt(2, dsv.getTinHoc());
            psm.setInt(3, dsv.getGiaoDucTC());
            psm.setString(4, dsv.getSinhVien().getMaSV());
            int row = psm.executeUpdate();
            return  row;
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
   
        return -1;
    }
    
    public int delete(DiemSinhVien dsv){
        String sql = "delete GRADE where MaSV = ?";
        try {
            conn = DBcontext.getConnection();
            psm = conn.prepareStatement(sql);
            
            psm.setString(1, dsv.getSinhVien().getMaSV());
            int row = psm.executeUpdate();
            return  row;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        return -1;
    }
    
          
}
