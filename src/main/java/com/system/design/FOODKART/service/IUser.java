package com.system.design.FOODKART.service;

import com.system.design.FOODKART.model.Restaurant;
import com.system.design.FOODKART.model.User;

import java.util.List;

public interface IUser {
    public User register(User user) throws Exception;

    public User login(Long userId);

    public List<Restaurant> getAllServiceableRestaurant();
}
