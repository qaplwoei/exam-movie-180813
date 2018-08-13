package com.hand.movie.entity;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class User {
    private int customer_id;
    private int store_id;
    private  String first_name;
    private String last_name;
    private String email;
    private int address_id;
    private int active;
    private Timestamp create_date;
    private Timestamp last_update;

    public User(ResultSet rs) throws SQLException {
        customer_id=rs.getInt("customer_id");
        store_id=rs.getInt("store_id");
        address_id=rs.getInt("address_id");
        active=rs.getInt("active");
        first_name=rs.getString("first_name");
        last_name=rs.getString("last_name");
        email=rs.getString("email");
        create_date=rs.getTimestamp("create_date");
        last_update=rs.getTimestamp("last_update");
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
}
