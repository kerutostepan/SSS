package com.example.x.Service;

import com.example.x.Model.Appointment;
import com.example.x.Model.Client;
import com.example.x.Model.Stylist;
import com.example.x.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public boolean isAppointmentAvailable(Stylist stylist, LocalDateTime dateTime) {
        LocalDateTime startDateTime = dateTime.minusMinutes(30);
        LocalDateTime endDateTime = dateTime.plusMinutes(30);

        List<Appointment> appointments = appointmentRepository.findByStylistAndDateTimeBetween(stylist, startDateTime, endDateTime);
        return appointments.isEmpty();
    }

    public boolean canClientBookAppointment(Long clientId, LocalDateTime dateTime) {
        LocalDateTime startDateTime = dateTime.minusMinutes(30);
        LocalDateTime endDateTime = dateTime.plusMinutes(30);

        List<Appointment> clientAppointments = appointmentRepository.findByClientIdAndDateTimeBetween(clientId, startDateTime, endDateTime);
        return clientAppointments.isEmpty();
    }

    public Appointment bookAppointment(Stylist stylist, Client client, LocalDateTime dateTime) {
        if (isAppointmentAvailable(stylist, dateTime) && canClientBookAppointment(client.getId(), dateTime)) {
            Appointment appointment = new Appointment();
            appointment.setStylist(stylist);
            appointment.setClient(client);
            appointment.setDateTime(dateTime);
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    public void deleteAppointmentById(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
