package com.Flight_Reservation_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_app.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

}
