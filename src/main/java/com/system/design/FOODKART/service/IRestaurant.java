package com.system.design.FOODKART.service;

import com.system.design.FOODKART.model.Restaurant;

public interface IRestaurant {
    public Restaurant register(Restaurant restaurant);

    public Boolean updateQuantity();

    public void show();

    public void rate();
}
