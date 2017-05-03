package com.myproject.service;

import com.myproject.dao.ReservationDAO;
import com.myproject.domain.Reservation;
import com.myproject.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    public List<Reservation> getAllReservationsForRestaurant(Integer restaurantId) {
        return reservationDAO.getAllReservationsForRestaurant(restaurantId);
    }

    public List<Reservation> getAllReservationsForRestaurantOnDate(Integer restaurantId, Date date) {
        Date startDate = DateUtils.getDayBeginning(date);
        Date endDate = DateUtils.getDayEnding(date);
        return reservationDAO.getAllReservationsForRestaurantOnDate(restaurantId, startDate, endDate);
    }
}
