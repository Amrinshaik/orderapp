package com.capgemini.orderapp;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.orderapp.controller.OrderController;
import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderControllerTest {

	private MockMvc mockMvc;

	@Mock
	OrderService orderService;

	@InjectMocks
	OrderController orderController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

	@Test
	public void testAddOrder() throws Exception {
		Order order = new Order(101, 2000, 111, LocalDate.of(2018,11,03));
		when(orderService.addOrder(Mockito.isA(Order.class))).thenReturn(order);
		String content = "{\r\n" + "  \"orderId\": 111,\r\n" + "  \"products\": 2000,\r\n"
				+ "  \"customerId\": 101,\r\n" + "  \"orderDate\": \"2018-11-03\"\r\n" + "}";
		mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON_UTF8).content(content)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(jsonPath("$.orderId").value(101));
	}

	@Test
	public void testGetOrder() throws Exception {
		Order order = new Order(101, 2000, 111, LocalDate.of(2018,11,03));
		when(orderService.findOrderById(101)).thenReturn(order);

		mockMvc.perform(get("/order/101").contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(jsonPath("$.orderId").value(101));
	}

	@Test
	public void testDeleteOrder() throws Exception {
		Order order = new Order(101, 2000, 111, LocalDate.of(2018,11,03));
		when(orderService.findOrderById(101)).thenReturn(order);

		mockMvc.perform(delete("/order/101").contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(status().isOk());

		verify(orderService, times(1)).deleteOrder(order);
	}
}