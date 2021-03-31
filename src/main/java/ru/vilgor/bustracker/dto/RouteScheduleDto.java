package ru.vilgor.bustracker.dto;

import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.entities.TripTime;

import java.util.List;

public class RouteScheduleDto {
    private Route route;


    private List<VehicleScheduleDto> schedule;

    public RouteScheduleDto(Route route, List<VehicleScheduleDto> schedule) {
        this.route = route;
        this.schedule = schedule;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<VehicleScheduleDto> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<VehicleScheduleDto> schedule) {
        this.schedule = schedule;
    }
}
