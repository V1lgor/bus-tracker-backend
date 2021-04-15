package ru.vilgor.bustracker.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.repositories.RouteRepository;
import ru.vilgor.bustracker.services.RouteService;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public int save(Route route) {
        return 0;
    }

    @Override
    public void update(Route route) {

    }

    @Override
    public void delete(int id) {

    }
}
