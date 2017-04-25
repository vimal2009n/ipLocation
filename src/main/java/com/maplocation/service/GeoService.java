package com.maplocation.service;

import java.util.List;
import com.maplocation.location.ServerLocationName;

public interface GeoService {
	
	 public List<ServerLocationName> getLatLngByName(String name);
	 ServerLocationName getLatLngBySelectedName(String selection);
	

}
