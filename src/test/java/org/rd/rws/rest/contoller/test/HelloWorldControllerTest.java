package org.rd.rws.rest.contoller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rd.rws.rest.controller.HelloWorldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testHelloWorld() throws Exception{
		mockMvc.perform(get("/hello-world")).andExpect(status().isOk());
	}

}
