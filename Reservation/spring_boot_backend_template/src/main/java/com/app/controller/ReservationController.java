package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Reservation;
import com.app.service.ReservationService;


@RestController
@RequestMapping("/reservations")
public class ReservationController {
 @Autowired
 private ReservationService reservationService;

 // Other endpoints...

 // Endpoint: Create Reservation
 @PostMapping
 public ResponseEntity<Reservation> createReservation(@RequestBody @Valid Reservation reservation) {
     try {
         Reservation createdReservation = reservationService.createReservation(reservation);
         return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
     }
 }

 // Endpoint: Cancel Reservation
 @DeleteMapping("/{reservationId}")
 public ResponseEntity<String> cancelReservation(@PathVariable Long reservationId) {
     reservationService.cancelReservation(reservationId);
     return ResponseEntity.ok("Reservation canceled successfully");
 }

 // Other reservation-related endpoints
}
