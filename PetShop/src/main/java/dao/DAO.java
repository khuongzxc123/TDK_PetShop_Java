/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    //PRODUCT
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM petshop.product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
               list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6)));
            }
        }catch (Exception e){}
        return list;
    }
    
    public void insertProduct(String ProName, Integer ProCategory, Double ProPrice, Integer ProAmount, String ProImg) {
        String query = "insert into petshop.product(ProName, ProCategory, ProPrice, ProAmount, ProImg) values (?, ?, ?, ?, ?)";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            
            System.out.print("Enter name: ");
            ProName = scanner.nextLine();
            System.out.print("Enter Category: ");
            ProCategory = scanner.nextInt();
            System.out.print("Enter price: ");
            ProPrice = scanner.nextDouble();
            System.out.print("Enter amount: ");
            ProAmount = scanner.nextInt();
            ps = conn.prepareStatement(query);
            ps.setString(1, ProName);
            ps.setInt(2, ProCategory);
            ps.setDouble(3, ProPrice);
            ps.setInt(4, ProAmount);
            ps.setString(5, ProImg);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteProduct(String ProId) {
        String query = "delete from petshop.product\n"
                + "where ProId = ?";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            System.out.print("Enter ID to delete: ");
            ProId = scanner.nextLine();
            ps = conn.prepareStatement(query);
            ps.setString(1, ProId);
            ps.executeUpdate();
        } catch (Exception e) {}
    }

    public void updateProduct(Integer ProId, String ProName, Integer ProCategory, Double ProPrice, Integer ProAmount, String ProImg) {
        String query = "update petshop.product\n" +
                        "set ProName = ?, ProCategory = ?, ProPrice = ?, ProAmount = ?, ProImg = ?\n" +
                        "where ProId = ?";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            System.out.print("Enter name: ");
            ProName = scanner.nextLine();
            System.out.print("Enter Category: ");
            ProCategory = scanner.nextInt();
            System.out.print("Enter price: ");
            ProPrice = scanner.nextDouble();
            System.out.print("Enter amount: ");
            ProAmount = scanner.nextInt();
            System.out.print("Enter ID to update: ");
            ProId = scanner.nextInt();
            ps = conn.prepareStatement(query);
            ps.setString(1, ProName);
            ps.setInt(2, ProCategory);
            ps.setDouble(3, ProPrice);
            ps.setInt(4, ProAmount);
            ps.setString(5, ProImg);
            ps.setInt(6, ProId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    //
    //Account
    
    public List<Account> getEmploy(){
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM petshop.account WHERE RoleId = '2'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
               list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        }catch (Exception e){}
        return list;
    }
    
    public List<Account> getUser(){
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM petshop.account WHERE RoleId = '3'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
               list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        }catch (Exception e){}
        return list;
    }
    //User Dang ky tai khoan
    public void signupUser(String UserName, String Pass, String AccountName) {
        String query = "insert into petshop.account(UserName, Pass, AccountName) values (?, ?, ?)";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            
            System.out.print("Enter Username: ");
            UserName = scanner.nextLine();
            System.out.print("Enter Pass: ");
            Pass = scanner.nextLine();
            System.out.print("Enter Name: ");
            AccountName = scanner.nextLine();
            ps = conn.prepareStatement(query);
            ps.setString(1, UserName);
            ps.setString(2, Pass);
            ps.setString(3, AccountName);
            ps.executeUpdate();
        } catch (Exception e) {}
    }
    
    public Account loginUser(String UserName, String Pass){
        String query = "SELECT * FROM petshop.account WHERE UserName = ?  AND Pass = ?";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();
            System.out.print("Enter Username: ");
            UserName = scanner.nextLine();
            System.out.print("Enter Pass: ");
            Pass = scanner.nextLine();
            ps = conn.prepareStatement(query);
            ps.setString(1, UserName);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if(!(rs.next())){
                System.out.println("Something Wrong.");
            }
            while(rs.next()){
               return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        }catch (Exception e){}
        return null;
    }
    
    public void insertEmploy(String UserName, String Pass, String AccountName, Integer RoleId) {
        String query = "insert into petshop.account(UserName, Pass, AccountName, RoleId) values (?, ?, ?, 2)";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            
            System.out.print("Enter Username: ");
            UserName = scanner.nextLine();
            System.out.print("Enter Pass: ");
            Pass = scanner.nextLine();
            System.out.print("Enter Name: ");
            AccountName = scanner.nextLine();
            ps = conn.prepareStatement(query);
            ps.setString(1, UserName);
            ps.setString(2, Pass);
            ps.setString(3, AccountName);
            ps.executeUpdate();
        } catch (Exception e) {}
    }
    
    public void updateProfile(String Pass, String AccountName, Integer UserId) {
        String query = "update petshop.account\n" +
                        "set Pass = ?, AccountName = ?\n" +
                        "where UserId = ?";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            System.out.print("Enter Pass: ");
            Pass = scanner.nextLine();
            System.out.print("Enter Name: ");
            AccountName = scanner.nextLine();
            System.out.print("Enter ID to update: ");
            UserId = scanner.nextInt();
            ps = conn.prepareStatement(query);
            ps.setString(1, Pass);
            ps.setString(2, AccountName);
            ps.setInt(3, UserId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM petshop.category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
               list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        }catch (Exception e){}
        return list;
    }
    
    public static void main(String[] args){
        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        for(Product p : list){
            System.out.println(p);
        } //Work
        List<Category> listC = dao.getAllCategory();
        for(Category c : listC){
            System.out.println(c);
        } //Work
        List<Account> listA = dao.getUser();
        for(Account a : listA){
            System.out.println(a);
        }
        List<Account> listE = dao.getEmploy();
        for(Account e : listE){
            System.out.println(e);
        }
//        dao.updateProfile("", "", Integer.SIZE); //Work
//        dao.insertProduct("", Integer.BYTES, Double.NaN, Integer.MIN_VALUE, ""); //Work 
//        dao.deleteProduct(""); //Work
          dao.updateProduct(Integer.SIZE, "", Integer.BYTES, Double.NaN, Integer.MIN_VALUE, "");
    }
}
