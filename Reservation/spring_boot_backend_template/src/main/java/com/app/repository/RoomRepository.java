package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Room;

//RoomRepository.java
public interface RoomRepository extends JpaRepository<Room, Long> {
 List<Room> findByAvailabilityTrue();
}


