package com.chiyume.dao;

import com.chiyume.pojo.User;
import com.chiyume.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public User getUserByName(String name){
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from sysuser where username = ?";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("userid");
                int roleId = resultSet.getInt("roleid");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("userpwd");
                String trueName = resultSet.getString("usertruename");
                String gender = resultSet.getString("usersex");
                String phone = resultSet.getString("userphone");
                String address = resultSet.getString("useraddr");
                String identity = resultSet.getString("useridentity");
                int status = resultSet.getInt("userstate");
                User user = new User(id, roleId, userName, password, trueName, gender, phone, address, identity, status);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }
        return null;
    }
    public User getUserById(int id){
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from sysuser where userid = ?";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int ids = resultSet.getInt("userid");
                int roleId = resultSet.getInt("roleid");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("userpwd");
                String trueName = resultSet.getString("usertruename");
                String gender = resultSet.getString("usersex");
                String phone = resultSet.getString("userphone");
                String address = resultSet.getString("useraddr");
                String identity = resultSet.getString("useridentity");
                int status = resultSet.getInt("userstate");
                User user = new User(ids, roleId, userName, password, trueName, gender, phone, address, identity, status);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }
        return null;
    }
    public List<User> getAllUser(){
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from sysuser";
        List<User> userList = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("userid");
                int roleId = resultSet.getInt("roleid");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("userpwd");
                String trueName = resultSet.getString("usertruename");
                String gender = resultSet.getString("usersex");
                String phone = resultSet.getString("userphone");
                String address = resultSet.getString("useraddr");
                String identity = resultSet.getString("useridentity");
                int status = resultSet.getInt("userstate");
                User user = new User(id, roleId, userName, password, trueName, gender, phone, address, identity, status);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }
        return null;
    }
    public int addUser(User user){
//        获取插入数据
        int id = user.getId();
        int roleId = user.getRoleId();
        String userName = user.getUserName();
        String password = user.getPassword();
        String trueName = user.getTrueName();
        String gender = user.getGender();
        String phone = user.getPhone();
        String address = user.getAddress();
        String identity = user.getIdentity();
        int status = user.getStatus();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into sysuser values(?,?,?,?,?,?,?,?,?,?)";
        try {

            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, roleId);
            preparedStatement.setString(3,userName);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,trueName);
            preparedStatement.setString(6,gender);
            preparedStatement.setString(7,phone);
            preparedStatement.setString(8,address);
            preparedStatement.setString(9,identity);
            preparedStatement.setInt(10,status);

            int i = preparedStatement.executeUpdate();
            return i;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(preparedStatement);
            JDBCUtils.release(connection);
        }


        return 0;
    }

    public int deleteById(int id){
        String sql = "DELETE FROM sysuser WHERE userid = ?;";
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(preparedStatement);
            JDBCUtils.release(connection);
        }
        return 0;
    }
    public int updateUserById(int id,User user){
        String sql = "update sysuser set username = ?,usersex = ? ,userpwd = ?,roleid = ?,usertruename = ?," +
                "userphone=?,useraddr=?,useridentity=?,userstate=? where userid = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getRoleId());
            preparedStatement.setString(5, user.getTrueName());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getIdentity());
            preparedStatement.setInt(9, user.getStatus());
            preparedStatement.setInt(10,id);

            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(preparedStatement);
            JDBCUtils.release(connection);
        }
        return 0;
    }


}
