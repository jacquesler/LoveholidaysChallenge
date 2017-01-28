package validationApi.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import validationApi.dto.AddressDto;
import validationApi.externalApi.requestBuilder.PostalCodeRestRequestBuilder;

public class CraftyClickPostalCodeServiceTest {

	private static PostalCodeRestRequestBuilder postalCodeRestResponseBuilderMock;
	private final static String jsonResponse = "{\"thoroughfares\":[{\"line_1\":\"MOUNT VIEW ROAD\",\"line_2\":\"\"}],\"thoroughfare_count\":1,\"postal_county\":\"GREATER LONDON\",\"traditional_county\":\"MIDDLESEX\",\"town\":\"LONDON\",\"postcode\":\"N4 4SJ\"}";
	
	@BeforeClass
	public static void setUp(){
		postalCodeRestResponseBuilderMock = mock(PostalCodeRestRequestBuilder.class);
		when(postalCodeRestResponseBuilderMock.AddParam("postCode", "N44SJ")).thenReturn(postalCodeRestResponseBuilderMock);
		when(postalCodeRestResponseBuilderMock.toResponse()).thenReturn(jsonResponse);
	}
	
	@Test
	public void testGivenAPostCodeAdressDtoIsReutrned() throws Exception{
		CraftyClickPostalCodeService service = new CraftyClickPostalCodeService();
		service.setPostalCodeRestResponseBuilder(postalCodeRestResponseBuilderMock);
		
		AddressDto result = service.getAddress("N44SJ");
		
		AddressDto expectedDto = new AddressDto("MOUNT VIEW ROAD");
		
		Assert.assertEquals(expectedDto, result);
		verify(postalCodeRestResponseBuilderMock, times(1)).AddParam("postCode", "N44SJ");
		verify(postalCodeRestResponseBuilderMock, times(1)).toResponse();
	}
}
