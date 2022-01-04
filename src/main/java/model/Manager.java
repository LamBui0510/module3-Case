package model;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Manager {
    private int id;
    private int id_role;
    private String user_name;
    private String passwords;
    private String full_name;
    private String email;
    private String phone;
    private String address;
    private String img;
    private double salary;
    private double coefficients_salary;
    private String status;
    private Date create_date;
    private Date modify_date;
    private String name_role;

    public Manager( int id_role, String user_name, String passwords, String full_name, String email, String phone, String address, String img, double salary, double coefficients_salary, String status, Date create_date, Date modify_date, String name_role) {
        this.id_role = id_role;
        this.user_name = user_name;
        this.passwords = passwords;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.img = img;
        this.salary = salary;
        this.coefficients_salary = coefficients_salary;
        this.status = status;
        this.create_date = create_date;
        this.modify_date = modify_date;
        this.name_role = name_role;
    }


    public Manager(int id_role, String user_name, String passwords, String email, String phone, String address, String img, Double salary, Double coefficients_salary, String status, Date create_date, Date modify_date) {
        this.id_role = id_role;
        this.user_name = user_name;
        this.passwords = passwords;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.img = img;
        this.salary = salary;
        this.coefficients_salary = coefficients_salary;
        this.status = status;
        this.create_date = create_date;
        this.modify_date = modify_date;
    }

    public Manager(int id, int id_role, String user_name, String passwords, String email, String phone, String address, String img, Double salary, Double coefficients_salary, String status, Date create_date, Date modify_date) {
        this.id = id;
        this.id_role = id_role;
        this.user_name = user_name;
        this.passwords = passwords;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.img = img;
        this.salary = salary;
        this.coefficients_salary = coefficients_salary;
        this.status = status;
        this.create_date = create_date;
        this.modify_date = modify_date;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCoefficients_salary() {
        return coefficients_salary;
    }

    public void setCoefficients_salary(double coefficients_salary) {
        this.coefficients_salary = coefficients_salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
