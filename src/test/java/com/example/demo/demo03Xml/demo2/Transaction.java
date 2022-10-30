package com.example.demo.demo03Xml.demo2;

import java.util.Date;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Transaction {
    private String type = null;
    private Date date = null;

    public Transaction() {
    }

    public Transaction(String type, Date date) {
        this.type = type;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
