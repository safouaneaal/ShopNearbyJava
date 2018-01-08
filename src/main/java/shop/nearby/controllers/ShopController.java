package shop.nearby.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.nearby.dao.ShopRepository;
import shop.nearby.entities.Shop;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ShopController {
	
	@Autowired
	private ShopRepository shopRepository;

	public ShopController() {}
    
	@GetMapping("/shops")
        public List<Shop> getusers()
	{
    	return shopRepository.findAll();
    }
}
