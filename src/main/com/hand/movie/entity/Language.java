package com.hand.movie.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Language {
    private int language_id;
    private  String name;
    private Timestamp last_update;

    public Language(ResultSet rs) {
        try {
            language_id=rs.getInt("language_id");
            name=rs.getString("name");
            last_update=rs.getTimestamp("last_update");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Language() {

    }


    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
}
