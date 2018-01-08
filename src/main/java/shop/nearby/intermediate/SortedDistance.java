package shop.nearby.intermediate;

import shop.nearby.entities.Shop;
import shop.nearby.entities.User;

/* this entity is not persistent, it is an intermediate entity.
   it is made to help us retrieve collection of distances and 
   sort them by implementing interface Comparable */
public class SortedDistance implements Comparable<SortedDistance>{ 
	
	private User user;
	private Shop shop;
	private Double distance;
		
	public SortedDistance(User user, Shop shop, Double distance) {
		super();
		this.user = user;
		this.shop = shop;
		this.distance = distance;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Shop getShops() {
		return shop;
	}


	public void setShops(Shop shops) {
		this.shop = shops;
	}


	public Double getDistance() {
		return distance;
	}


	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(SortedDistance o) {
		return new Double(distance).compareTo( o.distance);
	}

	

}
