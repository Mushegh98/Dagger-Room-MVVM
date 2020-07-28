package com.test.myapplication.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.test.myapplication.data.DataConverter;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "username")
    private String username;
    @ColumnInfo(name = "email")
    private String email;
    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "address")
    private Address address;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "website")
    private String website;
    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "company")
    private Company company;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }

    @Ignore
    public User(Address address, Company company, String email, int id, String name, String phone, String username, String website) {
        this.address = address;
        this.company = company;
        this.email = email;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.website = website;
    }
    public User(){}
}
