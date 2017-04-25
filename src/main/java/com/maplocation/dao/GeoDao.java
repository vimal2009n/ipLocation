package com.maplocation.dao;

import java.util.List;
import com.maplocation.location.ServerLocationName;

public interface GeoDao {
	
	 public List<ServerLocationName> getLatLngByName(String name);
	public ServerLocationName getLatLngBySelectedName(String selection);

}
