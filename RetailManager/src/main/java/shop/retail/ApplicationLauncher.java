package shop.retail;

import shop.retail.datastore.ShopInMemoryArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * This is the class where we launch the retail manager application
 * To run it, here we have used spring boot
 * @author Sangram
 *
 */
@SpringBootApplication
public class ApplicationLauncher {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationLauncher.class, args);
		System.out.println(RetailMessages.SUCCESS);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public ShopInMemoryArray shopListHolder() {
		return new ShopInMemoryArray();
	}

}
