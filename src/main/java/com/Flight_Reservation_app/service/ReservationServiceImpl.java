package com.Flight_Reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Flight_Reservation_app.Entity.Flight;
import com.Flight_Reservation_app.Entity.Passenger;
import com.Flight_Reservation_app.Entity.Reservation;
import com.Flight_Reservation_app.Repository.FlightRepository;
import com.Flight_Reservation_app.Repository.PassengerRepository;
import com.Flight_Reservation_app.Repository.ReservationRepository;
import com.Flight_Reservation_app.Utilities.EmailUtil;
import com.Flight_Reservation_app.Utilities.PDFgenerator;
import com.Flight_Reservation_app.dto.ReservationRequest;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	
	@Autowired
	private PDFgenerator PDFgenerator;
	
	@Autowired
	private EmailUtil emailUtil;;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		 
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName( request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		Long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		long id = reservation.getId();
		
		String filePath = "G:\\flight reservataion backup\\Flight_Reservation_app\\tickets\\BOOKING" +
				passenger.getId()
				+ ".pdf";
		reservationRepo.save(reservation);
		
		PDFgenerator.generateItinerary(reservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return reservation;
	}

}
