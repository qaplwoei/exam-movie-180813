package com.hand.movie.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Film {
    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private Language language;

    private int original_language_id;
    private int rental_duration;
    private float rental_rate;
    private  int length;
    private float replacement_cost;
    private String rating;
    private String special_features;
    private Timestamp last_update;
    public Film(){}
    public Film(ResultSet rs) {
        try {
            film_id=rs.getInt("film_id");
            release_year=rs.getInt("release_year");
            original_language_id=rs.getInt("original_language_id");
            rental_duration=rs.getInt("rental_duration");
            rental_rate=rs.getInt("rental_rate");
            title=rs.getString("title");
            description=rs.getString("description");
            rental_rate=rs.getFloat("rental_rate");
            replacement_cost=rs.getFloat("replacement_cost");
            last_update=rs.getTimestamp("last_update");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }


    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(int original_language_id) {
        this.original_language_id = original_language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public float getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(float rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(float replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
}
