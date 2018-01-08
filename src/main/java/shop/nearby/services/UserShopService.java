package shop.nearby.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.nearby.calculation.Mesure;
import shop.nearby.dao.ShopRepository;
import shop.nearby.dao.UserRepository;
import shop.nearby.dao.UserShopRepository;
import shop.nearby.entities.Shop;
import shop.nearby.entities.UserShop;
import shop.nearby.intermediate.SortedDistance;


@Service
public class UserShopService {
	@Autowired
	private UserShopRepository userShopRepository;
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private UserRepository userRepository;
	
	Mesure dist=new Mesure();
	
	 public void postlikedshops(String iduser ,String idshop)
	 {
			ArrayList<UserShop> userList=new ArrayList<>();
			UserShop usershop=new UserShop(iduser+idshop, iduser, idshop, true, new Date());
	    	userList.add(usershop);
	    	userShopRepository.save(userList);
	 }
	 
	 public void postdislikedshops( String iduser ,String idshop)
	 {
			ArrayList<UserShop> userList=new ArrayList<>();
			UserShop usershop=new UserShop(iduser+idshop, iduser, idshop, false, new Date());
	    	userList.add(usershop);
	    	userShopRepository.save(userList);
	 }
	 
	 public void removeshops(String iduser ,String idshop)
	 {
	    	userShopRepository.delete(iduser+idshop);
	 }
	 
	 public List<Shop> getpreferedshops( String iduser){
			ArrayList<UserShop> usershops=new ArrayList<>(); // usershops are shops liked or disliked by a specific user
			ArrayList<Shop> likedshops=new ArrayList<>(); 
			List<SortedDistance> out=new ArrayList<>(); // to sort shops by distance
		    Shop shop=new Shop();
		    List<Shop> shops=new ArrayList<>();
		    usershops=(ArrayList<UserShop>) userShopRepository.findByIduser(iduser);
			for(int i=0;i<usershops.size();i++) 
			{
				if(usershops.get(i).getStatus()) // condition: collect shops by user when status = true ( means liked shop ) 
				{ shop=shopRepository.findByName(usershops.get(i).getIdshop()).get(0);
				  likedshops.add(shop);
				}
			}
			// sort liked shops by distance
			out=dist.distance(userRepository.findByName(iduser).get(0),likedshops);
	    	Collections.sort(out);
			for(int i=0;i<out.size();i++) {	shops.add(out.get(i).getShops()); }
		    return shops;
			
		}

		public  List<Shop> getShopNearby(String id)
		{
			List<SortedDistance> out=new ArrayList<>();
		    List<Shop> shops=new ArrayList<>();
		    List<Shop> shopsnearby=new ArrayList<>();
		    ArrayList<UserShop> usershops=new ArrayList<>();
		    shopsnearby = shopRepository.findAll();
		    usershops=(ArrayList<UserShop>) userShopRepository.findByIduser(id);
			for(int j=0;j<shopsnearby.size();j++) 
			{
			  for(int i=0;i<usershops.size();i++)
			   {
				if(shopsnearby.get(j).getName().equals(usershops.get(i).getIdshop()))
					if(usershops.get(i).getStatus() == true) shopsnearby.remove(j);
                    else if (dist.getDiffDate(usershops.get(i).getStatusDate())==true) //if disliked status date doesn't exceed 2 hours : remove from shopnearby
                    shopsnearby.remove(j);
                    else userShopRepository.delete(usershops.get(i)); 
               }
			}
	    	out=dist.distance(userRepository.findByName(id).get(0), (ArrayList<Shop>) shopsnearby);
	    	Collections.sort(out);
			for(int i=0;i<out.size();i++) 
			{
				shops.add(out.get(i).getShops());
			}
		
			return shops;
		}
}
