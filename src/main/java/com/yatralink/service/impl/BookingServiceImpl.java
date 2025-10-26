package com.yatralink.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatralink.model.Booking;
import com.yatralink.model.User;
import com.yatralink.repository.BookingRepository;
import com.yatralink.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
       booking.setStatus("BOOKED");
       return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(User user) {
      return bookingRepository.findByUser(user);
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
      Booking booking = bookingRepository.findById(bookingId).orElse(null);
      if(booking!=null){
        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
      }
      return null;
    }

}
