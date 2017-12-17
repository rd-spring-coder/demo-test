package org.rd.rws.rest.contoller.test;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rd.rws.rest.controller.GreetingController;
import org.rd.rws.rest.controller.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class WebMockTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GreetingService service;
	
	@Test
	public void greetingShouldReturnMessageFromService() throws Exception{
		when(service.greet()).thenReturn("Hello Mock");
		this.mockMvc.perform(get("/greeting"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello Mock")));
	}

}
