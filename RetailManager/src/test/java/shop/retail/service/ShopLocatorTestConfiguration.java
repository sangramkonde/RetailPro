package shop.retail.service;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import shop.retail.dao.RetailShopDao;

@Configuration
public class ShopLocatorTestConfiguration {
	@Bean
	public ShopLocator shopLocator() {
		return new ShopLocatorImpl();
	}

	@Bean
	public RetailShopDao retailShopDao() {
		return Mockito.mock(RetailShopDao.class);
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
