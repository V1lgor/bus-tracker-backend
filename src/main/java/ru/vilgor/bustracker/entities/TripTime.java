package ru.vilgor.bustracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="triptime")
public class TripTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_time_id")
    private int id;

    /*@Enumerated(EnumType.ORDINAL)
    @Column(name = "trip_direction")
    private TripDirection tripDirection;*/

    @Column(name = "trip_direction")
    private boolean isDirectionReverse;

    @Column(name = "trip_start_time")
    private String startTime;

    @ManyToOne
    @JoinColumn(name = "trip_vehicle_schedule_id")
    @JsonIgnore
    private VehicleSchedule vehicleSchedule;

    public TripTime() {
    }

    public TripTime(int id, boolean isDirectionForward, String startTime, VehicleSchedule vehicleSchedule) {
        this.id = id;
        this.isDirectionReverse = isDirectionForward;
        this.startTime = startTime;
        this.vehicleSchedule = vehicleSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDirectionReverse() {
        return isDirectionReverse;
    }

    public void setDirectionReverse(boolean directionReverse) {
        isDirectionReverse = directionReverse;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public VehicleSchedule getVehicleSchedule() {
        return vehicleSchedule;
    }

    public void setVehicleSchedule(VehicleSchedule vehicleSchedule) {
        this.vehicleSchedule = vehicleSchedule;
    }
}
