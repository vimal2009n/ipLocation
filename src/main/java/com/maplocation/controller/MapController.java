package com.maplocation.controller;


import java.util.List;

import org.apache.commons.lang3.text.WordUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maplocation.dao.GeoDao;
import com.maplocation.entity.Geo;
import com.maplocation.location.ServerLocation;
import com.maplocation.location.ServerLocationDetails;
import com.maplocation.location.ServerLocationName;

@Controller
public class MapController {

	@Autowired
	ServerLocationDetails serverLocationDetails;
	@Autowired
	GeoDao geoDao;
	
	@RequestMapping(value="/")
	public ModelAndView getMapPage(){
		
		return new ModelAndView("maplocation");
	}
	
	@RequestMapping(value="getLocationByIpAddress",method=RequestMethod.GET)
	public @ResponseBody
	String getDomainInJsonFormat(@RequestParam String ipAddress){
		
		System.out.println(ipAddress);
		// like JsonParser
		ObjectMapper mapper = new ObjectMapper();
         
		ServerLocation location= serverLocationDetails.getLocation(ipAddress);
		String result = "";
		try {
				result = mapper.writeValueAsString(location);
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	
	@RequestMapping(value="getLocationByName",method=RequestMethod.GET)
	public @ResponseBody
	String getDomainInJsonFormatName(@RequestParam String geoName){
		
			   String txtName = WordUtils.capitalizeFully(geoName);
		       List<ServerLocationName> geoLatLon = geoDao.getLatLngByName(txtName);
		       String result="";
		       ObjectMapper mapper = new ObjectMapper();
		       try {
				
		    	    result = mapper.writeValueAsString(geoLatLon);
				
		       } catch (Exception e) {
				
				e.printStackTrace();
		       } 
		   
			return result;
	}
	//**********************************selected by Id**************************
	@RequestMapping(value="getLocationSelectedById",method=RequestMethod.GET)
	public @ResponseBody
	String getDomainInJsonFormatSelectedName(@RequestParam long selectName){
		
		
		      Geo geoLatLon = geoDao.getLaLngById(selectName);
		      
		      ServerLocationName locationDetails=new ServerLocationName();
		      locationDetails.setId(geoLatLon.getGeoId());
		      locationDetails.setLocationName(geoLatLon.getCity());
		      locationDetails.setLat(geoLatLon.getLat());
		      locationDetails.setLon(geoLatLon.getLng());
		    
		      String str="";
		       ObjectMapper mapper=new ObjectMapper();
		       try {
				str=mapper.writeValueAsString(locationDetails);
		       } catch (Exception e) {
				e.printStackTrace();
			}
			return str;
	}
		
}