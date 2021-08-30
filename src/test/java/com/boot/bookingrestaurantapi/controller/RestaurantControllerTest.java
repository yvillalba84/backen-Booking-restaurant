package com.boot.bookingrestaurantapi.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.boot.bookingrestaurantapi.controllers.RestaurantController;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.RestaurantService;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RestaurantControllerTest {

    private static final Long RESTAURANT_ID = 1L;
    private static final String SUCCES_STATUS = "Succes";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";

    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    private AutoCloseable closeable;

    @Before
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void getRestaurantByIdTest() throws BookingException {
        final BookingResponse<RestaurantRest> respose = restaurantController.getRestaurantById(RESTAURANT_ID);

        assertEquals(respose.getStatus(), SUCCES_STATUS);
        assertEquals(respose.getCode(), SUCCES_CODE);
        assertEquals(respose.getMessage(), OK);
        //assertEquals(respose.getData(), RESTAURANT_REST);
    }

    @Test
    public void getRestaurantByIdAssertThatTest() throws BookingException {
        final BookingResponse<RestaurantRest> respose = restaurantController.getRestaurantById(RESTAURANT_ID);
        assertThat(respose)
                .isNotNull()
                .hasFieldOrPropertyWithValue("status", SUCCES_STATUS)
                .hasFieldOrPropertyWithValue("code", SUCCES_CODE)
                .hasFieldOrPropertyWithValue("message", OK);
    }

}
