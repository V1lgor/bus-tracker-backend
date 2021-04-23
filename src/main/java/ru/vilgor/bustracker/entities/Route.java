package ru.vilgor.bustracker.entities;

import com.fasterxml.jackson.annotation.JsonView;
import ru.vilgor.bustracker.jsonview.RouteView;

import javax.persistence.*;
import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private int id;

    @Column(name = "route_number")
    private String number;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "route_vehicle_type_id")
    private VehicleType vehicleType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "route_type_id")
    private RouteType routeType;

    @ManyToOne
    @JoinColumn(name="route_city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "route_start_stop_id")
    private Stop startStop;

    @OneToOne
    @JoinColumn(name = "route_last_stop_id")
    private Stop lastStop;

    @Column(name = "route_vehicle_count")
    private int vehicleCount;

    @Column(name = "route_trip_time")
    private int tripTime;

    @Column(name = "route_length")
    private double length;

    @ManyToOne
    @JoinColumn(name = "route_company_id")
    private Company company;

    @OneToMany(mappedBy = "route", cascade = {CascadeType.ALL})
    @JsonView(RouteView.StopList.class)
    private List<RouteStop> stopList;

    public Route() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Stop getStartStop() {
        return startStop;
    }

    public void setStartStop(Stop startStop) {
        this.startStop = startStop;
    }

    public Stop getLastStop() {
        return lastStop;
    }

    public void setLastStop(Stop lastStop) {
        this.lastStop = lastStop;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public int getTripTime() {
        return tripTime;
    }

    public void setTripTime(int tripTime) {
        this.tripTime = tripTime;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<RouteStop> getStopList() {
        return stopList;
    }

    public void setStopList(List<RouteStop> stopList) {
        this.stopList = stopList;
    }
}
