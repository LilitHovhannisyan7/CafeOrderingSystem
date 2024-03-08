package com.example.CafeOrderingSystem;

import com.example.CafeOrderingSystem.entity.Bill;
import com.example.CafeOrderingSystem.entity.Order;
import com.example.CafeOrderingSystem.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
class ConsoleUI {

	@Autowired
	private OrderService orderService;

	private final Scanner scanner;

	public ConsoleUI() {
		this.scanner = new Scanner(System.in);
	}

	public void displayMainMenu() {
		System.out.println("---------------------------");
		System.out.println("University Café Ordering System");
		System.out.println("---------------------------");
		System.out.println("1. Place Order");
		System.out.println("2. View Orders");
		System.out.println("3. Cancel Order");
		System.out.println("4. Modify Order");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
	}

	public void run() {
		while (true) {
			displayMainMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					placeOrder();
					break;
				case 2:
					viewOrders();
					break;
				case 3:
					cancelOrder();
					break;
				case 4:
					modifyOrder();
					break;
				case 5:
					System.out.println("Exiting...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private void placeOrder() {

		System.out.println("Enter order details:");
		System.out.print("Waiter ID: ");
		int waiterId = scanner.nextInt();
		System.out.print("Table number: ");
		int tableNumber = scanner.nextInt();

		Order order = new Order();
		order.setWaiterId(waiterId);
		order.setTableNumber(tableNumber);

		orderService.placeOrder(order);
		System.out.println("Order placed successfully.");
	}

	private void viewOrders() {

		List<Order> orders = orderService.getAllOrders();

		if (orders.isEmpty()) {
			System.out.println("No orders found.");
		} else {
			System.out.println("Orders:");
			for (Order order : orders) {
				System.out.println(order.toString());
			}
		}
	}


	private void cancelOrder() {

		System.out.print("Enter order ID to cancel: ");
		int orderId = scanner.nextInt();

		orderService.cancelOrder(orderId);

		System.out.println("Order canceled successfully.");

	}

	private void modifyOrder() {

		System.out.print("Enter order ID to modify: ");
		int orderId = scanner.nextInt();

		Order modifiedOrder = new Order();
		modifiedOrder.setOrderId(orderId);
		orderService.modifyOrder(modifiedOrder);
		System.out.println("Order modified successfully.");

	}
}

@SpringBootApplication
public class CafeOrderingSystemApplication {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run(CafeOrderingSystemApplication.class, args);
		ConsoleUI consoleUI = context.getBean(ConsoleUI.class);
		consoleUI.run();
	}

}
