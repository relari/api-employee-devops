package pe.com.relari;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;
import pe.com.relari.employee.model.api.EmployeeRequest;
import pe.com.relari.employee.util.Constants;
import pe.com.relari.employee.util.JsonConverter;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Class: EmployeeApplicationTests.
 *
 * @version 1.0.0
 * @author Relari
 */

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class EmployeeApplicationTests {

	@Value("${application.api.path}")
	String baseUrl;

	@Autowired
	private MockMvc mockMvc;

//	@Autowired
//	private EmployeeService demoService;

	@BeforeEach
	void init() {
//		 demoService.save(DataMocks.buildEmployee());
	}

	@Test
	@Order(1)
	void getEmployees_WhenEmployeesExist_Returns200() throws Exception {
		mockMvc.perform(get(baseUrl))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", isA(List.class))) // Verifica que la raíz sea una lista
				.andExpect(jsonPath("$").isArray())        // Verifica que sea un array JSON;
				.andExpect(jsonPath("$.length()", greaterThanOrEqualTo(0)));
	}

	@Test
	@Order(2)
	void postEmployees_WithValidData_Returns201() throws Exception {

		var request = JsonConverter.readJsonFromResource("data/employee_request.json", EmployeeRequest.class);

		mockMvc.perform(
				post(baseUrl)
						.contentType(MediaType.APPLICATION_JSON)
						.content(JsonConverter.toJsonString(request))
				)
				.andDo(print())
				.andExpect(status().isCreated());
	}

	@Test
	@Order(3)
	void getEmployee_WhenEmployeeExist_Returns200() throws Exception {
		mockMvc.perform(get(buildEmployeeUrl(Constants.ONE)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@Order(4)
	void deleteEmployeeById_WhenValidData_Returns204() throws Exception {
		mockMvc.perform(delete(buildEmployeeUrl(Constants.ONE)))
				.andDo(print())
				.andExpect(status().isNoContent());
	}

	@Test
	@Order(5)
	void postEmployees_WithEmptyBody_Returns400() throws Exception {
		mockMvc.perform(
				post(baseUrl)
						.contentType(MediaType.APPLICATION_JSON)
						.content(Constants.EMPTY)
				)
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@Order(6)
	void getEmployeeById_WhenNotFound_Returns404() throws Exception {
		mockMvc.perform(get(buildEmployeeUrl(Constants.ZERO)))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@Order(7)
	void deleteEmployeeById_WhenInvalidData_Returns404() throws Exception {
		mockMvc.perform(delete(buildEmployeeUrl(Constants.ZERO)))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	private String buildEmployeeUrl(int id) {
//		return String.format("%s/%d", baseUrl, id);
		return UriComponentsBuilder.fromPath(baseUrl)
				.pathSegment(String.valueOf(id))
				.toUriString();
	}

}
