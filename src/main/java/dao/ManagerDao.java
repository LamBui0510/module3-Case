package dao;

import config.ConnectionJDBC;
import model.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao {
    Connection connection = ConnectionJDBC.getConnection();

    public List<Manager> getListManager() {
        String showManager = "select manager.*,role.name from manager join role on manager.id_role = role.id";
        List<Manager> managerList = new ArrayList<>();
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(showManager)) {
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                int id = rs.getInt("id");
                String user_name = rs.getString("user_name");
                String passwords = rs.getString("passwords");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String img = rs.getString("img");
                double salary = rs.getDouble("salary");
                double coefficients_salary = rs.getDouble("coefficients_salary");
                String status = rs.getString("status");
                Date create_date = rs.getDate("create_date");
                Date modify_date = rs.getDate("modify_date");
                String name_role = rs.getString("name");
                managerList.add(new Manager(id, user_name, passwords,full_name, email, phone, address, img, salary, coefficients_salary, status, create_date, modify_date, name_role));

            }
            return managerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public void createManagerDao(Manager manager) {
        String saveManager = "INSERT INTO manager (full_name,passwords,email,phone,address,id_role,img,salary,coefficients_salary,status,create_date,modify_date) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveManager);
            preparedStatement.setString(1, manager.getUser_name());
            preparedStatement.setString(2, manager.getPasswords());
            preparedStatement.setString(3, manager.getEmail());
            preparedStatement.setString(4, manager.getPhone());
            preparedStatement.setString(5, manager.getAddress());
            preparedStatement.setInt(6, manager.getId_role());
            preparedStatement.setString(7, manager.getImg());
            preparedStatement.setDouble(8, manager.getSalary());
            preparedStatement.setString(9, manager.getStatus());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteManagerDao(int id) {
        String deleteSQL = "DELETE  from manager where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateManager(int id, Manager manager) {
        String editManager = "update manager set full_name = ? ,passwords = ? ,email = ?,phone = ?,address = ? ,id_role = ?,img = ? ,salary = ?,coefficients_salary = ? where id = ?";

        try (
             PreparedStatement statement = connection.prepareStatement(editManager)) {
            statement.setString(1, manager.getUser_name());
            statement.setString(2, manager.getPasswords());
            statement.setString(3, manager.getEmail());
            statement.setString(4, manager.getPhone());
            statement.setString(5, manager.getAddress());
            statement.setInt(6, manager.getId_role());
            statement.setString(7, manager.getImg());
            statement.setDouble(8, manager.getSalary());
            statement.setDouble(9, manager.getCoefficients_salary());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Manager> searchByName(String findname) {
        String getall = "select manager.* from manager" +
                "  where manager.full_name like '%" + findname + "%\'";


        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(getall);
            List<Manager> managerList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String user_name = rs.getString("user_name");
                String passwords = rs.getString("passwords");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String img = rs.getString("img");
                double salary = rs.getDouble("salary");
                double coefficients_salary = rs.getDouble("coefficients_salary");
                String status = rs.getString("status");
                Date create_date = Date.valueOf(rs.getString("create_date"));
                Date modify_date = Date.valueOf(rs.getString("modify_date"));
                String name_role = rs.getString("name");
                managerList.add(new Manager(id, user_name, passwords,full_name, email, phone, address, img, salary, coefficients_salary,status, create_date, modify_date, name_role));

            }
            return managerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
