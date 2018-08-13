package com.hand.movie.dao;

import com.hand.movie.entity.Film;
import com.hand.movie.entity.Language;
import com.hand.movie.jdbc.JDBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanguageDao {
    public static List<Language> selectAll()
    {
        List<Language> list=new ArrayList<>();
        Connection connection=JDBConn.getConn();
        String sql="select * from language";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next())
            {
                Language language=new Language(rs);
                list.add(language);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Language selectById(int id)
    {
        Connection connection=JDBConn.getConn();
        String sql="select * from language where language_id=?";
        Language language=null;
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            rs.next();
            language=new Language(rs);
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return language;
    }
}
