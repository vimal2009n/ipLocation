package com.maplocation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;
@Entity
@Table(name="Geo")
public class Geo implements Serializable{
	
	private static final long serialVersionUID = -7988799579036225137L;
			
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long geoId;
	
	@Column
	private String city;
	
	@Column
	private String city_ascii;
	
	@Column
	private String lat;
	
	@Column
	private String lng;
	
	@Column
	private String pop;
	
	@Column
	private String country;
	
	@Column
	private String iso2;
	
	@Column
	private String iso3;
	
	@Column
	private String province;
	
	public long getGeoId() {
		return geoId;
	}

	public void setGeoId(long geoId) {
		this.geoId = geoId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_ascii() {
		return city_ascii;
	}

	public void setCity_ascii(String city_ascii) {
		this.city_ascii = city_ascii;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getPop() {
		return pop;
	}

	public void setPop(String pop) {
		this.pop = pop;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
