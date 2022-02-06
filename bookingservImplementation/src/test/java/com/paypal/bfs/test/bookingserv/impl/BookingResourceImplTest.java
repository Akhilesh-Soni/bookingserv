package com.paypal.bfs.test.bookingserv.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.bookingserv.BookingServApplication;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = BookingServApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class BookingResourceImplTest {

    @Autowired
    private MockMvc mvc;

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldReturn400CreateBookingsIfBookingIsEmpty() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(new Booking()))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfFirstNameIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, " ", "soni",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"), 100, 50, new Address("l1", " ", "ci1", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfLastNameIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "   ",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"), 100, 50, new Address("l1", " ", "ci1", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfDOBIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                null,
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"), 100, 50, new Address("l1", " ", "ci1", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfCheckInDateTimeIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                null,
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"), 100, 50, new Address("l1", " ", "ci1", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfCheckOutDateTimeIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                null, 100, 50, new Address("l1", " ", "ci1", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfTotalPriceIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"), null, 50, new Address("l1", " ", "ci1", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfDepositIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"), 100, null, new Address("l1", " ", "ci1", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


    @Test
    void shouldReturn400CreateBookingsIfAddressIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"), 100, 50, null);
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfLine1InAddressIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                100, 50,
                new Address(" ", " ", "ci1", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfCityInAddressIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                100, 50,
                new Address("line1", " ", "  ", "s1", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void shouldReturn400CreateBookingsIfStateInAddressIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                100, 50,
                new Address("line1", " ", "c1", "  ", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


    @Test
    void shouldReturn400CreateBookingsIfZipCodeInAddressIsEmpty() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                100, 50,
                new Address("line1", " ", "c1", "s1", "   "));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


    @Test
    void shouldReturn201CreateBookings() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                100, 50,
                new Address("line1", " ", "c1", " sq", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }

    @Test
    void shouldReturn409IfDuplicateRecord() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                100, 50,
                new Address("line1", " ", "c1", " sq", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE));
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn();
        Assertions.assertEquals("Duplicate Booking.", mvcResult.getResponse().getErrorMessage());
    }


    @Test
    void shouldReturnAllBookings() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                100, 50,
                new Address("line1", " ", "c1", " sq", "z1"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/bfs/booking")
                        .content(asJsonString(obj))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));

        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/v1/bfs/booking"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        final ObjectMapper mapper = new ObjectMapper();
        List<Booking> bookings = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Booking>>() {
        });
        Assertions.assertEquals(bookings.size(), 1);

    }

    @Test
    public void testIdempotencyOfCreateRequest() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Booking obj = new Booking(null, "akh", "so",
                simpleDateFormat.parse("1994-02-28"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                simpleDateFormat.parse("2022-02-06T08:56:45.486Z"),
                100, 50,
                new Address("line1", " ", "c1", " sq", "z1"));
        int numberOfThreads = 2;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        final CountDownLatch latch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            service.submit(() -> {
                try {
                    mvc.perform(MockMvcRequestBuilders
                            .post("/v1/bfs/booking")
                            .content(asJsonString(obj))
                            .contentType(MediaType.APPLICATION_JSON_VALUE));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }
        latch.await();
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/v1/bfs/booking"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        final ObjectMapper mapper = new ObjectMapper();
        List<Booking> bookings = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Booking>>() {
        });
        Assertions.assertEquals(bookings.size(), 1);

    }

    @Test
    void getAllBookingsShouldHaveEmptyBookings() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/v1/bfs/booking"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]", true));

    }
}