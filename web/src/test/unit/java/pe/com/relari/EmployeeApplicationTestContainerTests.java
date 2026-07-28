//package pe.com.relari;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import pe.com.relari.employee.model.api.EmployeeRequest;
//import pe.com.relari.employee.util.Constants;
//import pe.com.relari.employee.util.JsonConverter;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.greaterThanOrEqualTo;
//import static org.hamcrest.Matchers.isA;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
///**
// * Class: EmployeeApplicationTests.
// *
// * @version 1.0.0
// * @author Relari
// */
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@Testcontainers
//@ActiveProfiles("test")
//@AutoConfigureMockMvc
//class EmployeeApplicationTestContainerTests {
//
//	@Value("${application.api.path}")
//	String baseUrl;
//
//	@Autowired
//	private MockMvc mockMvc;
////	private static WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());
////	@Autowired
////	private EmployeeService demoService;
//
//	@BeforeEach
//	void init() {
////		 demoService.save(DataMocks.buildEmployee());
//	}
//
//	// Quitamos @Container y lo definimos como static manual
////	static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0");
////
////	@BeforeAll
////	static void beforeAll() {
////		mysql.start(); // Lo iniciamos manualmente
////	}
////
////	@DynamicPropertySource
////	static void configureProperties(DynamicPropertyRegistry registry) {
////		registry.add("spring.datasource.url", mysql::getJdbcUrl);
////		registry.add("spring.datasource.username", mysql::getUsername);
////		registry.add("spring.datasource.password", mysql::getPassword);
////	}
//
//	@Test
//	void getDemosTest() throws Exception {
//		mockMvc.perform(get(baseUrl))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andExpect(jsonPath("$", isA(List.class))) // Verifica que la raíz sea una lista
//				.andExpect(jsonPath("$").isArray())        // Verifica que sea un array JSON;
//				.andExpect(jsonPath("$.length()", greaterThanOrEqualTo(0)));
//	}
//
//	@Test
//	void createDemoTest() throws Exception {
//
//		var request = JsonConverter.readJsonFromResource("data/employee_request.json", EmployeeRequest.class);
//
//		mockMvc.perform(post(baseUrl)
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(JsonConverter.toJsonString(request)))
//				.andDo(print())
//				.andExpect(status().isCreated());
//	}
//
//	@Test
//	void createDemoButIsBadRequestTest() throws Exception {
//		mockMvc.perform(post(baseUrl)
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(Constants.EMPTY))
//				.andDo(print())
//				.andExpect(status().isBadRequest())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//	}
//
//	@Test
//	void demoNotFoundTest() throws Exception {
//		mockMvc.perform(get(baseUrl.concat("/0")))
//				.andDo(print())
//				.andExpect(status().isNotFound())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//	}
//
//	@Test
//	@Disabled
//	void deleteDemoTest() throws Exception {
//		mockMvc.perform(delete(baseUrl.concat("/1")))
//				.andDo(print())
//				.andExpect(status().isNoContent());
//	}
//
//}
