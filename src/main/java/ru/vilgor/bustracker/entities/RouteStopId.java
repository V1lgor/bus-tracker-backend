package ru.vilgor.bustracker.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RouteStopId implements Serializable {
    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "stop_id")
    private int stopId;

    public RouteStopId(Integer routeId, int stopId) {
        this.routeId = routeId;
        this.stopId = stopId;
    }

    public RouteStopId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteStopId that = (RouteStopId) o;
        return routeId.equals(that.routeId) && stopId == that.stopId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, stopId);
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }
}
