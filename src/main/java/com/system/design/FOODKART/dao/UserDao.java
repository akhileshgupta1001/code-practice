package com.system.design.FOODKART.dao;

import com.system.design.FOODKART.model.Restaurant;
import com.system.design.FOODKART.model.User;
import com.system.design.FOODKART.service.IUser;

import java.util.HashMap;
import java.util.List;

public class UserDao implements IUser {
    private static UserDao userDao;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (userDao == null) {
            return new UserDao();
        }
        return userDao;
    }

    private HashMap<Integer, User> userHashMap = new HashMap<>();
    private HashMap<Long, Integer> phoneNumberMap = new HashMap<>();
    private HashMap<String, Restaurant> restaurantNameMap = new HashMap<>();

    @Override
    public User register(User user) throws Exception {
        return null;
    }

    @Override
    public User login(Long userId) {
        return null;
    }

    @Override
    public List<Restaurant> getAllServiceableRestaurant() {
        return null;
    }
}
