package com.example.x.Repository;

import com.example.x.Model.Appointment;
import com.example.x.Model.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByStylistAndDateTimeBetween(Stylist stylist, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Appointment> findByClientId(Long clientId);

    List<Appointment> findByClientIdAndDateTimeBetween(Long clientId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
