package com.yatralink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yatralink.model.Booking;
import com.yatralink.model.User;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByUser(User user);
}
