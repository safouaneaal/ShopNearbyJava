package shop.nearby.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shop.nearby.entities.User;
import shop.nearby.services.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public void getusers(User user)
	{
    	userService.getusers(user);
    }

}
