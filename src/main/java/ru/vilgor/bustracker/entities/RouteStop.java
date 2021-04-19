package ru.vilgor.bustracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "route_stops")
@Table(name = "route_stops")
public class RouteStop implements Comparable<RouteStop>{

    @EmbeddedId
    private RouteStopId id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "route_id")
    @MapsId("routeId")
    @JsonIgnore
    private Route route;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "stop_id")
    @MapsId("stopId")
    private Stop stop;

    @Column(name = "stop_number")
    private Integer number;

    @Column(name = "is_direction_forward")
    private boolean isDirectionForward;

    public RouteStop() {
    }

    public RouteStop(RouteStopId id, Route route, Stop stop, int number, boolean isDirectionForward) {
        this.id = id;
        this.route = route;
        this.stop = stop;
        this.number = number;
        this.isDirectionForward = isDirectionForward;
    }

    @Override
    public int compareTo(RouteStop o) {
        return this.number.compareTo(o.number);
    }

    public RouteStopId getId() {
        return id;
    }

    public void setId(RouteStopId id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isDirectionForward() {
        return isDirectionForward;
    }

    public void setDirectionForward(boolean directionForward) {
        isDirectionForward = directionForward;
    }


}
