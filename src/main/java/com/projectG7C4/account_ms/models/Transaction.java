package com.projectG7C4.account_ms.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Transaction {
    @Id
    private String id;
    private String usernameDestiny;
    private Integer value;
    private Date date;

    public Transaction(String usernameDestiny, Integer value, Date date) {
        this.usernameDestiny = usernameDestiny;
        this.value = value;
        this.date = date;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUsernameDestiny() {
        return usernameDestiny;
    }
    public void setUsernameDestiny(String usernameDestiny) {
        this.usernameDestiny = usernameDestiny;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    
    


    
}
