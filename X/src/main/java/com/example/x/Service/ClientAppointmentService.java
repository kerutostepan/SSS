package com.example.x.Service;

import com.example.x.Model.Appointment;
import com.example.x.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getClientAppointments(Long clientId) {
        return appointmentRepository.findByClientId(clientId);
    }
}
