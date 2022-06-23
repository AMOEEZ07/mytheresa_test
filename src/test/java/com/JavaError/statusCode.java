package com.JavaError;
import org.testng.annotations.Test;
import com.utilities.Driver;
import com.utilities.TestBase;
import java.net.HttpURLConnection;
import java.net.URL;

public class statusCode extends TestBase{

@Test
	   public void httpStatus() throws Exception {
		Driver.Instance.navigate().to(Driver.properties.getTestUrl());
	      HttpURLConnection con = (HttpURLConnection)new URL("https://www.mytheresa.com").openConnection();
	    
	      System.out.println(con);
	      con.setRequestMethod("HEAD");
	      con.connect();
	      int res = con.getResponseCode();
	      System.out.println("Http response code: " + res);
	     
	   }
	
}
