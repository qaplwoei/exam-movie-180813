package com.hand.movie.dao;

import com.hand.movie.entity.User;
import com.hand.movie.jdbc.JDBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static User selectUserByName(String firstName)
    {
        Connection connection=JDBConn.getConn();
        String sql="select * from customer where first_name= ?";
        PreparedStatement pstmt= null;
        User user=null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, firstName);
            ResultSet rs=pstmt.executeQuery();
            rs.next();
            user=new User(rs);
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
