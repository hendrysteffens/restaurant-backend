package com.restaurant.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.domain.Restaurant;
import com.restaurant.domain.RestaurantImage;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.services.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired RestaurantRepository restaurantRepository;
	@Value("${S3.AccessKeyS3}")
	private String accessKeyS3;
	@Value("${S3.SecretKeyS3}")
	private String secretKeyS3;
	@Override
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public void insert(Restaurant restaurant) {
		restaurantRepository.insert(restaurant);
	}

	@Override
	public Optional<Restaurant> findById(String id) {
		return Optional.ofNullable(restaurantRepository.findOne(id));
	}

	@Override
	public void update(Restaurant restaurant) {
		restaurantRepository.save(restaurant);	
	}

	@Override
	public void removeById(String id) {
		restaurantRepository.delete(id);
	}

	@Override
	public List<Restaurant>findAllByLocation(double lat, double lon, double d) {
		Distance distance = new Distance(d,Metrics.KILOMETERS);
		Point currentPos = new Point(lat, lon);
		return restaurantRepository.findByLocationNear(currentPos, distance);
	}

	@Override
	public RestaurantImage uploadRestaurantImage(MultipartFile file) {
		return null;
	}
	


}
