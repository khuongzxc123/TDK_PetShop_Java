/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Product {
    private int ProId;
    private String ProName;
    private String ProCategory;
    private double ProPrice;
    private int ProAmount;
    private String ProImg;

    public Product(int ProId, String ProName, String ProCategory, double ProPrice, int ProAmount, String ProImg) {
        this.ProId = ProId;
        this.ProName = ProName;
        this.ProCategory = ProCategory;
        this.ProPrice = ProPrice;
        this.ProAmount = ProAmount;
        this.ProImg = ProImg;
    }

    public int getProId() {
        return ProId;
    }

    public void setProId(int ProId) {
        this.ProId = ProId;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String ProName) {
        this.ProName = ProName;
    }

    public double getProPrice() {
        return ProPrice;
    }

    public void setProPrice(double ProPrice) {
        this.ProPrice = ProPrice;
    }

    public int getProAmount() {
        return ProAmount;
    }

    public void setProAmount(int ProAmount) {
        this.ProAmount = ProAmount;
    }

    public String getProImg() {
        return ProImg;
    }

    public void setProImg(String ProImg) {
        this.ProImg = ProImg;
    }

    public String getProCategory() {
        return ProCategory;
    }

    public void setProCategory(String ProCategory) {
        this.ProCategory = ProCategory;
    }

    @Override
    public String toString() {
        return "Product{" + "ProId=" + ProId + ", ProName=" + ProName + ", ProCategory=" + ProCategory + ", ProPrice=" + ProPrice + ", ProAmount=" + ProAmount + ", ProImg=" + ProImg + '}';
    }

}
