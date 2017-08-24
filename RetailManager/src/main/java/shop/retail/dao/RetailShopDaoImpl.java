package shop.retail.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shop.retail.models.Shop;

import com.google.maps.model.LatLng;

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
	public void addShop(Shop shop) {
		entityManager.persist(shop);
	}

	@Override
	public Shop findNearest(LatLng location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shop> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop shopExists(String shopName) {
		String hql = "FROM Shop as s WHERE s.shopName = ?";
		entityManager.createQuery(hql).setParameter(1, shopName).getResultList();
		return null;
	}

	

}
