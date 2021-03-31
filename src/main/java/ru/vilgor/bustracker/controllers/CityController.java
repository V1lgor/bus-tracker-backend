package ru.vilgor.bustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vilgor.bustracker.entities.City;
import ru.vilgor.bustracker.repositories.CityRepository;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("")
    public List<City> getCityList() {
        return cityRepository.findAll();
    }
}
