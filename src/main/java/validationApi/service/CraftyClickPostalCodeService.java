package validationApi.service;

import org.springframework.beans.factory.annotation.Autowired;

import validationApi.domain.craftyClick.AddressInfo;
import validationApi.domain.craftyClick.JsonToObjectDeserializer.AddressJsonToObjectDeserializer;
import validationApi.dto.AddressDto;
import validationApi.dto.mapper.AddressDtoMapper;
import validationApi.dto.mapper.DtoMapper;
import validationApi.externalApi.requestBuilder.PostalCodeRestRequestBuilder;
import validationApi.jsonUtil.JsonToObjectDeserializer;


public class CraftyClickPostalCodeService implements PostalCodeService{

		
	private PostalCodeRestRequestBuilder postalCodeRestResponseBuilder;
	
	@Autowired
	public void setPostalCodeRestResponseBuilder(PostalCodeRestRequestBuilder postalCodeRestResponseBuilder){
		this.postalCodeRestResponseBuilder = postalCodeRestResponseBuilder;
	}
	
	private JsonToObjectDeserializer<AddressInfo> addressJsonToObjectDeserializer;
	private DtoMapper<AddressDto, AddressInfo> addressDtoMapper;
	
	public CraftyClickPostalCodeService(){
		addressJsonToObjectDeserializer = new AddressJsonToObjectDeserializer();
		addressDtoMapper = new AddressDtoMapper();		
	
	}
	
	@Override
	public AddressDto getAddress(String postalCode)throws Exception {
		String response = postalCodeRestResponseBuilder.AddParam("postCode", postalCode).toResponse();
		AddressInfo addressInfo = addressJsonToObjectDeserializer.Deserialize(response);
		AddressDto addressDto = addressDtoMapper.map(addressInfo);
		return addressDto;
	}
}
