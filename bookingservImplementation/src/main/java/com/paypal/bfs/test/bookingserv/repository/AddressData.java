package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.api.model.Address;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressData {

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipCode")
    private String zipCode;

    public AddressData() {
    }

    public AddressData(final String line1, final String line2, final String city, final String state, final String zipCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public static AddressData from(final Address address) {
        return new AddressData(address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getZipCode());
    }

    public static Address to(final AddressData address) {
        return new Address(address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getZipCode());
    }


    public String getLine1() {
        return line1;
    }

    public void setLine1(final String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(final String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }
}
