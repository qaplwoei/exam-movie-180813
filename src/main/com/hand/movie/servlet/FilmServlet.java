package com.hand.movie.servlet;

import com.hand.movie.dao.LanguageDao;
import com.hand.movie.entity.Film;
import com.hand.movie.entity.Language;
import com.hand.movie.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/film")
public class FilmServlet extends HttpServlet {
    private FilmService filmService = new FilmService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":
                addFilm(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "delete":
                delete(req,resp);
                break;
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int film_id = Integer.parseInt(req.getParameter("film_id"));
        boolean flag = filmService.delete(film_id);
        if (flag)
            req.setAttribute("message", "删除成功");
        else
            req.setAttribute("message", "删除失败");
        req.getRequestDispatcher("filmList.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int language_id = Integer.parseInt(req.getParameter("language_id"));
        int film_id = Integer.parseInt(req.getParameter("film_id"));
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        Language language = LanguageDao.selectById(language_id);
        film.setLanguage(language);
        film.setFilm_id(film_id);
        boolean flag = filmService.update(film);
        if (flag)
            req.setAttribute("message", "修改成功");
        else
            req.setAttribute("message", "修改失败");
        req.getRequestDispatcher("filmList.jsp").forward(req, resp);
    }

    private void addFilm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int language_id = Integer.parseInt(req.getParameter("language_id"));
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        Language language = LanguageDao.selectById(language_id);
        film.setLanguage(language);
        boolean flag = filmService.add(film);
        if (flag)
            req.setAttribute("message", "添加成功");
        else
            req.setAttribute("message", "添加失败");
        req.getRequestDispatcher("filmList.jsp").forward(req, resp);
    }

}
