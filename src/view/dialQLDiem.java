/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import database.DBcontext;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JOptionPane;
import model.DiemSinhVien;
import model.SinhVien;
import service.DiemSinhVienDAO;


public class dialQLDiem extends javax.swing.JDialog {

    Connection conn = null;
    Statement stm = null;
    PreparedStatement psm = null;
    ResultSet rs = null;
    DefaultTableModel modelDiemSV;
    DiemSinhVien diemSinhVien = new DiemSinhVien();
    DiemSinhVienDAO diemSinhVienDAO = new DiemSinhVienDAO();
    
    int index = 0;
    
    public dialQLDiem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        fillToTable();
        loadToForm(0);
           
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSvSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        btnTruoc = new javax.swing.JButton();
        btnSau = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtTiengAnh = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        txtGiaoDuc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblĐiemTB = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDiemSV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Quản Lý Điểm Sinh Viên");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã SV:");

        txtMaSvSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaSvSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaSvSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSvSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnSearch))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnStart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnStart.setText("|<");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnTruoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTruoc.setText("<<");
        btnTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocActionPerformed(evt);
            }
        });

        btnSau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSau.setText(">>");
        btnSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 153));
        jLabel10.setText("3 sinh viên có điểm cao nhất:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Họ tên SV:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã SV:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tiếng Anh:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tin học:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giao dục TC:");

        txtMaSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaSV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTiengAnh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTiengAnh.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTinHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTinHoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGiaoDuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaoDuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Điểm TB:");

        lblĐiemTB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblĐiemTB.setForeground(new java.awt.Color(0, 0, 153));
        lblĐiemTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblHoTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7)))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblĐiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 172, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblĐiemTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(89, 89, 89))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtGiaoDuc, txtMaSV, txtTiengAnh, txtTinHoc});

        btnNew.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        tblDiemSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDiemSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemSVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDiemSV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnUpdate))
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSau, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 104, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addGap(26, 26, 26)
                        .addComponent(btnSave)
                        .addGap(29, 29, 29)
                        .addComponent(btnDelete)
                        .addGap(32, 32, 32)
                        .addComponent(btnUpdate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnStart)
                        .addComponent(btnSau)
                        .addComponent(btnLast))
                    .addComponent(btnTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(565, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLast, btnSau, btnStart, btnTruoc});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauActionPerformed

        for(int i = 0; i< getAllSV().size(); i++){
            if(getAllSV().get(i).getMaSV().equalsIgnoreCase(txtMaSV.getText())){
                index = i;
                break;
            }
        }
        int a = getAllSV().size()-1;
        if(index == a){
            JOptionPane.showMessageDialog(this, "Ban đang ở cuối danh sách!");
            return;
        }
        index ++;
        loadToForm(index);     
        
    }//GEN-LAST:event_btnSauActionPerformed

    public boolean checkMaSVSearch(String maSVSearch){
        String sql = "select MaSV from STUDENTS";
        try {
            conn = DBcontext.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(1).equalsIgnoreCase(maSVSearch)){
                    return true;
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return  false;
        
    }
    
    public String getHoTenByMaSV(String maSV){
        String hoTen = null;
        String sql = "select HoTen from STUDENTS where MaSV = ?";
        try {
            conn = DBcontext.getConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, maSV);
            rs = psm.executeQuery();
            while(rs.next()){
                hoTen = rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoTen;   
    }
    
    public SinhVien getSinhVienByMaSVSearch(String maSV){
        String sql = "select * from STUDENTS where MaSV = ?";
        SinhVien sv = null;
        try {
            conn = DBcontext.getConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, maSV);
            rs = psm.executeQuery();
            while(rs.next()){
                sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setHoTen(rs.getString(2));
                sv.setEmail(rs.getString(3));
                sv.setSoDT(rs.getString(4));
                sv.setGioiTinh(rs.getBoolean(5));
                sv.setDiaChi(rs.getString(6));
                sv.setHinh(rs.getString(7));
                  
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return sv;
        
    }
    
    public DiemSinhVien getdDiemSinhVienBySinhVien(SinhVien sv){
        DiemSinhVien dsv = null;
        String sql = "select * from GRADE where MaSV = ?";
        try {
             conn = DBcontext.getConnection();
             psm = conn.prepareStatement(sql);
             psm.setString(1, sv.getMaSV());
             rs = psm.executeQuery();
             while(rs.next()){
                 dsv = new DiemSinhVien();
                 dsv.setSinhVien(sv);
                 dsv.setTiengAnh(rs.getInt(2));
                 dsv.setTinHoc(rs.getInt(3));
                 dsv.setGiaoDucTC(rs.getInt(4));
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsv;
           
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if(txtMaSvSearch.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua diền mã sinh viên tìm kiếm");
            return;
        }
        if(!checkMaSVSearch(txtMaSvSearch.getText())){
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên có MaSV theo yêu cầu!");
            return;
        }
        SinhVien sv = getSinhVienByMaSVSearch(txtMaSvSearch.getText());
        DiemSinhVien dsv = getdDiemSinhVienBySinhVien(sv);
        lblHoTen.setText(sv.getHoTen());
        lblHoTen.setEnabled(false);
        txtMaSV.setText(sv.getMaSV());
        txtMaSV.setEditable(false);
        if(dsv != null){
            txtTiengAnh.setText(dsv.getTiengAnh()+"");
            txtTinHoc.setText(dsv.getTinHoc()+"");
            txtGiaoDuc.setText(dsv.getGiaoDucTC()+"");
            lblĐiemTB.setText(dsv.getDiemTB(dsv.getTiengAnh(), dsv.getTinHoc(), dsv.getGiaoDucTC())+"");
        }else {
            txtTiengAnh.setText("");
            txtTinHoc.setText("");
            txtGiaoDuc.setText("");
            lblĐiemTB.setText("");
            
        }
          
    }//GEN-LAST:event_btnSearchActionPerformed

    
    public void clearForm(){
        txtMaSvSearch.setText(null);
        txtMaSV.setText(null);
        txtTiengAnh.setText(null);
        txtTinHoc.setText(null);
        txtGiaoDuc.setText(null);
        lblHoTen.setText(null);
        lblĐiemTB.setText(null);
        
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    public boolean checkFormEmpty(){
        if(txtTiengAnh.getText().isEmpty() 
                || txtTinHoc.getText().isEmpty() || txtGiaoDuc.getText().isEmpty()){
            return  false;
        }
        return true;
    }
    
    public boolean checkDiem(){
        try {
            if(Integer.parseInt(txtTiengAnh.getText()) < 0 || Integer.parseInt(txtTiengAnh.getText()) > 10){
                JOptionPane.showMessageDialog(this, "Diem tieng anh phải nằm trong đoạn [0, 10]!");
                return false;  
            } 
            if(Integer.parseInt(txtTinHoc.getText()) < 0 || Integer.parseInt(txtTinHoc.getText()) > 10){
                JOptionPane.showMessageDialog(this, "Diem tin học phải nằm trong đoạn [0, 10]!");
                return false;  
            } 
            if(Integer.parseInt(txtGiaoDuc.getText()) < 0 || Integer.parseInt(txtGiaoDuc.getText()) > 10){
                JOptionPane.showMessageDialog(this, "Diem GDTC phải nằm trong đoạn [0, 10]!");
                return false;  
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập điểm là số!");
            return false;
        }
         
        return true;
        
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if(!checkFormEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đầy đủ thông tin!");
            return;
        }
        if(!checkDiem()){
            return;   
        }
        
        DiemSinhVien dsv = getDiemSinhVienByForm();
        
        if(diemSinhVienDAO.save(dsv) > 0){
            JOptionPane.showMessageDialog(this, "Save thành công!");
               fillToTable();
        } else JOptionPane.showMessageDialog(this, "Save thất bại!");
        
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không ?");
        if(hoi != JOptionPane.YES_OPTION){
            return;
        }
        if(!checkFormEmpty()){
            JOptionPane.showMessageDialog(this, "Sinh viên chưa có diểm!");
            return;
        }
        
        DiemSinhVien dsv = getDiemSinhVienByForm();
        
        if(diemSinhVienDAO.delete(dsv) > 0){
            
            JOptionPane.showMessageDialog(this, "Delete thành công!");
            fillToTable();
            loadToForm(0);
            
        } else JOptionPane.showMessageDialog(this, "Delete thất bại!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(!checkFormEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đầy đủ thông tin!");
            return;
        }
        if(!checkDiem()){
            return;   
        }
        
        DiemSinhVien dsv = getDiemSinhVienByForm();
        
        if(diemSinhVienDAO.update(dsv) > 0){
            JOptionPane.showMessageDialog(this, "Update thành công!");
            fillToTable();
            lblĐiemTB.setText(dsv.getDiemTB(dsv.getTiengAnh(), dsv.getTinHoc(), dsv.getGiaoDucTC())+"");
        } else JOptionPane.showMessageDialog(this, "Update thất bại!");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        
        loadToForm(0);  
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

           loadToForm(getAllSV().size()-1);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocActionPerformed
        index =  0;
        for(int i = 0; i< getAllSV().size(); i++){
            if(getAllSV().get(i).getMaSV().equalsIgnoreCase(txtMaSV.getText())){
                index = i;
                break;
            }
        }
        if(index == 0){
            JOptionPane.showMessageDialog(this, "Ban đang ở đầu danh sách!");
            return;
        }
        index--;
        loadToForm(index);
             
    }//GEN-LAST:event_btnTruocActionPerformed

    private void tblDiemSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemSVMouseClicked
        int indexRow = tblDiemSV.getSelectedRow();
        txtMaSV.setText(tblDiemSV.getValueAt(indexRow, 0)+"");
        lblHoTen.setText(tblDiemSV.getValueAt(indexRow, 1)+"");
        txtTiengAnh.setText(tblDiemSV.getValueAt(indexRow, 2)+"");
        txtTinHoc.setText(tblDiemSV.getValueAt(indexRow, 3)+"");
        txtGiaoDuc.setText(tblDiemSV.getValueAt(indexRow, 4)+"");
        lblĐiemTB.setText(tblDiemSV.getValueAt(indexRow, 5)+"");
    }//GEN-LAST:event_tblDiemSVMouseClicked

    // lấy đối tượng DiemSinhVien từ form 
    public DiemSinhVien getDiemSinhVienByForm(){       
        DiemSinhVien dsv = new DiemSinhVien();
        
        dsv.setSinhVien(getSinhVienByMaSVSearch(txtMaSV.getText()));
        dsv.setTiengAnh(Integer.parseInt(txtTiengAnh.getText()));
        dsv.setTinHoc(Integer.parseInt(txtTinHoc.getText()));
        dsv.setGiaoDucTC(Integer.parseInt(txtGiaoDuc.getText()));
        
        return dsv;

    }
    
    public ArrayList<SinhVien> getAllSV(){
        SinhVien sv = null;
        ArrayList<SinhVien> listSV = new ArrayList<>();
        String sql = "select * from STUDENTS";
        try {
            conn = DBcontext.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setHoTen(rs.getString(2));
                sv.setEmail(rs.getString(3));
                sv.setSoDT(rs.getString(4));
                sv.setGioiTinh(rs.getBoolean(5));
                sv.setDiaChi(rs.getString(6));
                sv.setHinh(rs.getString(7));
                
                listSV.add(sv);   
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSV;
    }
    
   
    public void fillToTable(){
        String[] header = {"MaSV","HoTen", "Tieng anh", "Tin hoc", "GDTC", "Diem TB"};
        modelDiemSV = new DefaultTableModel(header, 0);
        String sql = "SELECT GRADE.MaSV, STUDENTS.HoTen, GRADE.TiengAnh, GRADE.TinHoc, GRADE.GDTC, (GRADE.TiengAnh+GRADE.TinHoc+GRADE.GDTC) \n"
                + "FROM DBO.GRADE INNER JOIN DBO.STUDENTS ON DBO.GRADE.MaSV = DBO.STUDENTS.MaSV\n"
                + "ORDER BY (GRADE.TiengAnh+GRADE.TinHoc+GRADE.GDTC) DESC";
        try {
            conn = DBcontext.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            int i = 0;
            while(rs.next()){
                modelDiemSV.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                    (float)(rs.getInt(6))/3 
                });
                i++;
                if(i == 3) break;
            }
            tblDiemSV.setModel(modelDiemSV);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // hiển thị sinh viên thứ i lên form
    public void loadToForm(int i){
        SinhVien sv = getAllSV().get(i);
        DiemSinhVien dsv = getdDiemSinhVienBySinhVien(sv);
        lblHoTen.setText(sv.getHoTen());
        txtMaSV.setText(sv.getMaSV());
        if(dsv != null){
            txtTiengAnh.setText(dsv.getTiengAnh()+"");
            txtTinHoc.setText(dsv.getTinHoc()+"");
            txtGiaoDuc.setText(dsv.getGiaoDucTC()+"");
            lblĐiemTB.setText(dsv.getDiemTB(dsv.getTiengAnh(), dsv.getTinHoc(), dsv.getGiaoDucTC())+"");
        } else {
            txtTiengAnh.setText("");
            txtTinHoc.setText("");
            txtGiaoDuc.setText("");
            lblĐiemTB.setText("");
            
        }
    }
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dialQLDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialQLDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialQLDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialQLDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialQLDiem dialog = new dialQLDiem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSau;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnTruoc;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblĐiemTB;
    private javax.swing.JTable tblDiemSV;
    private javax.swing.JTextField txtGiaoDuc;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtMaSvSearch;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables
}
