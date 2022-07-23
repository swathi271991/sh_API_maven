package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public static RequestSpecification httpreq;
	public static ResponseSpecification resp;

	

	public RequestSpecification request() throws FileNotFoundException {
		
        if(httpreq==null)
        {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	
		httpreq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON)
				.addQueryParam("key", "qaclick123").
				addFilter(RequestLoggingFilter.logRequestTo(log)).
				addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

		return httpreq;
        }
        return httpreq;


	}

	public ResponseSpecification response()
	{
		resp = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		return resp;
	}


	public JsonPath rawToJSON(String resp2)
	{
		JsonPath js = new JsonPath(resp2);
		return js;
	}

}
