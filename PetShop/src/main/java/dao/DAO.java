/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
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
    
    public void insertProduct(String ProName, String ProCategory, String ProPrice, String ProAmount, String ProImg) {
        String query = "insert into petshop.product(ProName, ProCategory, ProPrice, ProAmount, ProImg) values (?, ?, ?, ?, ?)";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            
            System.out.print("Enter name: ");
            ProName = scanner.nextLine();
            System.out.print("Enter Category: ");
            ProCategory = scanner.nextLine();
            System.out.print("Enter price: ");
            ProPrice = scanner.nextLine();
            System.out.print("Enter amount: ");
            ProAmount = scanner.nextLine();
            ps = conn.prepareStatement(query);
            ps.setString(1, ProName);
            ps.setString(2, ProCategory);
            ps.setString(3, ProPrice);
            ps.setString(4, ProAmount);
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

    public void updateProduct(String ProId, String ProName, String ProCategory, String ProPrice, String ProAmount, String ProImg) {
        String query = "update petshop.product\n" +
                        "set ProName = ?, ProCategory = ?, ProPrice = ?, ProAmount = ?, ProImg = ?\n" +
                        "where ProId = ?";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            System.out.print("Enter ID to update: ");
            ProId = scanner.nextLine();
            System.out.print("Enter name: ");
            ProName = scanner.nextLine();
            System.out.print("Enter Category: ");
            ProCategory = scanner.nextLine();
            System.out.print("Enter price: ");
            ProPrice = scanner.nextLine();
            System.out.print("Enter amount: ");
            ProAmount = scanner.nextLine();
            ps = conn.prepareStatement(query);
            ps.setString(1, ProName);
            ps.setString(2, ProCategory);
            ps.setString(3, ProPrice);
            ps.setString(4, ProAmount);
            ps.setString(5, ProImg);
            ps.setString(6, ProId);
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
        //dao.insertProduct("", "", "", "", ""); Work 
        //dao.deleteProduct(""); Work
        //dao.updateProduct("", "", "", "", "", ""); Work
    }
}
