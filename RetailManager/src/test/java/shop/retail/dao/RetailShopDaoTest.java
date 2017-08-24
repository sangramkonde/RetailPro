package shop.retail.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import shop.retail.models.Shop;
import shop.retail.models.ShopAddress;
import static org.assertj.core.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class RetailShopDaoTest {
	/*@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private RetailShopDao retailShopDao;

	@Test
    public void testGetShopById() throws Exception {
		Shop shop = new Shop();
		ShopAddress shopAddress = new ShopAddress();
		shop.setShopName("My Shop");
		shopAddress.setNumber("City 1");
		shopAddress.setPostCode(411111);
		shopAddress.setShopLatitude(17.52334);
		shopAddress.setShopLongitude(48.6464);
		shop=(Shop)entityManager.persist(shop);
        Shop newShop =retailShopDao.getShopById(shop.getShopId());
        assertThat(shop.getShopName()).isEqualTo(newShop.getShopName());
    }*/
}
