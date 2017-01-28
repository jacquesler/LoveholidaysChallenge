package validationApi.dto.mapper;

import org.springframework.stereotype.Component;

import validationApi.domain.craftyClick.AddressInfo;
import validationApi.dto.AddressDto;
import validationApi.validation.Validate;

@Component
public class AddressDtoMapper implements DtoMapper<AddressDto, AddressInfo> {

	@Override
	public AddressDto map(AddressInfo input) {
		Validate.whenNull(input).throwRuntimeException("Address Info cannot be null when being mapped");
		
		String addressName = isErrorMessage(input) ? "" : getAddressName(input);
				
		AddressDto dto = new AddressDto(addressName);
		dto.setError_code(input.getError_code());
		dto.setError_msg(input.getError_msg());
		return dto;
	}

	private boolean isErrorMessage(AddressInfo input){
		return input.getError_code() != null || input.getThoroughfares() == null;
	}
		
	private String getAddressName(AddressInfo input){
		return input.getThoroughfares()
		.stream().map(e -> e.getLine_1()).findFirst()
		.get();
	}
	
}
