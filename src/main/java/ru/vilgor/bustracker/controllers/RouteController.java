package ru.vilgor.bustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vilgor.bustracker.dto.SaveRouteDto;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.services.RouteService;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {
    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("")
    public List<Route> getRouteList() {
        return routeService.findAll();
    }

}
