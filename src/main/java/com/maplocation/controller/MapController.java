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
		
		System.out.println(geoName);
		String txtName = WordUtils.capitalizeFully(geoName);
		
		System.out.println(txtName);
		
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
	String getDomainInJsonFormatSelectedName(@RequestParam String selectName){
		
		System.out.println(selectName);
		String txtName = WordUtils.capitalizeFully(selectName);
		
		      ServerLocationName geoLatLon = geoDao.getLatLngBySelectedName(txtName);
		      String str="";
		       ObjectMapper mapper=new ObjectMapper();
		       try {
				str=mapper.writeValueAsString(geoLatLon);
		       } catch (Exception e) {
				e.printStackTrace();
			}
			return str;
	}
		
}
