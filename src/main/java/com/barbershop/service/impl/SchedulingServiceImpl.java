package com.barbershop.service.impl;

import com.barbershop.model.Scheduling;
import com.barbershop.repository.SchedulingRepository;
import com.barbershop.service.SchedulingService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SchedulingServiceImpl implements SchedulingService {

    private final SchedulingRepository schedulingRepository;

    public SchedulingServiceImpl(SchedulingRepository schedulingRepository){
        this.schedulingRepository = schedulingRepository;
    }

    @Override
    public Scheduling findById(Long id) {
        return schedulingRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Scheduling create(Scheduling schedulingToCreate) {
        if(schedulingRepository.existsByClientPhone(schedulingToCreate.getClient().getPhone())){
            throw new IllegalArgumentException("There is already a customer with that phone number");
        }
        return schedulingRepository.save(schedulingToCreate);
    }
}
