package ru.vilgor.bustracker.entities;

import javax.persistence.*;

@Entity
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id")
    private int id;

    @Column(name = "stop_name")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "stop_type_id")
    private StopType stopType;

    @ManyToOne
    @JoinColumn(name = "stop_city_id")
    private City city;

    public Stop() {
    }

    public Stop(int id, String name, StopType stopType, City city) {
        this.id = id;
        this.name = name;
        this.stopType = stopType;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StopType getStopType() {
        return stopType;
    }

    public void setStopType(StopType stopType) {
        this.stopType = stopType;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
