package com.hand.movie.service;

import com.hand.movie.dao.FilmDao;
import com.hand.movie.entity.Film;
import com.hand.movie.utils.PageBean;

import java.util.List;

public class FilmService {
    public List<Film> getAllFilm() {
        return FilmDao.selectAll();
    }

    public PageBean<Film> getFilmByPage(PageBean<Film> pageBean) {
        return FilmDao.selectByPage(pageBean);
    }

    public boolean add(Film film) {
        return FilmDao.add(film);
    }

    public boolean update(Film film) {
        return FilmDao.update(film);

    }

    public boolean delete(int film_id) {
        return FilmDao.deleteById(film_id);
    }
}
