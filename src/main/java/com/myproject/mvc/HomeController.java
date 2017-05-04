package com.myproject.mvc;

import com.myproject.util.DateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage() {
        return "redirect:/backoffice";
    }

    @RequestMapping(value = "/backoffice", method = RequestMethod.GET)
    public String backofficeHome(Model model) {
        model.addAttribute("dateForm", new DateForm());

        return "backoffice";
    }
}
