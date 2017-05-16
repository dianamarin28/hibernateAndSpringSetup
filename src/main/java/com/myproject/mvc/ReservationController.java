package com.myproject.mvc;

import com.myproject.service.ReservationService;
import com.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "/backoffice/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllReservationsForRestaurant(Principal principal, Model model) {
        String currentUser = principal.getName();
        Integer restaurantId = userService.getRestaurantIdForUser(currentUser);

        model.addAttribute("allReservationsForRestaurant", reservationService.getAllReservationsForRestaurant(restaurantId));

        return "viewReservations";
    }

    @RequestMapping(value = "/getAllOnDate", method = RequestMethod.GET)
    public String getAllReservationsForRestaurantOnDate(Principal principal, @RequestParam("date") String date, Model model) {
        if (!StringUtils.isEmpty(date)) {
            String currentUser = principal.getName();
            Integer restaurantId = userService.getRestaurantIdForUser(currentUser);

            DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
            Date javaDate = null;
            try {
                javaDate = format.parse(date);
                javaDate.setTime(1500);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            model.addAttribute("allReservationsForRestaurantByDate", reservationService.getAllReservationsForRestaurantOnDate(restaurantId, javaDate));
        }

        return "viewReservations";
    }
}
