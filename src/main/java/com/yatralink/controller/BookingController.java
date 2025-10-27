package com.yatralink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatralink.model.Booking;
import com.yatralink.model.User;
import com.yatralink.service.BookingService;
import com.yatralink.service.UserService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @GetMapping("/user/{email}")
    public List<Booking> getBookingByUser(@PathVariable String email){
        User user=userService.getUserByEmail(email);
        return bookingService.getBookingsByUser(user);
    }

    @GetMapping("/me")
    public List<Booking> myBookings(@AuthenticationPrincipal UserDetails userDetails){
        String email=userDetails.getUsername(); // email
        User user=userService.getUserByEmail(email);
        return bookingService.getBookingsByUser(user);
    }

    @PutMapping("/cancel/{id}")
    public Booking cancelBooking(@PathVariable Long id){
        return bookingService.cancelBooking(id);
    }

}
