package ru.vilgor.bustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vilgor.bustracker.dto.RouteScheduleDto;
import ru.vilgor.bustracker.repositories.VehicleScheduleRepository;
import ru.vilgor.bustracker.services.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    VehicleScheduleRepository vehicleScheduleRepository;
    @Autowired
    ScheduleService scheduleService;


    @GetMapping("/{id}")
    public RouteScheduleDto getScheduleById(@PathVariable int id) {
        return scheduleService.getRouteScheduleById(id);

    }
}
