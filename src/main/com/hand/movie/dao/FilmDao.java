package com.hand.movie.dao;

import com.hand.movie.entity.Film;
import com.hand.movie.entity.Language;
import com.hand.movie.jdbc.JDBConn;
import com.hand.movie.utils.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDao {
    public static List<Film> selectAll() {
        List<Film> filmList = new ArrayList<>();
        Connection connection = JDBConn.getConn();
        String sql = "select * from film";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int language_id = rs.getInt("language_id");
                Language language = LanguageDao.selectById(language_id);
                Film film = new Film(rs);
                film.setLanguage(language);
                filmList.add(film);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmList;
    }

    public static PageBean<Film> selectByPage(PageBean<Film> page) {
        page.setTotalCount(getCount());
        int currentPage = page.getCurrentPage();
        int index = (currentPage - 1) * page.getPageCount();
        int count = page.getPageCount();
        Connection connection = JDBConn.getConn();
        String sql = "select * from film limit ?,?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,index);
            preparedStatement.setInt(2,count);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int language_id = rs.getInt("language_id");
                Language language = LanguageDao.selectById(language_id);
                Film film = new Film(rs);
                film.setLanguage(language);
                page.getPageData().add(film);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    public static int getCount() {
        String sql = "select count(*) from film";
        Connection connection = JDBConn.getConn();
        int count=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            count=rs.getInt(1);
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static Film selectById(int id)
    {
        String sql = "select * from film where film_id=?";
        Connection connection = JDBConn.getConn();
        PreparedStatement preparedStatement = null;
        Film film=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            int language_id = rs.getInt("language_id");
            Language language = LanguageDao.selectById(language_id);
            film=new Film(rs);
            film.setLanguage(language);
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }
    public static boolean update(Film film) {
        String sql = "update film set title=?,description=?,language_id=? where film_id=?";
        Connection connection = JDBConn.getConn();
        boolean flag=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,film.getTitle());
            preparedStatement.setString(2,film.getDescription());
            preparedStatement.setInt(3,film.getLanguage().getLanguage_id());
            preparedStatement.setInt(4,film.getFilm_id());
            int n=preparedStatement.executeUpdate();
            if(n>0)
                flag=true;
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static boolean add(Film film) {
        String sql = "insert into film(title,description,language_id) value (?,?,?)";
        Connection connection = JDBConn.getConn();
        boolean flag=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,film.getTitle());
            preparedStatement.setString(2,film.getDescription());
            preparedStatement.setInt(3,film.getLanguage().getLanguage_id());
            int n=preparedStatement.executeUpdate();
            if(n>0)
                flag=true;
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteById(int film_id) {
        String sql = "delete from film where film_id=?";
        Connection connection = JDBConn.getConn();
        boolean flag=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, film_id);
            int n=preparedStatement.executeUpdate();
            if(n>0)
                flag=true;
            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
