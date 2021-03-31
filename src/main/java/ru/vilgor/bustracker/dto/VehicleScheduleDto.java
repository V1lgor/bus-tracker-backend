package ru.vilgor.bustracker.dto;

import ru.vilgor.bustracker.entities.TripTime;

import java.util.List;

public class VehicleScheduleDto {
    private int number;
    private List<TripTime> schedule;

    public VehicleScheduleDto(int number, List<TripTime> schedule) {
        this.number = number;
        this.schedule = schedule;
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
