package com.devskiller.orders;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersAnalyzerTest {

	private List<OrdersAnalyzer.Order> orders;

	@Before
	public void setUp() throws Exception {
		orders = OrdersTestHelper.readOrders("src/test/resources/orders.json");
	}

	@Test
	public void shouldReturnCorrectValueForMonday() throws IOException, URISyntaxException {
		// given
		OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

		// when
		Map<DayOfWeek, Integer> result = ordersAnalyzer.averageDailySales(orders);

		// then
		assertThat(result.get(DayOfWeek.MONDAY)).isEqualTo(37);
	}

	@Test
	public void shouldReturnCorrectValueForTuesday() throws IOException, URISyntaxException {
		//given
		OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

		// when
		Map<DayOfWeek, Integer> result = ordersAnalyzer.averageDailySales(orders);

		// then
		assertThat(result.get(DayOfWeek.TUESDAY)).isEqualTo(0);
	}

	@Test
	public void shouldReturnCorrectValueForWednesday() throws IOException, URISyntaxException {
		//given
		OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

		// when
		Map<DayOfWeek, Integer> result = ordersAnalyzer.averageDailySales(orders);

		// then
		assertThat(result.get(DayOfWeek.WEDNESDAY)).isEqualTo(0);
	}

	@Test
	public void shouldReturnCorrectValueForThursday() throws IOException, URISyntaxException {
		//given
		OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

		// when
		Map<DayOfWeek, Integer> result = ordersAnalyzer.averageDailySales(orders);

		// then
		assertThat(result.get(DayOfWeek.THURSDAY)).isEqualTo(0);
	}

	@Test
	public void shouldReturnCorrectValueForFriday() throws IOException, URISyntaxException {
		//given
		OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

		// when
		Map<DayOfWeek, Integer> result = ordersAnalyzer.averageDailySales(orders);

		// then
		assertThat(result.get(DayOfWeek.FRIDAY)).isEqualTo(0);
	}

	@Test
	public void shouldReturnCorrectValueForSaturday() throws IOException, URISyntaxException {
		//given
		OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

		// when
		Map<DayOfWeek, Integer> result = ordersAnalyzer.averageDailySales(orders);

		// then
		assertThat(result.get(DayOfWeek.SATURDAY)).isEqualTo(7);
	}

	@Test
	public void shouldReturnCorrectValueForSunday() throws IOException, URISyntaxException {
		//given
		OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

		// when
		Map<DayOfWeek, Integer> result = ordersAnalyzer.averageDailySales(orders);

		// then
		assertThat(result.get(DayOfWeek.SUNDAY)).isEqualTo(35);
	}
}
