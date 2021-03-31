package ru.vilgor.bustracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vilgor.bustracker.dto.RouteScheduleDto;
import ru.vilgor.bustracker.dto.VehicleScheduleDto;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.entities.VehicleSchedule;
import ru.vilgor.bustracker.exceptions.RouteNotFoundException;
import ru.vilgor.bustracker.repositories.RouteRepository;
import ru.vilgor.bustracker.repositories.VehicleScheduleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private RouteRepository routeRepository;
    private VehicleScheduleRepository vehicleScheduleRepository;

    @Autowired
    public ScheduleService(RouteRepository routeRepository, VehicleScheduleRepository vehicleScheduleRepository) {
        this.routeRepository = routeRepository;
        this.vehicleScheduleRepository = vehicleScheduleRepository;
    }

    public RouteScheduleDto getRouteScheduleById(int routeId) throws RouteNotFoundException {

        Optional<Route> possibleRoute = routeRepository.findById(routeId);

        Route route = null;

        if (possibleRoute.isPresent()) {
            route = possibleRoute.get();
        }
        else {
            throw new RouteNotFoundException(routeId);
        }

        List<VehicleSchedule> routeVehicleScheduleList = vehicleScheduleRepository.getRouteScheduleById(routeId);

        List<VehicleScheduleDto> scheduleDto = new ArrayList<>();

        for (VehicleSchedule vehicleSchedule : routeVehicleScheduleList) {
            scheduleDto.add(new VehicleScheduleDto(vehicleSchedule.getNumber(), vehicleSchedule.getSchedule()));
        }

        return new RouteScheduleDto(route, scheduleDto);


    }
}
