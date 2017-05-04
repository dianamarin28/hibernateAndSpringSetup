package com.myproject.mvc;

import com.myproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/backoffice/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/{restaurantId}", method = RequestMethod.GET)
    public String getAllReservationsForRestaurant(@PathVariable("restaurantId") int restaurantId, Model model) {
        model.addAttribute("allReservationsForRestaurant", reservationService.getAllReservationsForRestaurant(restaurantId));

        return "viewReservations";
    }
}
