package com.maplocation.service;

import java.util.List;

import com.maplocation.entity.Geo;
import com.maplocation.location.ServerLocationName;

public interface GeoService {
	
	 public List<ServerLocationName> getLatLngByName(String name);
	 public Geo getLaLngById(long selected);
	

}
