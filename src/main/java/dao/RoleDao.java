package dao;

import config.ConnectionJDBC;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {

    public List<Role> getRoleList() {
        String getRole = "select * from Role";
        Connection connection = ConnectionJDBC.getConnection();
        List<Role> roleList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getRole);
            ResultSet resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                String code = resultset.getString("code");
                roleList.add(new Role(id, name, code));
            }
            return roleList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
