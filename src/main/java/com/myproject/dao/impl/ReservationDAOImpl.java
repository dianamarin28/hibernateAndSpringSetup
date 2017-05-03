package com.myproject.dao.impl;

import com.myproject.dao.ReservationDAO;
import com.myproject.domain.Reservation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository("reservationDAO")
@Transactional
public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Reservation> getAllReservationsForRestaurant(Integer restaurantId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Reservation as R WHERE R.restaurant.id = :restaurantId");
        query.setParameter("restaurantId", restaurantId);
        List<Reservation> reservations = query.list();
        return reservations;
    }

    @Override
    public List<Reservation> getAllReservationsForRestaurantOnDate(Integer restaurantId, Date startDate, Date endDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Reservation AS R WHERE R.date BETWEEN :startDate AND :endDate");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<Reservation> reservations = query.list();
        return reservations;
    }
}
