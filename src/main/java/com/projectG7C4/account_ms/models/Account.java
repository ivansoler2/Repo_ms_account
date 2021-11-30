package com.projectG7C4.account_ms.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Account {

    @Id
    private String username;
    private Integer balance;
    private Date lastChange;
    private String product;


    public Account(String username, Integer balance, Date lastChange, String product) {
        this.username = username;
        this.balance = balance;
        this.lastChange = lastChange;
        this.product = product;
    }
    

    public String getProduct() {
        return product;
    }


    public void setProduct(String product) {
        this.product = product;
    }


    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
    
    
}
