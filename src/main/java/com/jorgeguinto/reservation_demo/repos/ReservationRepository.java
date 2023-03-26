package com.jorgeguinto.reservation_demo.repos;

import com.jorgeguinto.reservation_demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
