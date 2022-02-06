package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "booking_data", uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name"})})
public class BookingData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firsName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "checkin_datetime")
    private Date checkInDateTime;

    @Column(name = "checkout_datetime")
    private Date checkOutDateTime;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "deposit")
    private int deposit;

    @Column(name = "address")
    private AddressData address;

    public BookingData() {
    }

    public BookingData(final String firsName,
                       final String lastName,
                       final Date dateOfBirth,
                       final Date checkInDateTime,
                       final Date checkOutDateTime,
                       final int totalPrice,
                       final int deposit,
                       final AddressData address) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.address = address;
    }

    public static BookingData from(final Booking booking) {
        return new BookingData(
                booking.getFirstName(),
                booking.getLastName(),
                booking.getDateOfBirth(),
                booking.getCheckinDatetime(),
                booking.getCheckoutDatetime(),
                booking.getTotalPrice(),
                booking.getDeposit(),
                AddressData.from(booking.getAddress()));
    }

    public static Booking to(BookingData bookingData) {
        Booking booking = new Booking();
        booking.setId(bookingData.getId());
        booking.setFirstName(bookingData.getFirsName());
        booking.setLastName(bookingData.getLastName());
        booking.setDateOfBirth(bookingData.getDateOfBirth());
        booking.setCheckinDatetime(bookingData.getCheckInDateTime());
        booking.setCheckoutDatetime(bookingData.getCheckOutDateTime());
        booking.setTotalPrice(bookingData.getTotalPrice());
        booking.setDeposit(bookingData.getDeposit());
        booking.setAddress(AddressData.to(bookingData.getAddress()));
        return booking;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(final String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(final Date checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    public Date getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public void setCheckOutDateTime(final Date checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(final int deposit) {
        this.deposit = deposit;
    }

    public AddressData getAddress() {
        return address;
    }

    public void setAddress(final AddressData address) {
        this.address = address;
    }
}
