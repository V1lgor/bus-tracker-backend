package ru.vilgor.bustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vilgor.bustracker.dto.SaveRouteDto;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.entities.maps.RoadNode;
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

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable int id) {
        Route route = routeService.findById(id);
        System.out.println(route.getStopList().size());
        return route;
    }

    @GetMapping("/{id}/path")
    public List<RoadNode> getRoutePathById(@PathVariable int id) {
        return routeService.getRoutePathById(id);
    }
}
