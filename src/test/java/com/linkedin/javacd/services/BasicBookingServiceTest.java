package com.linkedin.javacd.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.linkedin.javacd.entities.Booking;

@SpringBootTest
@ActiveProfiles(profiles = "local")
class BasicBookingServiceTest {

	@Autowired
	private BookingService bookingService; 
	
	@Test
	void testList() {
		
		List<Booking> bookings = this.bookingService.list();
		assertFalse(bookings.isEmpty());
	}

}
