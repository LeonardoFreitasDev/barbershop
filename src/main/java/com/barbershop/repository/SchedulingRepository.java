package com.barbershop.repository;

import com.barbershop.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {

    boolean existsByClientPhone(String phoneClient);
}
