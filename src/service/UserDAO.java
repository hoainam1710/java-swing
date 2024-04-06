/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import database.DBcontext;
import java.util.ArrayList;
import java.util.List;
import model.Users;

import java.sql.*;
public class UserDAO {
    Connection conn = null;
    Statement stm = null;
    PreparedStatement psm = null;
    ResultSet rs = null;
    
    ArrayList<Users> listUsers = new ArrayList<>();
    

    public UserDAO() {
        // role = true: giảng viên
        // role = false : cán bộ
//        listUsers.add(new Users("giangvien", "123", true));
//        listUsers.add(new Users("admin", "123", true));
//        listUsers.add(new Users("hai", "234", true));
//        listUsers.add(new Users("the", "1234", true));
//        
//        listUsers.add(new Users("canbo", "123", false));
//        listUsers.add(new Users("admin2", "234", false));
//        listUsers.add(new Users("nam", "123", false));
//        listUsers.add(new Users("kien", "112", false));

        
    }
    public ArrayList<Users> getAllUsers(){
          String sql = "select * from USERS";
          try {
            conn = DBcontext.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Users users = new Users();
                users.setUserName(rs.getString(1));
                users.setPassWord(rs.getString(2));
                users.setRole(rs.getBoolean(3));
                listUsers.add(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listUsers;
    }
    
    public int checkUser(String userName, String passWord){
        for(Users u: getAllUsers()){
            if(u.getUserName().equals(userName) && u.getPassWord().equals(passWord) && u.getRole()){
                return 1;
            }
            if(u.getUserName().equals(userName) && u.getPassWord().equals(passWord) && !u.getRole()){
                return 2;
            }
        }
        return -1;
               
    }
    
    
    
}
