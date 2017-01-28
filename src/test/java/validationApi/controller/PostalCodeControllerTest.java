package validationApi.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import validationApi.dto.AddressDto;
import validationApi.service.PostalCodeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostalCodeControllerTest {

	@Mock
	PostalCodeService postalCodeService;

	@InjectMocks
	PostalCodeController postalCodeController;

	@Autowired
	private MockMvc mockMvc;

	private String street = "Mount View Rd";

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(postalCodeController).build();
	}

	@Test
	public void testGetPostalCode() throws Exception {
		when(postalCodeService.getAddress("n44sj")).thenReturn(new AddressDto(street));

		mockMvc.perform(MockMvcRequestBuilders.get("/address/n44sj").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("address", is(street)));
	}

	@Test
	public void testGetPostalCodeWhenNoPostalCodeIsSupplied() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/address").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}
