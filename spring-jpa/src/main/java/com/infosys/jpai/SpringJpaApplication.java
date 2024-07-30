package com.infosys.jpai;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.jpai.domain.Shipper;
import com.infosys.jpai.dto.ShipperDTO;
import com.infosys.jpai.service.ShipperService;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	private ShipperService shipper;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

//		INSERTING THE VALUE
//		ShipperDTO myShipper = new ShipperDTO(105, "Lenevo", 97866453);
//		Shipper newShipper = ShipperDTO.prepareShipperEntity(myShipper);
//		shipper.insertShipper(newShipper);
//		
//		DELETING RECORD BY ID
//		System.out.println("Enter the shipper ID : ");
//		Integer id = sc.nextInt();
//		shipper.removeShipper(id);
		
		
//		GET RECORD BY ID
		System.out.println("Enter the shipper ID to display : ");
		Integer findID = sc.nextInt();
		System.out.println(shipper.getShipperID(findID));
		
//		UPDATE RECORD BY ID
		System.out.println("Enter the shipper ID to update : ");
		Integer updateID = sc.nextInt();
		System.out.println("Enter the new company Name");
		String newCompanyName = sc.next();
		System.out.println(shipper.updateShipper(updateID, newCompanyName));

//		LISTING THE ENTRIES
		for (Shipper s : shipper.fetchShipperList()) {
			System.out.println(s);
		}
	}
}
