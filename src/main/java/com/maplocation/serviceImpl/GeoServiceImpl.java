package com.maplocation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplocation.dao.GeoDao;
import com.maplocation.location.ServerLocationName;
import com.maplocation.entity.Geo;
import com.maplocation.service.GeoService;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GeoServiceImpl implements GeoService{
	
	@Autowired
	private GeoDao geoDao;

	@Override
	public List<ServerLocationName> getLatLngByName(String name) {
		
		return geoDao.getLatLngByName(name);
	}

	@Override
	public Geo getLaLngById(long selected) {
		return geoDao.getLaLngById(selected);
	}

}
