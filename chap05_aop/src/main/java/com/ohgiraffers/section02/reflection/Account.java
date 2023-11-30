package com.ohgiraffers.section02.reflection;

public class Account {

    private String backCode;
    private String accNO;
    private String accPwd;
    private int balance;

    public Account() {
    }

    public Account(String backCode, String accNO, String accPwd, int balance) {
        this.backCode = backCode;
        this.accNO = accNO;
        this.accPwd = accPwd;
        this.balance = balance;
    }

    public String getBackCode() {
        return backCode;
    }

    public void setBackCode(String backCode) {
        this.backCode = backCode;
    }

    public String getAccNO() {
        return accNO;
    }

    public void setAccNO(String accNO) {
        this.accNO = accNO;
    }

    public String getAccPwd() {
        return accPwd;
    }

    public void setAccPwd(String accPwd) {
        this.accPwd = accPwd;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "backCode='" + backCode + '\'' +
                ", accNO='" + accNO + '\'' +
                ", accPwd='" + accPwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
