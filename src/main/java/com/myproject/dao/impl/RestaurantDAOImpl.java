package com.myproject.dao.impl;

import com.myproject.dao.RestaurantDAO;
import com.myproject.domain.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("restaurantDAO")
@Transactional
public class RestaurantDAOImpl implements RestaurantDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Restaurant> getAllRestaurants() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Restaurant as R").list();
    }
}
