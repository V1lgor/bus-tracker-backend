package ru.vilgor.bustracker.exceptions;

public class RouteNotFoundException extends Exception {
    private int routeId;
    private final String message = "Route with id " + routeId + "not found";

    public RouteNotFoundException(int routeId) {
        this.routeId = routeId;
    }


}
