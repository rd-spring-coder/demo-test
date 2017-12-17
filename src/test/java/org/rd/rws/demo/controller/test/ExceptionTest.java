package org.rd.rws.demo.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.rd.rws.demo.controller.ServiceException;
import org.rd.rws.rest.controller.GreetingService;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionTest {
	
	@Spy
	private GreetingService service;
	
	
	@Test(expected = ServiceException.class)
	public void shouldThrowServiceException_whenGreetingNotFound() throws Exception{
		service.greet();
	}

}
