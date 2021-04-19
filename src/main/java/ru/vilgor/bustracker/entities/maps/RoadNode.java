package ru.vilgor.bustracker.entities.maps;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vilgor.bustracker.entities.City;
import ru.vilgor.bustracker.entities.StopType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roadnode")
public class RoadNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private int id;

    @Column(name = "node_x_pos")
    private double xPos;

    @Column(name = "node_y_pos")
    private double yPos;

    @ManyToMany
    @JoinTable(name = "roadnodeneighbours",
            joinColumns = {@JoinColumn(name = "node_id")},
            inverseJoinColumns = {@JoinColumn(name = "node_neighbour_id")})
    @JsonIgnore
    private List<RoadNode> neighbours;

    public RoadNode() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<RoadNode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<RoadNode> neighbours) {
        this.neighbours = neighbours;
    }
}
