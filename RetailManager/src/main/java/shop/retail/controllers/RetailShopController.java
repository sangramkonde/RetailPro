package shop.retail.controllers;

import com.google.maps.model.LatLng;

import shop.retail.RetailMessages;
import shop.retail.exception.RetailManagerException;
import shop.retail.models.Shop;
import shop.retail.service.ShopLocator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
		List<Shop> shopList = shopLocator.getAll();
		if(null == shopList || shopList.size() == 0){
			throw new RetailManagerException(RetailMessages.NO_SHOPS_ADDED,
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Shop>>(shopList, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Shop> getShop(@PathVariable("id") long shopId) {
		Shop shop = shopLocator.getShopById(shopId);
		if (null == shop) {
			throw new RetailManagerException(RetailMessages.NO_SHOPS_ADDED,
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Shop>(shop, HttpStatus.OK);
	}

	@GetMapping(path = "/find")
	public ResponseEntity<Shop> getNearestShop(
			@RequestParam("customerLongitude") String longitude,
			@RequestParam("customerLatitude") String latitude) {
		try {
			LatLng location = new LatLng(Double.parseDouble(latitude),
					Double.parseDouble(longitude));
			Shop shop = shopLocator.findNearest(location);
			return new ResponseEntity<Shop>(shop, HttpStatus.OK);
		} catch (NumberFormatException e) {
			logger.error(RetailMessages.INVALID_LOCATION + " - " + longitude
					+ ", " + latitude, e);
			throw new RetailManagerException(e,
					RetailMessages.INVALID_LOCATION, HttpStatus.BAD_REQUEST);
		} catch (RetailManagerException rmse) {
			throw rmse;
		} catch (Exception e) {
			logger.error(RetailMessages.ERROR_SHOP + latitude + ", "
					+ longitude, e);
			throw new RetailManagerException(e,
					RetailMessages.SERVICE_UNAVAILABLE,
					HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@ExceptionHandler(value = RetailManagerException.class)
	public String handler(RetailManagerException e, HttpServletResponse response) {
		response.setStatus(e.getHttpStatusCode().value());
		return e.getMessage();
	}

}
