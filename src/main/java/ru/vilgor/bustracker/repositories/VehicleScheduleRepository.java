package ru.vilgor.bustracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.vilgor.bustracker.entities.Route;
import ru.vilgor.bustracker.entities.VehicleSchedule;

import java.util.List;

public interface VehicleScheduleRepository extends JpaRepository<VehicleSchedule, Integer> {
    @Query("from VehicleSchedule vs where vs.route.id = :id")
    public List<VehicleSchedule> getRouteScheduleById(int id);
}
