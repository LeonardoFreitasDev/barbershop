package com.barbershop.service;

import com.barbershop.model.Scheduling;

public interface SchedulingService {
    Scheduling findById(Long id);

    Scheduling create(Scheduling schedulingToCreate);
}
