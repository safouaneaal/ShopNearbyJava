package shop.nearby.dao;
import shop.nearby.*;
import shop.nearby.entities.Shop;
import shop.nearby.entities.User;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository 
public interface ShopRepository extends MongoRepository<Shop,String> {
	List<Shop> findByName(String name);
	
}
