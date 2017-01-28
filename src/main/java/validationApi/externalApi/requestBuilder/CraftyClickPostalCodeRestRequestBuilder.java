package validationApi.externalApi.requestBuilder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import validationApi.validation.Validate;


public class CraftyClickPostalCodeRestRequestBuilder implements PostalCodeRestRequestBuilder {

	
	private RestTemplate restTemplate;
	
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}
	
	private String baseUri;
	private Map<String, String> params;
	
	public CraftyClickPostalCodeRestRequestBuilder(String baseUri){
		this.params = new HashMap<>();
		this.baseUri = baseUri;
	}
	
	public PostalCodeRestRequestBuilder AddParam(String key, String value){
		this.params.put(key, value);
		return this;
	}
	
	public String toResponse(){
		Validate.whenNull(restTemplate).throwRuntimeException("RestTemplate was no created for CraftyClickPostalCodeRestResponseBuilder");		
	    String result = restTemplate.getForObject(baseUri, String.class, params);
		//String result = "{\"thoroughfares\":[{\"line_1\":\"MOUNT VIEW ROAD\",\"line_2\":\"\"}],\"thoroughfare_count\":1,\"postal_county\":\"GREATER LONDON\",\"traditional_county\":\"MIDDLESEX\",\"town\":\"LONDON\",\"postcode\":\"N4 4SJ\"}";
	  // String result = "{\"error_code\":\"0001\",\"error_msg\":\"No data was found for the requested postcode.\"}";
		return result;
	}
}
