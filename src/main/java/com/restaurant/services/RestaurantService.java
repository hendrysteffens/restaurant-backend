package com.restaurant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.domain.Restaurant;
import com.restaurant.domain.RestaurantImage;

@Service
public interface RestaurantService {

	List<Restaurant>findAll();
	
	Optional<Restaurant> findById(String id);
	
	void insert(Restaurant restaurant);
	
	void update(Restaurant restaurant);
	
	void removeById(String id);
	
	List<Restaurant> findAllByLocation(double lat, double lon, double d);
	
	RestaurantImage uploadRestaurantImage(MultipartFile file);
	
}
