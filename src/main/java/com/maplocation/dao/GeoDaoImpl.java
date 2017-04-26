package com.maplocation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maplocation.entity.Geo;
import com.maplocation.location.ServerLocationName;
import com.maplocation.util.HibernateUtil;

@Repository
@Transactional
public class GeoDaoImpl implements GeoDao{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ServerLocationName> getLatLngByName(String name) {

		String query = "SELECT geoId,city,lat,lng FROM Geo  WHERE city Like '"+ name +"%'";
		
		List<Object[]> cityObjects = hibernateUtil.fetchAll(query);
		
			List<ServerLocationName> cities = new ArrayList<ServerLocationName>();
			for(Object[] cityObject: cityObjects) {
			ServerLocationName city = new ServerLocationName();
			
			long id = ((Integer) cityObject[0]).longValue();	
			String cityName =  (String) cityObject[1];
			String lat = (String) cityObject[2];
			String lon = (String) cityObject[3];
			
			city.setId(id);
			city.setLocationName(cityName);
			city.setLat(lat);
			city.setLon(lon);
			cities.add(city);
		}
		return cities;
	}
	
	@Override
	public Geo getLaLngById(long id) {
		
		return hibernateUtil.fetchById(id, Geo.class);
	}

}
