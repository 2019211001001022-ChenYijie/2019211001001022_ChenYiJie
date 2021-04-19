package com.chenyijie.dao;

import com.chenyijie.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
public class UserDao  implements  IUserDao{

    QueryRunner qr = new QueryRunner();

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable(username,password,email,gender,birth) values(?,?,?,?,?)";
        int i = qr.update(con,sql,new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getBirthdate()});
        if (i != 0) {
            return true;
        }else return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from usertable where id = ?";
        return  qr.update(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update usertable set name = ?,password = ?, email = ?, gender = ?, birth = ? where id = ?";
        return qr.update(con,sql,new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getBirthdate(),user.getID()});
    }


    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from usertable where id =  " + id;
        return  qr.query(con,sql,new BeanHandler<>(User.class));
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "SELECT * FROM usertable WHERE name=? AND password=?;";
        PreparedStatement st= con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);

        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setID(rs.getInt("id"));
            user.setUsername(rs.getString("name"));
            user.setBirthdate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            return user;
        }else {
            return  null;
        }
        //System.out.println(con);
        //String sql2 = "select * from usertable where name = '" + username + "' and password = '" + password + "'";
        // User user = qr.query(con, sql2, new BeanHandler<>(User.class));
        // System.out.println(user.toString());
        // return user;

    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from usertable where name = " + username;
        return  qr.query(sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from usertable where password = " + password;
        return  qr.query(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from usertable where email = " + email;
        return  qr.query(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from usertable where gender = " + gender;
        return  qr.query(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select * from usertable where birthdate = " + birthDate;
        return  qr.query(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "SELECT * FROM usertable";
        return qr.query(con,sql,new BeanListHandler<>(User.class));
    }
}
