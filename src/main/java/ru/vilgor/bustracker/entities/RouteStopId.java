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

    @Column(name = "is_direction_forward")
    private boolean isDirectionForward;

    public RouteStopId() {
    }

    public RouteStopId(Integer routeId, int stopId, boolean direction) {
        this.routeId = routeId;
        this.stopId = stopId;
        this.isDirectionForward = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteStopId that = (RouteStopId) o;
        return stopId == that.stopId && isDirectionForward == that.isDirectionForward && Objects.equals(routeId, that.routeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, stopId, isDirectionForward);
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

    public boolean isDirection() {
        return isDirectionForward;
    }

    public void setDirection(boolean direction) {
        this.isDirectionForward = direction;
    }
}
