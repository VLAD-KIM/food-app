package com.example.springboot.foods.service;

import com.example.springboot.foods.entity.Manufacturer;
import com.example.springboot.foods.repo.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getById(Long id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Manufacturer not found: " + id));
    }
}
