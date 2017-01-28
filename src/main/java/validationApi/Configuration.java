package validationApi;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import validationApi.externalApi.requestBuilder.CraftyClickPostalCodeRestRequestBuilder;
import validationApi.externalApi.requestBuilder.PostalCodeRestRequestBuilder;
import validationApi.service.CraftyClickPostalCodeService;
import validationApi.service.PostalCodeService;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public PostalCodeService getPostalCodeService() {
		return new CraftyClickPostalCodeService();
	}

	@Bean
	public PostalCodeRestRequestBuilder getPostalCodeRestResponseBuilder() {
		final String uri = "http://pcls1.craftyclicks.co.uk/json/basicaddress?key={key}&postcode={postCode}&response=data_formatted";
		final String key = "c09aa-0a082-a39bf-01f03";
		PostalCodeRestRequestBuilder builder = new CraftyClickPostalCodeRestRequestBuilder(uri);
		builder.AddParam("key", key);
		return builder;
	}
}
