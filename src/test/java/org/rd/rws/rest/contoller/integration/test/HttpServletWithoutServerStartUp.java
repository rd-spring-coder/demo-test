package org.rd.rws.rest.contoller.integration.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HttpServletWithoutServerStartUp {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorldShouldReturnHelloWorldString() throws Exception{
		mockMvc.perform(get("/hello-world")).andDo(print()).andExpect(status().isOk());
			//.andExpect(content().string(containsString("Hello World")));
	}

}
