package shop.nearby.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import shop.nearby.entities.User;
@Repository 
public interface UserRepository extends MongoRepository<User, String> {
	List<User> findByName(String name);
	
}