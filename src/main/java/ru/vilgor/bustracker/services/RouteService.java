package ru.vilgor.bustracker.services;

import ru.vilgor.bustracker.entities.Route;

import java.util.List;

public interface RouteService {
    List<Route> findAll();

    int save(Route route);

    void update(Route route);

    void delete(int id);
}
