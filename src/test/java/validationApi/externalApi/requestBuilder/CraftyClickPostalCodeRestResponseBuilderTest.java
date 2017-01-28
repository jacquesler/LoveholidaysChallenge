package validationApi.externalApi.requestBuilder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import validationApi.externalApi.requestBuilder.CraftyClickPostalCodeRestRequestBuilder;

public class CraftyClickPostalCodeRestResponseBuilderTest {

	private final static String uri = "http://pcls1.craftyclicks.co.uk/json/basicaddress?key={key}&postcode={postCode}&response=data_formatted";
	private final static String expectedResponse = "{\"thoroughfares\":[{\"line_1\":\"MOUNT VIEW ROAD\",\"line_2\":\"\"}],\"thoroughfare_count\":1,\"postal_county\":\"GREATER LONDON\",\"traditional_county\":\"MIDDLESEX\",\"town\":\"LONDON\",\"postcode\":\"N4 4SJ\"}";
	private static RestTemplate restTemplateMock;
	private static Map<String, String> params;

	@BeforeClass
	public static void setUp() {
		restTemplateMock = mock(RestTemplate.class);
		params = new HashMap<>();
		params.put("key", "xxx");
		params.put("postCode", "N44SJ");
		when(restTemplateMock.getForObject(uri, String.class, params)).thenReturn(expectedResponse);
	}

	@Test
	public void testRequestBuilderReturnsCorrectResult() {
		// Act
		CraftyClickPostalCodeRestRequestBuilder responseBuilder = new CraftyClickPostalCodeRestRequestBuilder(uri);
		responseBuilder.setRestTemplate(restTemplateMock);

		String result = responseBuilder.AddParam("key", "xxx").AddParam("postCode", "N44SJ").toResponse();

		// Assert
		Assert.assertEquals(expectedResponse, result);
		verify(restTemplateMock, times(1)).getForObject(uri, String.class, params);
	}

	@Test(expected = RuntimeException.class)
	public void testRequestBuilderThrowsExceptionWhenNotInitializedCorrectly() {
		// Act
		CraftyClickPostalCodeRestRequestBuilder responseBuilder = new CraftyClickPostalCodeRestRequestBuilder(uri);
		responseBuilder.AddParam("key", "xxx").AddParam("postCode", "N44SJ").toResponse();
	}
}
