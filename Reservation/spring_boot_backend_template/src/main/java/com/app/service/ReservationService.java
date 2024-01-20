package com.app.service;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Reservation;
import com.app.repository.ReservationRepository;
import com.app.repository.RoomRepository;

//ReservationService.java
@Service
public class ReservationService {
@Autowired
private ReservationRepository reservationRepository;

public Reservation createReservation(Reservation reservation)  {
//   if (hasConflictingReservation(reservation)) {
//       throw new ConflictException("Conflicting reservation: Another reservation exists for the same room and overlapping dates");
//   }

   double totalPrice = calculateTotalPrice(reservation);
   reservation.setTotalPrice(totalPrice);
   return reservationRepository.save(reservation);
}

public void cancelReservation(Long reservationId) {
   reservationRepository.deleteById(reservationId);
}

// Other reservation-related methods

private boolean hasConflictingReservation(Reservation reservation) {
   List<Reservation> conflictingReservations = reservationRepository.findByRoomIdAndCheckOutDateAfterAndCheckInDateBefore(
           reservation.getRoomId(),
           reservation.getCheckInDate(),
           reservation.getCheckOutDate());

   return !conflictingReservations.isEmpty();
}

private double calculateTotalPrice(Reservation reservation) {
   // Add your logic for calculating the total price based on reservation details
   // This is just a placeholder, you may need to adjust it according to your business logic
   return reservation.getTotalPrice() * calculateNumberOfNights(reservation);
}

private int calculateNumberOfNights(Reservation reservation) {
   return (int) ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
}
}

