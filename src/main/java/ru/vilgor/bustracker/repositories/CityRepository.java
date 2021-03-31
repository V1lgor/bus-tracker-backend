package ru.vilgor.bustracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vilgor.bustracker.entities.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}
