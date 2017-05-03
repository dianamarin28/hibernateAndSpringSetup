package com.myproject.service;

import com.myproject.dao.RestaurantDAO;
import com.myproject.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantDAO restaurantDAO;

    public List<Restaurant> getAllRestaurants() {
        return restaurantDAO.getAllRestaurants();
    }

}
