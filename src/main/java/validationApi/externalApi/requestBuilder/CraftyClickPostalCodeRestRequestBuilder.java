package validationApi.externalApi.requestBuilder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import validationApi.validation.Validate;

public class CraftyClickPostalCodeRestRequestBuilder implements PostalCodeRestRequestBuilder {

	private RestTemplate restTemplate;
	private String baseUri;
	private Map<String, String> params;

	public CraftyClickPostalCodeRestRequestBuilder(String baseUri) {
		this.params = new HashMap<>();
		this.baseUri = baseUri;
	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public PostalCodeRestRequestBuilder AddParam(String key, String value) {
		this.params.put(key, value);
		return this;
	}

	public String toResponse() {
		Validate.whenNull(restTemplate)
				.throwRuntimeException("RestTemplate was no created for CraftyClickPostalCodeRestResponseBuilder");
		String result = restTemplate.getForObject(baseUri, String.class, params);
		return result;
	}
}
