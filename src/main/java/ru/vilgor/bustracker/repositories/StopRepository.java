package ru.vilgor.bustracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vilgor.bustracker.entities.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Integer> {

}
