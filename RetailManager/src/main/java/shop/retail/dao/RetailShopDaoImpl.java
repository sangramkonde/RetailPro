package shop.retail.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shop.retail.models.Shop;
import shop.retail.models.ShopAddress;

import com.google.maps.model.LatLng;

/**
 * @author Sangram
 *
 */
@Transactional
@Repository
public class RetailShopDaoImpl implements RetailShopDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Shop getShopById(long id) {
		return entityManager.find(Shop.class, id);
	}

	@Override
	public Shop addShop(Shop shop) {
		entityManager.persist(shop);
		return shop;
	}

	@Override
	public Shop findNearest(String longitude, String latitude) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAll() {
		String hql = "from Shop";
		List<Shop> shopList =(List<Shop>)entityManager.createQuery(hql).getResultList();
		// TODO Auto-generated method stub
		return shopList;
	}

	@Override
	public Shop shopExists(String shopName) {
		String hql = "FROM Shop as s WHERE s.shopName = ?";
		Shop shop = null;
		try {
			shop = (Shop) entityManager.createQuery(hql)
					.setParameter(1, shopName).getSingleResult();
			entityManager.detach(shop);
		} catch (NonUniqueResultException nure) {
			shop = null;
		} catch (NoResultException nre) {
			shop = null;
		}
		return shop;
	}

	@Override
	public Shop updateShop(Shop shop) {
		Shop updatedShop = getShopById(shop.getShopId());
		ShopAddress updatedShopAddress = entityManager.find(ShopAddress.class, updatedShop.getShopAddress().getId());
		updatedShopAddress.setNumber(shop.getShopAddress().getNumber());
		updatedShopAddress.setPostCode(shop.getShopAddress().getPostCode());
		updatedShopAddress.setShopLatitude(shop.getShopAddress().getShopLatitude());
		updatedShopAddress.setShopLongitude(shop.getShopAddress().getShopLongitude());
		entityManager.flush();
		return updatedShop;
	}

	@Override
	public void deleteShop(long shopId) {
		entityManager.remove(getShopById(shopId));
	}
}
