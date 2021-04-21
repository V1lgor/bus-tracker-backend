package ru.vilgor.bustracker.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vilgor.bustracker.dto.RoadNodeDto;
import ru.vilgor.bustracker.services.RoadNodeService;

import java.util.List;

@RestController
@RequestMapping("/road")
public class RoadController {

    private final RoadNodeService roadNodeService;

    @Autowired
    public RoadController(RoadNodeService roadNodeService) {
        this.roadNodeService = roadNodeService;
    }

    @GetMapping("/full_graph")
    public List<RoadNodeDto> getRoadGraph() {
        return roadNodeService.getFullRoadGraph();
    }
}
