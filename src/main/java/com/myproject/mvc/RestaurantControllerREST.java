package com.myproject.mvc;

import com.myproject.domain.Restaurant;
import com.myproject.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/restaurant")
public class RestaurantControllerREST {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public List<Restaurant> getAllRestaurants(HttpServletResponse response) {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        if (restaurants.size() == 0) {
            response.setStatus(404);
        } else {
            response.setStatus(200);
        }
        return restaurants;
    }

}
