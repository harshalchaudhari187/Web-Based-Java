package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Reservation;
import com.app.pojos.Room;
import com.app.service.RoomService;

//RoomController.java
@RestController
@RequestMapping("/rooms")
public class RoomController {
 @Autowired
 private RoomService roomService;

 @GetMapping("/available")
 public ResponseEntity<List<Room>> getAvailableRooms() {
     List<Room> availableRooms = roomService.getAvailableRooms();
     return ResponseEntity.ok(availableRooms);
 }

}
