package com.devskiller.orders;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersAnalyzer {

	private BigDecimal valueOrderLine = BigDecimal.ZERO;
	private BigDecimal valueOrder = BigDecimal.ZERO;
	private int numDias = 0;
	private BigDecimal average = BigDecimal.ZERO;

	static class Order {
		LocalDateTime creationDate;
		List<OrderLine> orderLines;
	}

	static class OrderLine {
		int quantity;
		BigDecimal unitPrice;
	}

	public Map<DayOfWeek, Integer> averageDailySales(List<Order> orders) throws IOException, URISyntaxException {
		URL res = getClass().getClassLoader().getResource("orders.json");
		File file = Paths.get(res.toURI()).toFile();
		String absolutePath = file.getAbsolutePath();

		List<OrdersAnalyzer.Order> list = OrdersHelper.readOrders(absolutePath);

		Map<DayOfWeek, Integer> mapDays = new HashMap<>();

		Arrays.stream(DayOfWeek.values()).forEach(d ->
		{
			
			list.forEach(order->
					{

						if(d.equals(order.creationDate.getDayOfWeek())){
							numDias++;
							order.orderLines.forEach(lines->
									{
										valueOrderLine = BigDecimal.valueOf(lines.quantity).multiply(lines.unitPrice);

										valueOrder = valueOrder.add(valueOrderLine);

									}
									);

						}

					}

			);

			if(numDias > 0){
				average =  valueOrder.divide(BigDecimal.valueOf( numDias),0, RoundingMode.HALF_UP);
			}

			mapDays.put(d, average.intValue());
			numDias = 0;
			average = BigDecimal.ZERO;
			valueOrder = BigDecimal.ZERO;
			valueOrderLine = BigDecimal.ZERO;
		}

		);

		return mapDays;

	}

}
