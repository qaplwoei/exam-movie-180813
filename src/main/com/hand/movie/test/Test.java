package com.hand.movie.test;

import com.hand.movie.dao.UserDao;
import com.hand.movie.entity.User;

public class Test {
    public static void main(String[] args) {
        User user=UserDao.selectUserByName("MARY");
        System.out.println(user.getEmail());
    }
}
