package com.infosys.jpai.dto;

import com.infosys.jpai.domain.Shipper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipperDTO {
	private Integer ShipperID;
	private String CompanyName;
	private Integer PhoneNo;
	
	
	public static Shipper prepareShipperEntity(ShipperDTO shipper) {
		return new Shipper(shipper.getShipperID(), shipper.getCompanyName(), shipper.getPhoneNo());
	}
}
