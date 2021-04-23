package ru.vilgor.bustracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vilgor.bustracker.entities.RouteStop;

import java.util.List;

public interface RouteStopRepository extends JpaRepository<RouteStop, Long> {
    public List<RouteStop> getRouteStopByRouteIdAndIsDirectionForwardOrderByNumberAsc(int routeId, boolean directionForward);
    public List<RouteStop> getRouteStopByRouteIdOrderByNumberAsc(int routeId);
}
