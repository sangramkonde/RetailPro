package shop.retail.controllers;

import com.google.maps.model.LatLng;

import shop.retail.RetailMessages;
import shop.retail.exception.RetailManagerException;
import shop.retail.models.ServiceResponse;
import shop.retail.models.Shop;
import shop.retail.service.ShopLocator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This is a controller class and used to manage the customer's request and response
 * life-cycle
 * 
 * @author Sangram
 *
 */
@RestController
@RequestMapping("/shop")
public class RetailShopController {

	@Autowired
	ShopLocator shopLocator;
	@Autowired
	ObjectMapper objectMapper;
	private static final Logger logger = LoggerFactory
			.getLogger(RetailShopController.class);

	@PostMapping
	public ResponseEntity<String> addShop(@RequestBody Shop shop) {
		System.out.println(shop);
		shopLocator.addShop(shop);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Shop> getShop(@PathVariable("id") long shopId) {
		Shop shop=shopLocator.getShopById(shopId);
		return new ResponseEntity<Shop>(shop,HttpStatus.OK);
	}
	
	/*@RequestMapping("/")
	public String status() {
		return RetailMessages.SUCCESS;
	}*/

	/*@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addShop(HttpServletResponse response,
			@Validated @RequestBody Shop shop) {
		String msg;
		try {
			shopLocator.save(shop);
			msg = objectMapper.writeValueAsString(new ServiceResponse(true, RetailMessages.SHOP_ADDED));
			response.setStatus(HttpStatus.CREATED.value());
		} catch (IOException exception) {
			logger.error(RetailMessages.SHOP_ADD_FAILED, exception);
			throw new RetailManagerException(exception,
					RetailMessages.NOT_PROCESSED, HttpStatus.OK);
		}
		return msg;
	}
*/
	/*@RequestMapping(path = "/find", method = RequestMethod.GET)
	public String getNearestShop(
			@RequestParam("customerLongitude") String longitude,
			@RequestParam("customerLatitude") String latitude) {
		String result = null;
		try {
			LatLng location = new LatLng(Double.parseDouble(latitude),
					Double.parseDouble(longitude));
			result = objectMapper.writeValueAsString(shopLocator
					.findNearest(location));
			return result;
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
*/
	@ExceptionHandler(value = RetailManagerException.class)
	public String handler(RetailManagerException e, HttpServletResponse response) {
		response.setStatus(e.getHttpStatusCode().value());
		return e.getMessage();
	}

	public void setShopLocator(ShopLocator shopLocator) {
		this.shopLocator = shopLocator;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
}
