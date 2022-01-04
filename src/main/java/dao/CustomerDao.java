package dao;

import config.ConnectionJDBC;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements IDao<Customer>{
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Customer> getList() {
        String ShowCustomer = "select customer.*,role.name from customer join role on customer.id_role = role.id";
        List<Customer> customerList = new ArrayList<>();
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(ShowCustomer)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_role = rs.getInt("id_role");
                String name_role = rs.getString("name");
                String full_name = rs.getString("full_name");
                String passwords = rs.getString("passwords");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String img = rs.getString("img");
                Date create_date = rs.getDate("create_date");
                Date modify_date = rs.getDate("modify_date");
                String status = rs.getString("status");
                customerList.add(new Customer( id,  id_role,  name_role,  full_name,  passwords,  email,  phone,  address,  img,  create_date,  modify_date,  status));

            }
            return customerList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void insert(Customer customer) {
        String insertCustomer = "INSERT INTO customer (full_name,passwords,email,phone,address,id_role,img) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertCustomer);
            preparedStatement.setString(1, customer.getFull_name());
            preparedStatement.setString(2, customer.getPasswords());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6, customer.getId_role());
            preparedStatement.setString(7, customer.getImg());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        String deleteSQL = "DELETE  from customer where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(int id, Customer customer) {
        String editCustomer = "update customer set full_name = ? ,passwords = ? ,email = ?,phone = ?,address = ? ,id_role = ?,img = ? ,status = ? where id = ?";

        try (
             PreparedStatement statement = connection.prepareStatement(editCustomer)) {
            statement.setString(1, customer.getFull_name());
            statement.setString(2, customer.getPasswords());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getAddress());
            statement.setInt(6, customer.getId_role());
            statement.setString(7, customer.getImg());
            statement.setString(8,customer.getStatus());
            statement.setInt(9,id);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Customer> searchByName(String findname) {
        String getall = "select customer.*,role.name from customer join role on customer.id_role = role.id where customer.full_name like '%" + findname + "%\'";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(getall);
            List<Customer> customerList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_role = rs.getInt("id_role");
                String name_role = rs.getString("name");
                String full_name = rs.getString("full_name");
                String passwords = rs.getString("passwords");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String img = rs.getString("img");
                Date create_date = rs.getDate("create_date");
                Date modify_date = rs.getDate("modify_date");
                String status = rs.getString("status");
                customerList.add(new Customer( id,  id_role,  name_role,  full_name,  passwords,  email,  phone,  address,  img,  create_date,  modify_date,  status));
            }
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
