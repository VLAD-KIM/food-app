package com.example.springboot.foods.controller;

import com.example.springboot.foods.entity.Food;
import com.example.springboot.foods.entity.Manufacturer;
import com.example.springboot.foods.service.FoodService;
import com.example.springboot.foods.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "add-food")
    public String addFoodPage(Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "add-food";
    }

    @PostMapping(value = "add-food")
    public String addFood(@RequestParam(name = "food_name") String name,
                          @RequestParam(name = "food_calories") int calories,
                          @RequestParam(name = "food_amounts") int amounts,
                          @RequestParam(name = "food_price") int price,
                          @RequestParam(name = "manufactureId") Long manufactureId) {
        Food food = new Food();
        food.setName(name);
        food.setCalories(calories);
        food.setAmounts(amounts);
        food.setPrice(price);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufactureId);
        food.setManufacturer(manufacturer);
        foodService.save(food);
        return "redirect:/foods";
    }
}
