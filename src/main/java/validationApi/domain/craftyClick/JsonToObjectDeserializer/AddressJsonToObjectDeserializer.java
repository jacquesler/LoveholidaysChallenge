package validationApi.domain.craftyClick.JsonToObjectDeserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import validationApi.domain.craftyClick.AddressInfo;
import validationApi.jsonUtil.JsonToObjectDeserializer;
import validationApi.validation.Validate;

public class AddressJsonToObjectDeserializer implements JsonToObjectDeserializer<AddressInfo> {

	private ObjectMapper mapper;

	public AddressJsonToObjectDeserializer() {
		mapper = new ObjectMapper();
	}

	@Override
	public AddressInfo Deserialize(String json) throws JsonParseException, JsonMappingException, IOException {
		Validate.whenNullOrLengthZero(json)
				.throwRuntimeException("Input json was null or empty for Address deserialization");

		AddressInfo address = mapper.readValue(json, AddressInfo.class);
		return address;
	}

}
