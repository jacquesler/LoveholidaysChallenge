package validationApi.externalApi.requestBuilder;

public interface PostalCodeRestRequestBuilder {

	public PostalCodeRestRequestBuilder AddParam(String key, String value);
	
	public String toResponse();
}
