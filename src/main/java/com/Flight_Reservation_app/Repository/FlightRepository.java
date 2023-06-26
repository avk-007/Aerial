package com.Flight_Reservation_app.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Flight_Reservation_app.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	//@Query will helps us to define how you want to  perform a search operation
	//list is used b/c several flights are out here
	
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to, 
			@Param("dateOfDeparture") Date departureDate);

}
