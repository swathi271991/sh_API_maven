package resources;

public enum PlaceAPI {

	AddPlace("/maps/api/place/add/json"),
	GETPlace("/maps/api/place/get/json"),
	UpdatePlace("/maps/api/place/update/json"),
	DeletePlace("/maps/api/place/delete/json");

	private String resource;
	

     PlaceAPI(String resource)
	{
		this.resource = resource;

	}
	public String getresource()
	{
		return resource;
	}

}
