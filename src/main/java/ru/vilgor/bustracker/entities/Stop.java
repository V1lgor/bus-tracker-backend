package ru.vilgor.bustracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vilgor.bustracker.entities.maps.RoadNode;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "stop_x_pos")
    private Double xPos;

    @Column(name = "stop_y_pos")
    private Double yPos;

    @OneToOne
    @JoinColumn(name = "stop_road_node_id")
    private RoadNode roadNode;

    @OneToMany(mappedBy = "route")
    @JsonIgnore
    private List<RouteStop> routeList;

    public Stop() {
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

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public RoadNode getRoadNode() {
        return roadNode;
    }

    public void setRoadNode(RoadNode roadNode) {
        this.roadNode = roadNode;
    }
}
