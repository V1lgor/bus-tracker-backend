package ru.vilgor.bustracker.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.entities.Stop;
import ru.vilgor.bustracker.entities.maps.RoadNode;
import ru.vilgor.bustracker.repositories.RouteRepository;
import ru.vilgor.bustracker.services.RoadNodeService;
import ru.vilgor.bustracker.services.RouteService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final RoadNodeService roadNodeService;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, RoadNodeService roadNodeService) {
        this.routeRepository = routeRepository;
        this.roadNodeService = roadNodeService;
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

    public List<RoadNode> getRoutePathById(int routeId) {
        Route route = findById(routeId);

        List<RoadNode> routePath = new ArrayList<>();

        for (int i = 0; i < route.getStopList().size() - 1; i++) {
            int startStopId = route.getStopList().get(i).getStop().getId();
            int lastStopId = route.getStopList().get(i + 1).getStop().getId();

            List<RoadNode> path = roadNodeService.findPathBetweenStopsByIds(startStopId, lastStopId);

            if (i > 0) path.remove(0);

            routePath.addAll(path);
        };

        return routePath;
    }

    @Override
    public void delete(int id) {

    }
}
