package com.restaurant.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.domain.Restaurant;
import com.restaurant.services.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantEndpoint {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(path = "",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Restaurant> findAllRestaurants(){
		return restaurantService.findAll();
	}
	
	@RequestMapping(path = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Restaurant findRestaurantById(@PathVariable String id){
		return restaurantService.findById(id).get();
	}
	
	@RequestMapping(path = "/location",
			params = { "lat", "lng", "distance"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Restaurant> findAllRestaurantsByLocation(@RequestParam Double lat, @RequestParam Double lng, @RequestParam Double distance) {
    	return restaurantService.findAllByLocation(lat,lng,distance);
	} 
	
	@RequestMapping(path = "/insert",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void insert(@RequestParam Restaurant restaurant){
		restaurantService.insert(restaurant);
	}
	
	/**
	 * Endpoint para criar restaurantes para teste
	 */
	@RequestMapping(path = "/insert",
			method = RequestMethod.GET)
	public void insert(){
		//String name, String cnpj, Double price, Double discount, Point location
		restaurantService.insert(new Restaurant("hehe","87456321",25.1,2.1,new GeoJsonPoint(11.1,11.1)));
	}
	
	@RequestMapping(path = "",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.PUT)
	public void update (@RequestParam Restaurant restaurant){
		restaurantService.update(restaurant);
	}
	
	@RequestMapping(path = "/{id}",
			method = RequestMethod.DELETE)
	public void removeById(@PathVariable String id){
		restaurantService.removeById(id);
	}

	
}
