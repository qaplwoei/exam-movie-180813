package com.hand.movie.service;

import com.hand.movie.dao.UserDao;
import com.hand.movie.entity.User;

public class UserService {
    public User login(String firstName)
    {
        return UserDao.selectUserByName(firstName);
    }
}
