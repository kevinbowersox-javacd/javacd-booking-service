package com.linkedin.javacd.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.linkedin.javacd.entities.Booking;
import com.linkedin.javacd.repositories.BookingRepository;

@Service
public class BasicBookingService implements BookingService {

	private RoomService roomService;
	private GuestService guestService; 
	private BookingRepository bookingRepository;

	@Autowired
	public BasicBookingService(RoomService roomService, GuestService guestService, BookingRepository bookingRepository) {
		this.roomService = roomService;
		this.guestService = guestService;
		this.bookingRepository = bookingRepository;
	}

	@Override
	public Booking create(Long guestId, Long roomId, Instant startDate, Instant endDate) {
		
		if(!this.roomService.isAvailable(roomId) || !this.guestService.isRegistered(guestId)) {
			throw new RuntimeException("Unable to book");
		}
		
		return this.bookingRepository.save(new Booking(guestId, roomId, startDate, endDate)); 
	}

	@Override
	public Optional<Booking> findById(Long id) {
		return this.bookingRepository.findById(id); 
	}

	@Override
	public List<Booking> list() {
		return this.bookingRepository.findAll(); 
	}

	@Override
	public List<Booking> listAvailable() {
		return this.bookingRepository.findByStartDateAfter(Instant.now().minus(1, ChronoUnit.DAYS));
	}

}
