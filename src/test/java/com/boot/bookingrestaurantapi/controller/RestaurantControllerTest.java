package com.boot.bookingrestaurantapi.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import com.boot.bookingrestaurantapi.controllers.RestaurantController;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.RestaurantService;

public class RestaurantControllerTest {
	
	private static final Long RESTAURANT_ID = 1L;
	private static final String SUCCES_STATUS = "Succes";
	private static final String SUCCES_CODE = "200 OK";
	private static final String OK = "OK";
	
	@Mock
	RestaurantService restaurantService;
	
	@InjectMocks 
	RestaurantController restaurantController;
	
	
	@Before
	public void init() throws BookingException{
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void getRestaurantByIdTest() throws BookingException{
		final BookingResponse<RestaurantRest> respose = restaurantController.getRestaurantById(RESTAURANT_ID);
		
		assertEquals(respose.getStatus(), SUCCES_STATUS);
		assertEquals(respose.getCode(), SUCCES_CODE);
		assertEquals(respose.getMessage(), OK);
		//assertEquals(respose.getData(), RESTAURANT_REST);
	}

}
