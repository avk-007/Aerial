package com.Flight_Reservation_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_app.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
