package POJOclasses;

import java.util.ArrayList;

public class AddPlaceBODY {

	public static AddPlaceMain addPlace(String name, String address, String phone)
	{
		
		AddPlaceMain ap = new AddPlaceMain();
		
		AddPlace_Location lp = new AddPlace_Location();
		
		lp.setLat("-40.3456");
		lp.setLng("-60.3456");
		
		ap.setLocation(lp);
		
		ap.setAccuracy("50");
		ap.setName(name);
		ap.setPhone_number(phone);
		ap.setAddress(address);
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("shoe park hotel");
		al.add("shop address");
		
		ap.setTypes(al);
		
		ap.setWebsite("http://xtz.com");
		ap.setLanguage("English");
		
		return ap;	
		
	}

	public static UpdatePlacePOJO updateplace(String place_id)
	{
		UpdatePlacePOJO up = new UpdatePlacePOJO();
		
		up.setPlace_id(place_id);
		up.setAddress("Mahaveer Dazzle");
		up.setKey("qaclick123");
		
		return up;
	}
	
	public static DeletePlacePoJO deleteplace(String place_id) {
		
		DeletePlacePoJO dp = new DeletePlacePoJO();
		dp.setPlace_id(place_id);
		
		return dp;
		
	}
	
}
