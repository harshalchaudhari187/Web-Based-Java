package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Room;
import com.app.repository.RoomRepository;

//RoomService.java
@Service
public class RoomService {
 @Autowired
 private RoomRepository roomRepository;

 public List<Room> getAvailableRooms() {
     return roomRepository.findByAvailabilityTrue();
 }

 // Other room-related methods
}
