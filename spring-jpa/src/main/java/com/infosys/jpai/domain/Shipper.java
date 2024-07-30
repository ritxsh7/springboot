package com.infosys.jpai.domain;

import com.infosys.jpai.dto.ShipperDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipper {
	
	@Id
	@Column(name="shipper_id")
	private Integer ShipperID;
	
	@Column(name="company_name")
	private String CompanyName;
	
	@Column(name="phone_no")
	private Integer PhoneNo;
	
	public static ShipperDTO prepareShipperDTO(Shipper shipper) {
		return new ShipperDTO(shipper.getShipperID(), shipper.getCompanyName(), shipper.getPhoneNo());
	}
}
