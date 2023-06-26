package com.Flight_Reservation_app.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Flight_Reservation_app.Entity.Reservation;
import com.Flight_Reservation_app.Repository.ReservationRepository;
import com.Flight_Reservation_app.dto.ReservationUpdateRequest;

@RestController // its convert the java Object to JSON Object and JSON Object to java object
public class ReservationRestController {
	@Autowired
	private ReservationRepository reservationRepo;
   
	
	 //http://localhost:8080/flights/reservation/{id}
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	
	//http://localhost:8080/flights/reservation
	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepo.save(reservation);
	}
}
