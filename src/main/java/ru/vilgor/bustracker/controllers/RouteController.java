package ru.vilgor.bustracker.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vilgor.bustracker.dto.SaveRouteDto;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.entities.RouteStop;
import ru.vilgor.bustracker.entities.maps.RoadNode;
import ru.vilgor.bustracker.jsonview.RouteView;
import ru.vilgor.bustracker.services.RouteService;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("")
    @JsonView(RouteView.Common.class)
    public List<Route> getRouteList() {
        return routeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable int id) {
        Route route = routeService.findById(id);
        return new ResponseEntity<Route>(route, HttpStatus.OK);
    }

    @GetMapping("/{id}/stops")
    public ResponseEntity<List<RouteStop>> getRouteStopList(@PathVariable int id) {
        return new ResponseEntity<>(routeService.getRouteStopListById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/path")
    public List<RoadNode> getRoutePathById(@PathVariable int id,
                                           @RequestParam(name = "forward", required = true) boolean isDirectionForward) {
        return routeService.getRoutePathById(id, isDirectionForward);
    }
}
