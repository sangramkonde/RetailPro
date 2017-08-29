package shop.retail.service;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shop.retail.dao.RetailShopDao;
import shop.retail.dao.RetailShopDaoImpl;

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
