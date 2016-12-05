package com.restaurant.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.restaurant.domain.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

	public List<Restaurant> findByLocationNear(Point location, Distance distance);
	
}
