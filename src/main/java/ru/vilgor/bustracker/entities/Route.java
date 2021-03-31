package ru.vilgor.bustracker.entities;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "route_start_stop_id")
    private Stop startStop;

    @OneToOne
    @JoinColumn(name = "route_last_stop_id")
    private Stop lastStop;

    @Column(name = "route_vehicle_count")
    private int vehicleCount;

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
}
