package shop.nearby.calculation;

import java.util.ArrayList;
import java.util.Date;

import shop.nearby.entities.Shop;
import shop.nearby.entities.User;
import shop.nearby.intermediate.SortedDistance;

public class Mesure {
	  
	    public ArrayList<SortedDistance> distance(User user, ArrayList<Shop> shops) {
	        ArrayList<SortedDistance> out=new ArrayList<>();
		Double distance=null;
		Double xU = user.getLocation().getCoordinates().get(0);
		Double yU = user.getLocation().getCoordinates().get(1);
		
        
        
		for(int i=0; i<shops.size(); i++) {
			Double xS = shops.get(i).getLocation().getCoordinates().get(0);
			Double yS = shops.get(i).getLocation().getCoordinates().get(1);
		    Double dx = xU - xS; 
	        Double dy = yU - yS;
	        distance = Math.sqrt(dx*dx + dy*dy);
	        out.add(new SortedDistance(user, shops.get(i), distance));
		}
		
		return out;
	}
	
           public boolean getDiffDate(Date d) {
	        long diff = (new Date()).getTime() - d.getTime() ;

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.println(diffDays + " days, "+diffHours + " hours, "+diffMinutes + " minutes, "+diffSeconds + " seconds.");
                if(diffDays==0 && diffHours <2) return true;
                return false;
   }
}
