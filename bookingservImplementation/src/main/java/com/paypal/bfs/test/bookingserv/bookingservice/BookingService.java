package com.paypal.bfs.test.bookingserv.bookingservice;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import java.util.List;

public interface BookingService {

    Booking createBooking(final Booking booking);

    List<Booking> getAllBookings();
}
