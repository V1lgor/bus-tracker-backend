package ru.vilgor.bustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vilgor.bustracker.entities.Stop;
import ru.vilgor.bustracker.repositories.StopRepository;

import java.util.List;

@RestController
@RequestMapping("/stops")
public class StopController {
    @Autowired
    private StopRepository stopRepository;

    @GetMapping("")
    public List<Stop> getStopList() {
        return stopRepository.findAll();
    }


}
