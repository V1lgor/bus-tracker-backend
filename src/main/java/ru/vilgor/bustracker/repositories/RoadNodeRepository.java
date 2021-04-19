package ru.vilgor.bustracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vilgor.bustracker.entities.maps.RoadNode;

@Repository
public interface RoadNodeRepository extends JpaRepository<RoadNode, Long> {
}
