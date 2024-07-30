package com.infosys.jpai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.jpai.domain.Shipper;
import com.infosys.jpai.dto.ShipperDTO;
import com.infosys.jpai.repository.ShipperRepository;

@Service
public class ShipperServiceImpl implements ShipperService{
	
	@Autowired
	ShipperRepository shipper;

	@Override
	public List<Shipper> fetchShipperList() {
		return (List<Shipper>) shipper.findAll();
	}

	@Override
	public void insertShipper(Shipper s) {
		shipper.saveAndFlush(s);
	}

	@Override
	public void removeShipper(Integer shipperId) {
		shipper.deleteById(shipperId);
	}

	@Override
	public Shipper getShipperID(Integer shipperId) {
		Optional<Shipper> oshipper = shipper.findById(shipperId);
		Shipper myShipper = oshipper.get();
		return myShipper;
	}

	@Override
	public String updateShipper(Integer shipperID, String companyName) {
		Optional<Shipper> oshipper = shipper.findById(shipperID);
		Shipper myShipper = oshipper.get();
		myShipper.setCompanyName(companyName);
		shipper.save(myShipper);
		return "Updated successfully";
	}
	
}
