package com.rocketseat.planner.activity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {

    List<Activity> findByTripId(UUID tripId);
}