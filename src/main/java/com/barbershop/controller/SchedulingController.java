package com.barbershop.controller;

import com.barbershop.model.Scheduling;
import com.barbershop.service.SchedulingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

    private final SchedulingService schedulingService;

    public SchedulingController(SchedulingService schedulingService){
        this.schedulingService =  schedulingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scheduling> findById(@PathVariable Long id){
        var scheduling = schedulingService.findById(id);
        return ResponseEntity.ok(scheduling);
    }

    @PostMapping
    public ResponseEntity<Scheduling> create(@RequestBody Scheduling scheduling){
        var schedulingCreated = schedulingService.create(scheduling);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(schedulingCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(schedulingCreated);
    }
}
