package com.system.design.FOODKART.service;

import com.system.design.FOODKART.dao.UserDao;
import com.system.design.FOODKART.model.Restaurant;
import com.system.design.FOODKART.model.User;

import java.util.List;
import java.util.Random;

public class UserService implements IUser {

    private static UserService userService;

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            return new UserService();
        }
        return userService;
    }

    UserDao userDao = UserDao.getInstance();

    @Override
    public User register(User user) throws Exception {
        if (user == null ||
                (user.getPhoneNumber() == null || user.getPhoneNumber().length() <= 0)
                || (user.getName().isEmpty()))
            throw new Exception("Invalid user");
        Random random = new Random();
      //  int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
        return userDao.register(user);
    }

    @Override
    public User login(Long userId) {
        return userDao.login(userId);
    }

    @Override
    public List<Restaurant> getAllServiceableRestaurant() {
        return null;
    }
}
