package com.example.springboot.foods.service;

import com.example.springboot.foods.entity.Food;
import com.example.springboot.foods.repo.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food getById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Food not found: " + id));
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public void delete(Long id) {
        foodRepository.deleteById(id);
    }
}
