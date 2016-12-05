package com.restaurant.domain;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Document(collection = "restaurant")
public class Restaurant {
	
	@Id
	@JsonProperty(access = Access.READ_ONLY)
	private String id;
	
	private String name;
	private String cnpj;
	private Double price;
	private Double discount;
	
	@NotNull
	private GeoJsonPoint location;
	
	public Restaurant(){}
	public Restaurant(String name, String cnpj, Double price, Double discount, GeoJsonPoint location) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.price = price;
		this.discount = discount;
		this.location = location;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", price=" + price + ", discount="
				+ discount + ", geolication=" + location + "]";
	}

}
