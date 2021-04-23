package ru.vilgor.bustracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "route_stops")
@Table(name = "route_stops")
@IdClass(RouteStopId.class)
public class RouteStop implements Comparable<RouteStop> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_stop_id")
    private int id;

    @Id
    @Column(name = "route_id")
    private int routeId;

    @Id
    @Column(name = "stop_id")
    private int stopId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "route_id", insertable = false, updatable = false)
    @JsonIgnore
    private Route route;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "stop_id", insertable = false, updatable = false)
    private Stop stop;

    @Column(name = "stop_number")
    private Integer number;

    @Column(name = "is_direction_forward")
    @Id
    private boolean isDirectionForward;

    public RouteStop() {
    }


    @Override
    public int compareTo(RouteStop o) {
        return this.number.compareTo(o.number);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
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
