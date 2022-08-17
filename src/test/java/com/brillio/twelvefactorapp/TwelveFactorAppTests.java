package com.brillio.twelvefactorapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.brillio.twelvefactorapp.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest 
@AutoConfigureMockMvc
class TwelveFactorAppTests {

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private EmployeeRepository employeeRepository;

//	@Test
//	@Order(1)
//	public void getAllEmployees() throws Exception {
//		Employee employee = new Employee();
//		employee.setId(100);
//		employee.setName("vicky");
//		employee.setAge(23);
//		List<Employee> empList = Arrays.asList(employee);
//		when(employeeRepository.findAll()).thenReturn(empList);
//		mockmvc.perform(get("/api/v1/employee")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().json("[{'id':100,'name':'vicky','age':23}]")).andExpect(jsonPath("$.*", hasSize(1)));
//	}

//	@Test
//	@Order(1)
//	public void addEmployee() throws Exception {
//        Employee user = new Employee(101,"Madhuri",23);
//        employeeRepository.save(user);
//		when(employeeRepository.save(ArgumentMatchers.any())).thenReturn(user);
//		mockmvc.perform(post("/api/v1/employee/createNew").contentType(MediaType.APPLICATION_JSON)
//				.content(asJsonString(user))).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().json("{'id':101,'name':'Madhuri','age':23}"));
//	}
//
//	@Test
//	@Order(2)
//	public void updateEmployee() throws Exception {
//        Employee user = new Employee(101,"viki",23);
//        employeeRepository.save(user);
//		when(employeeRepository.save(ArgumentMatchers.any())).thenReturn(user);
//		mockmvc.perform(put("/api/v1/employee/updateCall/101").contentType(MediaType.APPLICATION_JSON)
//				.content(asJsonString(user))).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().json("{'id':101,'name':'karthik','age':23}"));
//	}
//
//    @Test
//    public void deleteUser(){
//        Employee user = new Employee(1100,"viki",25);
//        employeeRepository.save(user);
//        System.out.println("added user to test");
//        employeeRepository.delete(user);
//        System.out.println("deleted user to test");
//        Assert.assertTrue(employeeRepository.findById(1100).isEmpty());
//    }

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
