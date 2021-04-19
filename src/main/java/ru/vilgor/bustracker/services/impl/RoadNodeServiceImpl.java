package ru.vilgor.bustracker.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vilgor.bustracker.entities.Stop;
import ru.vilgor.bustracker.entities.maps.RoadNode;
import ru.vilgor.bustracker.repositories.RoadNodeRepository;
import ru.vilgor.bustracker.repositories.StopRepository;
import ru.vilgor.bustracker.services.RoadNodeService;

import java.util.*;

@Service
public class RoadNodeServiceImpl implements RoadNodeService {

    private final RoadNodeRepository roadNodeRepository;
    private final StopRepository stopRepository;

    @Autowired
    public RoadNodeServiceImpl(RoadNodeRepository roadNodeRepository, StopRepository stopRepository) {
        this.roadNodeRepository = roadNodeRepository;
        this.stopRepository = stopRepository;
    }

    @Override
    public List<RoadNode> findAll() {
        return roadNodeRepository.findAll();
    }

    public List<RoadNode> findPathBetweenStopsByIds(int startStopId, int lastStopId) {
        Stop startStop = stopRepository.getOne(startStopId);
        Stop lastStop = stopRepository.getOne(lastStopId);

        return findWayBetweenStops(startStop, lastStop);
    }

    private List<RoadNode> findWayBetweenStops(Stop start, Stop finish) {
        RoadNode startStopNode = start.getRoadNode();
        RoadNode finishStopNode = finish.getRoadNode();

        Queue<RoadNode> queue = new ArrayDeque<>();

        queue.add(startStopNode);

        List<RoadNode> used = new ArrayList<>();
        Map<RoadNode, RoadNode> prev = new HashMap<>();

        while (!queue.isEmpty()) {
            RoadNode currentNode = queue.remove();

            boolean shouldStop = false;

            for (RoadNode neighbour : currentNode.getNeighbours()) {
                if (!used.contains(neighbour)) {
                    queue.add(neighbour);
                    used.add(neighbour);
                    prev.put(neighbour, currentNode);
                }
                if (neighbour.equals(finishStopNode)) {
                    shouldStop = true;
                    break;
                }
            }

            if (shouldStop) break;

        }

        List<RoadNode> path = new ArrayList<>();

        RoadNode current = finishStopNode;

        path.add(finishStopNode);

        while (prev.containsKey(current)) {
            current = prev.get(current);
            path.add(current);
        }

        Collections.reverse(path);

        for (RoadNode node : path) {
            System.out.println(node.getId());
        }

        return path;

    }
}
