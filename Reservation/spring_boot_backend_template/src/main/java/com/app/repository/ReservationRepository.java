package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Reservation;

//ReservationRepository.java
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
List<Reservation> findByRoomIdAndCheckOutDateAfterAndCheckInDateBefore(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);
}