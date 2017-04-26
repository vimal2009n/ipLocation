package com.maplocation.dao;

import java.util.List;

import com.maplocation.entity.Geo;
import com.maplocation.location.ServerLocationName;

public interface GeoDao {
	
	 public List<ServerLocationName> getLatLngByName(String name);
	 public Geo getLaLngById(long selected);
	 

}
