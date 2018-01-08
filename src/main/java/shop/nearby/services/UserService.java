package shop.nearby.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.nearby.calculation.Mesure;
import shop.nearby.dao.UserRepository;
import shop.nearby.entities.User;
import shop.nearby.entities.Location;;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	Mesure dist=new Mesure();
	
	public void getusers(User user)
	{
		Double x=Math.random()*100;
		Double y=Math.random()*100;
		String id=""+Math.random();
		// set Random id and Random Location to a User
		user.setId(id);
		user.setLocation(new Location("point",new ArrayList<Double>() 
				{{add(x);add(y);}}));
    	        userRepository.save(user);
       }
}
