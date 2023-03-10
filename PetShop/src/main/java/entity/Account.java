/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Account {
    private int UserId;
    private String UserName;
    private String Pass;
    private String AccountName;
    private int RoleId;

    public Account(int UserId, String UserName, String Pass, String AccountName, int RoleId) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.Pass = Pass;
        this.AccountName = AccountName;
        this.RoleId = RoleId;
    }

    
    
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
    }

    @Override
    public String toString() {
        return "Account{" + "UserId=" + UserId + ", UserName=" + UserName + ", Pass=" + Pass + ", AccountName=" + AccountName + ", RoleId=" + RoleId + '}';
    }

    
}
