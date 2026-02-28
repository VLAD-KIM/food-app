package com.example.springboot.foods.controller;

import com.example.springboot.foods.service.FoodService;
import com.example.springboot.foods.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final ManufacturerService manufacturerService;

    @GetMapping(value = "/foods")
    public String list(Model model) {
        model.addAttribute("foods", foodService.findAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "foods";
    }
}
