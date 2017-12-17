package org.rd.rws.rest.contoller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rd.rws.rest.controller.UserRestController;
import org.rd.rws.rest.model.User;
import org.rd.rws.rest.model.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private UserDaoService userDaoService;
	
	@Test
	public void testRetrieveOne() throws Exception{
		User user=new User(1,"Ritesh",new Date());
		when(userDaoService.findOne(1)).thenReturn(user);
		
		mock.perform(get("/users/1")).andExpect(status().isOk());

	}
	
}
