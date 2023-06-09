package com.jorgeguinto.reservation_demo;

import com.jorgeguinto.reservation_demo.model.AmenityType;
import com.jorgeguinto.reservation_demo.model.Reservation;
import com.jorgeguinto.reservation_demo.model.User;
import com.jorgeguinto.reservation_demo.repos.ReservationRepository;
import com.jorgeguinto.reservation_demo.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


@SpringBootApplication
public class ReservationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository,
                                      ReservationRepository reservationRepository) {
        return (args) -> {
            User user = userRepository.save(new User("Jorge Guinto", "jorgeguintop", bCryptPasswordEncoder().encode("12345")));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Reservation reservation = Reservation.builder()
                    .reservationDate(localDate)
                    .startTime(LocalTime.of(12, 00))
                    .endTime(LocalTime.of(13, 00))
                    .user(user)
                    .amenityType(AmenityType.POOL)
                    .build();

            reservationRepository.save(reservation);
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}