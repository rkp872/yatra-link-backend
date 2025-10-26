package com.yatralink.service;

import java.util.List;

import com.yatralink.model.Booking;
import com.yatralink.model.User;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getBookingsByUser(User user);
    Booking cancelBooking(Long bookingId);
}
