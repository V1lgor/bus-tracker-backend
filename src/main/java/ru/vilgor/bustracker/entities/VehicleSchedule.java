package ru.vilgor.bustracker.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicleschedule")
public class VehicleSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_schedule_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "vehicle_schedule_route_id")
    private Route route;

    @Column(name = "vehicle_schedule_number")
    private int number;

    @OneToMany(mappedBy = "vehicleSchedule")
    private List<TripTime> schedule;

    public VehicleSchedule() {
    }

    public VehicleSchedule(int id, Route route, int number, List<TripTime> schedule) {
        this.id = id;
        this.route = route;
        this.number = number;
        this.schedule = schedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<TripTime> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<TripTime> schedule) {
        this.schedule = schedule;
    }
}
