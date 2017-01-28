package validationApi.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import validationApi.domain.craftyClick.AddressInfo;
import validationApi.domain.craftyClick.Thoroughfare;
import validationApi.dto.AddressDto;

public class AddressDtoMapperTest {

	private AddressInfo addressInfo;
	private String address = "Oxford Street";
	
	@Before
    public void setUp() throws Exception {
		addressInfo = new AddressInfo();
		Thoroughfare thoroughfare = new Thoroughfare();
		thoroughfare.setLine_1(address);
		thoroughfare.setLine_2("");
		List<Thoroughfare> thoroughfares = new ArrayList<>();
		thoroughfares.add(thoroughfare);		
		addressInfo.setThoroughfares(thoroughfares);
    }
	
	@Test
	public void testAddressToAdressDtoMapping(){
		AddressDtoMapper dtoMapper = new AddressDtoMapper();
		AddressDto dto = dtoMapper.map(addressInfo);		
		AddressDto expectedDto = new AddressDto(address);
		Assert.assertEquals(expectedDto, dto);
	}
	
	@Test(expected = RuntimeException.class)
	public void testMappingThrowsExceptionWhenInputIsNull(){
		AddressDtoMapper dtoMapper = new AddressDtoMapper();
		dtoMapper.map(null);		
	}
	
	@Test
	public void testMappingWhenAddressContainsError(){
		
		AddressInfo errorAddressInfo = new AddressInfo();
		errorAddressInfo.setError_code("0001");
		errorAddressInfo.setError_msg("No data was found for the requested postcode.");
		
		AddressDtoMapper dtoMapper = new AddressDtoMapper();
		AddressDto dto = dtoMapper.map(errorAddressInfo);		
		
		AddressDto expected = new AddressDto("");
		expected.setError_code("0001");
		expected.setError_msg("No data was found for the requested postcode.");
		
		Assert.assertEquals(expected, dto);
	}
}
