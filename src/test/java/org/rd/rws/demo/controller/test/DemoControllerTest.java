package org.rd.rws.demo.controller.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rd.rws.builder.UserBuilder;
import org.rd.rws.demo.controller.DemoController;
import org.rd.rws.rest.controller.GreetingService;
import org.rd.rws.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class DemoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GreetingService service;
	
	//Test if /demo returns to home2 view
	@Test
	public void getSlashDemoShouldReturnHello2View() throws Exception{
		this.mockMvc.perform(get("/demo"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("home2"));
			//.andExpect(model().attribute("key", "value"));
	}
	
	// Test Model attributes
	@Test
	public void whenModelThenReturnHello() throws Exception{
		this.mockMvc.perform(get("/model"))
			.andDo(print())
			//.andExpect(status().isOk())
			.andExpect(model().attribute("greeting", "hello"))
			.andExpect(model().attribute("key", "value"));
	}
	
	// Redirect/forwards will be similar to /demo
	@Test
	public void whenFlashThenReturnHello() throws Exception{
		this.mockMvc.perform(get("/flash"))
			.andDo(print())
			.andExpect(status().is3xxRedirection())
			.andExpect(flash().attribute("redirect", "hello"))
			//.andExpect(view().name("redirect:/hello-world"));
			.andExpect(redirectedUrl("/hello-world"));
	}
	
	//@Test(expected = ServiceException.class)
	@Test
	public void whenGreetNotFoundThenGreetingNotFoundException() throws Exception{
		//when(service.greet()).thenThrow(ServiceException.class);
		//Assertions.assertThatThrownBy(()->this.mockMvc.perform(get("/greet-not-found"))).isExactlyInstanceOf(ServiceException.class);
		this.mockMvc.perform(get("/greet-not-found"))
			.andExpect(status().isOk())
			.andExpect(content().string("service exception"));
	}
	
	@Test
	public void testPostDemoWithParams() throws Exception{
		MultiValueMap<String, String> userMap = new LinkedMultiValueMap<String, String>();
		userMap.add("id", "4");
		userMap.add("name", "abc");
		userMap.add("birthDate", "25-11-1988");
		
		Date date = new GregorianCalendar(1988, Calendar.NOVEMBER, 25).getTime();
		User user = new UserBuilder()
				.withId(5)
				.hasName("abc")
				.wasBornOn(date)
				.build();
					
/*		Date date = new GregorianCalendar(1988, Calendar.NOVEMBER, 25).getTime();
		User user = new User(4,"new user",date);
*/		this.mockMvc.perform(post("/demo-post").flashAttr("user", user))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(model().attribute("user", hasProperty("name",is("new user"))));
		
	}
}
