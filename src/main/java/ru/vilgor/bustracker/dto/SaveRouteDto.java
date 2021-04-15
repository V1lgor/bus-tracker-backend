package ru.vilgor.bustracker.dto;

import ru.vilgor.bustracker.entities.RouteType;
import ru.vilgor.bustracker.entities.VehicleType;

public class SaveRouteDto {
    private int id;
    private String number;
    private RouteType type;
    private int startStopId;
    private int lastStopId;
    private int vehicleCount;
    private VehicleType vehicleType;
    private int cityId;
    private int tripTime;
    private int companyId;
    private double length;

    public SaveRouteDto(int id, String number, RouteType type, int startStopId, int lastStopId,
                        int vehicleCount, VehicleType vehicleType, int cityId, int tripTime,
                        int companyId, double length) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.startStopId = startStopId;
        this.lastStopId = lastStopId;
        this.vehicleCount = vehicleCount;
        this.vehicleType = vehicleType;
        this.cityId = cityId;
        this.tripTime = tripTime;
        this.companyId = companyId;
        this.length = length;
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

    public RouteType getType() {
        return type;
    }

    public void setType(RouteType type) {
        this.type = type;
    }

    public int getStartStopId() {
        return startStopId;
    }

    public void setStartStopId(int startStopId) {
        this.startStopId = startStopId;
    }

    public int getLastStopId() {
        return lastStopId;
    }

    public void setLastStopId(int lastStopId) {
        this.lastStopId = lastStopId;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getTripTime() {
        return tripTime;
    }

    public void setTripTime(int tripTime) {
        this.tripTime = tripTime;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
