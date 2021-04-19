package ru.vilgor.bustracker.services;

import ru.vilgor.bustracker.entities.maps.RoadNode;

import java.util.List;

public interface RoadNodeService {
    public List<RoadNode> findAll();

    public List<RoadNode> findPathBetweenStopsByIds(int startStopId, int lastStopId);
}
