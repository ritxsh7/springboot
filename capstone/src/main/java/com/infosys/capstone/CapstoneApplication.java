package com.infosys.capstone;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import com.infosys.capstone.config.JDBCConfig;
import com.infosys.capstone.dao.CustomerDAO;
import com.infosys.capstone.dao.CustomerDAOImpl;
import com.infosys.capstone.dao.FlightDAO;
import com.infosys.capstone.dao.FlightDAOImpl;
import com.infosys.capstone.model.Customer;
import com.infosys.capstone.model.Flight;

@SpringBootApplication
public class CapstoneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);

		// Access the Data Access Beans
		CustomerDAO customer = context.getBean(CustomerDAOImpl.class);
		FlightDAO flight = context.getBean(FlightDAOImpl.class);

		Scanner sc = new Scanner(System.in);

		Integer choice = 0;

		do {
			System.out.println("================MENU FOR INFYGO BOOKING===================");
			System.out.println("\n1. BOOK A FLIGHT");
			System.out.println("2. UPDATE CUSTOMER DETAILS FOR A FLIGHT ");
			System.out.println("3. DISPLAY FLIGHTS TO A CITY");
			System.out.println("4. CANCEL FLIGHT");
			System.out.println("5. DISPLAY YOUR FLIGHTS");
			System.out.println("6. EXIT");

			System.out.println("\nEnter your choice :");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.println("Enter flight name : ");
				String flightName = sc.nextLine();
				System.out.println("Enter Starting city : ");
				String source = sc.nextLine();
				System.out.println("Enter Destination city : ");
				String destination = sc.nextLine();
				System.out.println("Enter your Customer Id : ");
				String CustId = sc.nextLine();
				System.out.println("Enter the seat no : ");
				String seatNo = sc.nextLine();
				
				//System generated Flight ID
				String FID = CustId + source.charAt(0) + destination.charAt(0) + seatNo;

				Flight myFlight = new Flight(FID, flightName, source, destination, CustId, seatNo);

				if (flight.bookFlight(myFlight)) {
					System.out.println("Flight booked successfully");
				}

				break;

			case 2:

					Customer myCustomer = new Customer();
	
					System.out.println("Enter your flight ID : ");
					String FlightId = sc.nextLine();
	
					try {
						myCustomer = customer.getCustomerFromFlightID(FlightId);
						myCustomer.setPhone("9878721033");
	
						if (customer.update(myCustomer)) {
							System.out.println("Customer updated successfully");
						}
	
					} catch (DataAccessException e) {
						System.out.println(e);
					}
				break;

			case 3:
				
				System.out.println("Enter the destination city");
				String city = sc.nextLine();
				
				System.out.println("Displaying all flights to " + city);

				for (Flight f : flight.displayFlightsForDestination(city)) {
					System.out.println(f);
				}

				break;
			case 4:
				System.out.println("Enter the flight ID to cancel : ");
				String id = sc.nextLine();
				
				try {
					if(flight.cancelFlight(id)) {
						System.out.println("Flight cancelled successfully");
					}
				} catch (DataAccessException e) {
					System.out.println(e);
				}
				break;
			
			case 5: 
				System.out.println("Enter your Customer ID: ");
				String CID = sc.nextLine();
				
				try {
					
					for(Flight fl : flight.displayFlightForCustomer(CID)) {
						System.out.println(fl);
					}
				}catch (DataAccessException e) {
					System.out.println(e);
				}
				
				break;
			} 

		} while (choice != 6);

	}
}
