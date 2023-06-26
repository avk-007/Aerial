package com.Flight_Reservation_app.service;

import com.Flight_Reservation_app.Entity.Reservation;
import com.Flight_Reservation_app.dto.ReservationRequest;

public interface ReservationService {
	
	
	Reservation bookFlight(ReservationRequest request);

	
}
