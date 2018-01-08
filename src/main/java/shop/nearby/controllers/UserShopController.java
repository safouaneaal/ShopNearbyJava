package shop.nearby.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.nearby.entities.Shop;
import shop.nearby.services.UserShopService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class UserShopController {
	
	@Autowired
	private UserShopService userShopService;
	

	@PostMapping("/users/{id}/shops/{ids}/like")
    public void postlikedshops(@PathVariable("id") String iduser ,@PathVariable("ids") String idshop){
		userShopService.postlikedshops(iduser, idshop);
	}
	@PostMapping("/users/{id}/shops/{ids}/dislike")
    public void postdislikedshops(@PathVariable("id") String iduser ,@PathVariable("ids") String idshop){
		userShopService.postdislikedshops(iduser, idshop);
	}
	@GetMapping("/users/{id}/preferedshops")
    public List<Shop> getpreferedshops(@PathVariable("id") String iduser){
		return userShopService.getpreferedshops(iduser);
	}
	@GetMapping("/users/{id}")
	public  List<Shop> getShopNearby(@PathVariable("id")String id)
	{
		return userShopService.getShopNearby(id);
	}
	@DeleteMapping("/users/{id}/preferedshops/{ids}/remove")
    public void removeshops(@PathVariable("id") String iduser ,@PathVariable("ids") String idshop){
		userShopService.removeshops(iduser,idshop);
	}
	
}
