package validationApi.controller;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import validationApi.dto.AddressDto;
import validationApi.service.PostalCodeService;
import validationApi.validation.Validate;

@RestController
public class PostalCodeController {

	private PostalCodeService postalCodeService;

	@Autowired
	public void setPostalCodeService(PostalCodeService postalCodeService) {
		this.postalCodeService = postalCodeService;
	}

	@RequestMapping("address/{postalCode}")
	@Produces("application/json")
	public AddressDto getAddress(@PathVariable(value = "postalCode") String postalCode) throws Exception {
		Validate.whenNullOrLengthZero(postalCode).throwElementDoesNotExistException("Postal Code was not supplied");
		AddressDto addressDto = postalCodeService.getAddress(postalCode);
		return addressDto;
	}
}
