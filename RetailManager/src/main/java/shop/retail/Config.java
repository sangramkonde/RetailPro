package shop.retail;

import java.util.ResourceBundle;

/**
 * This class stores the GEO_API_KEY which is used to locate the shop
 * @author Sangram
 *
 */
public class Config {

	public static String GEO_API_KEY;
	
	public static void loadProperties(){
		ResourceBundle bundle = ResourceBundle.getBundle("global");
		GEO_API_KEY=bundle.getString("GEO_API_KEY");
	}
}
