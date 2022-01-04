package model;

import java.sql.Date;

public class Customer {
    private int id;
    private int id_role;
    private String name_role;
    private String full_name;
    private String passwords;
    private String email;
    private String phone;
    private String address;
    private String img;
    private Date create_date;
    private Date modify_date;
    private String status;


    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer() {
    }

    public Customer(int id, int id_role, String name_role, String full_name, String passwords, String email, String phone, String address, String img, Date create_date, Date modify_date, String status) {
        this.id = id;
        this.id_role = id_role;
        this.name_role = name_role;
        this.full_name = full_name;
        this.passwords = passwords;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.img = img;
        this.create_date = create_date;
        this.modify_date = modify_date;
        this.status = status;
    }

    public Customer(int id_role, String name_role, String full_name, String passwords, String email, String phone, String address, String img, String status) {
        this.id_role = id_role;
        this.name_role = name_role;
        this.full_name = full_name;
        this.passwords = passwords;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.img = img;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPassword(String passwords) {
        this.passwords = passwords;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public String getName_role() {
        return name_role;
    }

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }
}
