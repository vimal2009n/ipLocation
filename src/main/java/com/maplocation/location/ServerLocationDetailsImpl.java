package com.maplocation.location;



import java.io.InputStream;
import java.net.InetAddress;
import org.springframework.stereotype.Component;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;

@Component
public class ServerLocationDetailsImpl implements ServerLocationDetails {

	public ServerLocation getLocation(String ipAddres) {

		String dataFile = "/location/GeoLite2-City.mmdb";
		return getLocation(ipAddres, dataFile);
	}

	private ServerLocation getLocation(String ipAddress, String locationDataFile) {
		ServerLocation serverLocation = null;

		InputStream stream = getClass().getResourceAsStream(locationDataFile);
        System.out.println(stream);
        
		if (stream == null) {
			System.out.println("location database is not found "
					+ locationDataFile);
		} else {

			try {
				serverLocation = new ServerLocation();

				DatabaseReader reader = new DatabaseReader.Builder(stream)
						.build();

				InetAddress ipaddrs = InetAddress.getByName(ipAddress);
				CityResponse response = reader.city(ipaddrs);

				if (response != null) {
					serverLocation.setCountryCode(response.getCountry()
							.getIsoCode());
					serverLocation.setCountryName(response.getCountry()
							.getName());
					serverLocation.setCity(response.getCity().getName());
					serverLocation
							.setPostalCode(response.getPostal().getCode());
					serverLocation.setRegion(""
							+ response.getLocation().getAccuracyRadius());
					serverLocation.setRegionName(response.getLocation()
							.getTimeZone());
					serverLocation.setLatitude(String.valueOf(response
							.getLocation().getLatitude()));
					serverLocation.setLongitude(String.valueOf(response
							.getLocation().getLongitude()));
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return serverLocation;
	}

	

}
