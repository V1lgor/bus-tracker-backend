package ru.vilgor.bustracker.dto;

import ru.vilgor.bustracker.entities.maps.RoadNode;

import java.util.ArrayList;
import java.util.List;

public class RoadNodeDto {
    private RoadNode node;
    private List<Integer> neighboursIds;

    public RoadNodeDto(RoadNode node) {
        this.node = node;

        neighboursIds = new ArrayList<>();

        for (RoadNode neighbour : node.getNeighbours()) {
            neighboursIds.add(neighbour.getId());
        }
    }

    public RoadNode getNode() {
        return node;
    }

    public void setNode(RoadNode node) {
        this.node = node;
    }

    public List<Integer> getNeighboursIds() {
        return neighboursIds;
    }

    public void setNeighboursIds(List<Integer> neighboursIds) {
        this.neighboursIds = neighboursIds;
    }
}
