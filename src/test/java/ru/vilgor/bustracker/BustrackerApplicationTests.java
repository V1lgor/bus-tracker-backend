package ru.vilgor.bustracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vilgor.bustracker.entities.VehicleSchedule;
import ru.vilgor.bustracker.repositories.VehicleScheduleRepository;

import java.util.List;

@SpringBootTest
class BustrackerApplicationTests {

    @Autowired
    private VehicleScheduleRepository vehicleScheduleRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testRepository() {
        List<VehicleSchedule> vehicleScheduleList = vehicleScheduleRepository.findAll();
    }
}
