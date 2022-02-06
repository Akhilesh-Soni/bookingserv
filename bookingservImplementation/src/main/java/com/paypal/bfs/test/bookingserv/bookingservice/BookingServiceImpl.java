package com.paypal.bfs.test.bookingserv.bookingservice;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repository.BookingData;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service

public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(final Booking booking) {

        final BookingData save = bookingRepository.save(BookingData.from(booking));
        return BookingData.to(save);
    }

    @Override
    public List<Booking> getAllBookings() {
        final Iterable<BookingData> allBookings = bookingRepository.findAll();
        List<Booking> list = new ArrayList<>();
        allBookings.forEach(ab -> list.add(BookingData.to(ab)));
        return list;
    }
}
