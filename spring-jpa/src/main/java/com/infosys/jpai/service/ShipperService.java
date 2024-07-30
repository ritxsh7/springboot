package com.infosys.jpai.service;

import java.util.List;

import com.infosys.jpai.domain.Shipper;
import com.infosys.jpai.dto.ShipperDTO;

public interface ShipperService {
	public List<Shipper> fetchShipperList();
	public void insertShipper(Shipper s);
	public void removeShipper(Integer shipperId);
	public Shipper getShipperID(Integer shipperId);
	public String updateShipper(Integer shipperID, String companyName);
}
