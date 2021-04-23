package ru.vilgor.bustracker.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.entities.RouteStop;
import ru.vilgor.bustracker.entities.Stop;
import ru.vilgor.bustracker.entities.maps.RoadNode;
import ru.vilgor.bustracker.repositories.RouteRepository;
import ru.vilgor.bustracker.repositories.RouteStopRepository;
import ru.vilgor.bustracker.services.RoadNodeService;
import ru.vilgor.bustracker.services.RouteService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final RoadNodeService roadNodeService;
    private final RouteStopRepository routeStopRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, RoadNodeService roadNodeService, RouteStopRepository routeStopRepository) {
        this.routeRepository = routeRepository;
        this.roadNodeService = roadNodeService;
        this.routeStopRepository = routeStopRepository;
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public Route findById(int id) {
        Route route = routeRepository.findById(id).get();

        Collections.sort(route.getStopList());

        return route;

    }

    @Override
    public int save(Route route) {
        return 0;
    }

    @Override
    public void update(Route route) {

    }

    public List<RoadNode> getRoutePathById(int routeId, boolean direction) {
        List<RouteStop> routeStopListWithDirection
                = routeStopRepository.getRouteStopByRouteIdAndIsDirectionForwardOrderByNumberAsc(routeId, direction);

        for (RouteStop routeStop : routeStopListWithDirection) {
            System.out.println("ID: " + routeStop.getStop().getId());
        }

        System.out.println("Stop count: " + routeStopListWithDirection.size());

        List<RoadNode> routePath = new ArrayList<>();

        for (int i = 0; i < routeStopListWithDirection.size() - 1; i++) {
            int startStopId = routeStopListWithDirection.get(i).getStop().getId();
            int lastStopId = routeStopListWithDirection.get(i + 1).getStop().getId();
            System.out.println("Stops id: " + startStopId + " " + lastStopId);
            List<RoadNode> path = roadNodeService.findPathBetweenStopsByIds(startStopId, lastStopId);

            if (i > 0) path.remove(0);

            routePath.addAll(path);
        }

        return routePath;
    }

    @Override
    public List<RouteStop> getRouteStopListById(int routeId) {
        return routeStopRepository.getRouteStopByRouteIdOrderByNumberAsc(routeId);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean isStopInRoute(int stopId) {
        return routeRepository.findById(stopId).isPresent();
    }

    @Override
    public boolean isStopsInRoute(List<Integer> stopIdList) {
        for (int stopId : stopIdList) {
            if (!isStopInRoute(stopId)) return false;
        }
        return true;
    }
}
