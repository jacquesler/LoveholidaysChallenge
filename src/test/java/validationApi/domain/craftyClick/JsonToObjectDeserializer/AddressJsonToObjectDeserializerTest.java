package validationApi.domain.craftyClick.JsonToObjectDeserializer;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import validationApi.domain.craftyClick.AddressInfo;
import validationApi.domain.craftyClick.Thoroughfare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class AddressJsonToObjectDeserializerTest {

	@Test
	public void testDeserializationWithValidJson() throws JsonParseException, JsonMappingException, IOException{
		// Arrange
		String result = "{\"thoroughfares\":[{\"line_1\":\"MOUNT VIEW ROAD\",\"line_2\":\"\"}],\"thoroughfare_count\":1,\"postal_county\":\"GREATER LONDON\",\"traditional_county\":\"MIDDLESEX\",\"town\":\"LONDON\",\"postcode\":\"N4 4SJ\"}";
		
		// Act
		AddressJsonToObjectDeserializer deserializer = new AddressJsonToObjectDeserializer();
		AddressInfo addressInfo = deserializer.Deserialize(result);
		
		// Assert
		Thoroughfare thoroughfare = new Thoroughfare();
		thoroughfare.setLine_1("MOUNT VIEW ROAD");
		thoroughfare.setLine_2("");
		List<Thoroughfare> thoroughfares = new ArrayList<>();
		thoroughfares.add(thoroughfare);	
		AddressInfo expected = new AddressInfo();
		expected.setThoroughfares(thoroughfares);
		expected.setPostcode("N4 4SJ");
		expected.setTown("LONDON");
		
		
		Assert.assertEquals(expected, addressInfo);
	}
	
	@Test(expected = RuntimeException.class)
	public void testDeserializationWithEmptyString() throws JsonParseException, JsonMappingException, IOException{
		// Arrange
		String result = "";
		
		// Act
		AddressJsonToObjectDeserializer deserializer = new AddressJsonToObjectDeserializer();
		deserializer.Deserialize(result);			
	}
	
	@Test(expected=com.fasterxml.jackson.core.JsonParseException.class)
	public void testDeserializationWithMalformedJson() throws JsonParseException, JsonMappingException, IOException{
		// Arrange
		String result = "{\"\"thoroughfares\":[{{\"line_1\":\"MOUNT VIEW ROAD\",\"line_2\":\"\"}],\"thoroughfare_count\":1,\"postal_county\":\"GREATER LONDON\",\"traditional_county\":\"MIDDLESEX\",\"town\":\"LONDON\",\"postcode\":\"N4 4SJ\"}";
		
		// Act
		AddressJsonToObjectDeserializer deserializer = new AddressJsonToObjectDeserializer();
		deserializer.Deserialize(result);			
	}
	
	@Test
	public void testFailedApiLookUp() throws JsonParseException, JsonMappingException, IOException{
		// Arrange
		String result = "{\"error_code\":\"0001\",\"error_msg\":\"No data was found for the requested postcode.\"}";
		
		// Act
		AddressJsonToObjectDeserializer deserializer = new AddressJsonToObjectDeserializer();
		AddressInfo addressInfo = deserializer.Deserialize(result);	
		
		AddressInfo expected = new AddressInfo();
		expected.setError_code("0001");
		expected.setError_msg("No data was found for the requested postcode.");
		
		Assert.assertEquals(expected, addressInfo);
	}
	
	@Test
	public void testFailedApiLookUpWithMalformedPostalCode() throws JsonParseException, JsonMappingException, IOException{
		// Arrange
		String result = "{\"error_code\":\"0002\",\"error_msg\":\"Postal Code is in incorrect format.\"}";
		
		// Act
		AddressJsonToObjectDeserializer deserializer = new AddressJsonToObjectDeserializer();
		AddressInfo addressInfo = deserializer.Deserialize(result);	
		
		AddressInfo expected = new AddressInfo();
		expected.setError_code("0002");
		expected.setError_msg("Postal Code is in incorrect format.");
		
		Assert.assertEquals(expected, addressInfo);
	}
	
	
}
