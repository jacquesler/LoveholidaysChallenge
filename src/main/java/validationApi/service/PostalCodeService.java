package validationApi.service;

import validationApi.dto.AddressDto;

public interface PostalCodeService {

	public AddressDto getAddress(String postalCode) throws Exception;
}
