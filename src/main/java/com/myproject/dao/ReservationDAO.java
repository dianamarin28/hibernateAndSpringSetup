package com.myproject.dao;

import com.myproject.domain.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationDAO {

    List<Reservation> getAllReservationsForRestaurant(Integer restaurantId);

    List<Reservation> getAllReservationsForRestaurantOnDate(Integer restaurantId, Date startDate, Date endDate);
}
