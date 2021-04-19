package ru.vilgor.bustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vilgor.bustracker.entities.Stop;
import ru.vilgor.bustracker.entities.maps.RoadNode;
import ru.vilgor.bustracker.repositories.StopRepository;
import ru.vilgor.bustracker.services.RoadNodeService;

import java.util.List;

@RestController
@RequestMapping("/stops")
public class StopController {
    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private RoadNodeService roadNodeService;

    @GetMapping("")
    public List<Stop> getStopList() {
        return stopRepository.findAll();
    }


    @GetMapping("/path")
    public List<RoadNode> getPathBetweenStops(@RequestParam int startStopId, @RequestParam int lastStopId) {
        return roadNodeService.findPathBetweenStopsByIds(startStopId, lastStopId);
    }

}
