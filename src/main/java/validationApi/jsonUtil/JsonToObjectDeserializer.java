package validationApi.jsonUtil;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface JsonToObjectDeserializer<T> {

	public T Deserialize(String json) throws JsonParseException, JsonMappingException, IOException;
}
