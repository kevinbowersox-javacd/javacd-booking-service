package com.linkedin.javacd.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.linkedin.javacd.entities.Booking;

public interface BookingService {
	
	public Optional<Booking> findById(Long id);

	public List<Booking> list();
	
	public List<Booking> listAvailable();

	public Booking create(Long guestId, Long roomId, Instant startDate, Instant endDate);
	
}
