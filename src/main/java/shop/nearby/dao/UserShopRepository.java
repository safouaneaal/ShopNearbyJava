package shop.nearby.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.nearby.entities.Shop;
import shop.nearby.entities.User;
import shop.nearby.entities.UserShop;

public interface  UserShopRepository extends MongoRepository<UserShop,String>{
	List<UserShop> findByIduser(String name);
}
