package ru.vilgor.bustracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vilgor.bustracker.entities.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {

}
