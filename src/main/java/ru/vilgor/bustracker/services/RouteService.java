package ru.vilgor.bustracker.services;

import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.entities.maps.RoadNode;

import java.util.List;

public interface RouteService {
    List<Route> findAll();

    Route findById(int id);

    int save(Route route);

    void update(Route route);

    void delete(int id);

    List<RoadNode> getRoutePathById(int routeId);
}
