package ru.vilgor.bustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.repositories.RouteRepository;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @GetMapping("")
    public List<Route> getRouteList() {
        return routeRepository.findAll();
    }

}
