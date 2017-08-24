package shop.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}
