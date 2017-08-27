package shop.retail.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shop.retail.RetailMessages;
import shop.retail.exception.RetailManagerException;
import shop.retail.models.Shop;
import shop.retail.service.ShopLocator;

/**
 * This is a controller class and used to manage the customer's request and
 * response life-cycle
 * 
 * @author Sangram
 * 
 */
@RestController
@RequestMapping("/shop")
public class RetailShopController {

	@Autowired
	ShopLocator shopLocator;

	private static final Logger logger = LoggerFactory
			.getLogger(RetailShopController.class);

	@PostMapping
	public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
		Shop newShop = shopLocator.addShop(shop);
		return new ResponseEntity<Shop>(newShop, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Shop>> getAllShop() {

		logger.info("Returning all the shop´s");
		return new ResponseEntity<List<Shop>>(shopLocator.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Shop> getShop(@PathVariable("id") long shopId) throws RetailManagerException{
		logger.info("Returning shop for id : "+shopId);
		Shop shop = shopLocator.getShopById(shopId);
		if (null == shop) {
			throw new RetailManagerException(RetailMessages.NO_SHOPS_FOUND);
		}
		return new ResponseEntity<Shop>(shop, HttpStatus.OK);
	}

	@GetMapping(path = "/find")
	public ResponseEntity<Shop> getNearestShop(
			@RequestParam("customerLongitude") String longitude,
			@RequestParam("customerLatitude") String latitude) throws RetailManagerException {
		logger.info("Getting the nearest shop");
		Shop shop = shopLocator.findNearest(longitude, latitude);
		return new ResponseEntity<Shop>(shop, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteShop(@PathVariable("id") Integer shopId) throws RetailManagerException{
		logger.info("Deleting shop for id : "+shopId);
		shopLocator.deleteShop(shopId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
