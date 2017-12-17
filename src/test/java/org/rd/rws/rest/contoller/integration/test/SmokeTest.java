package org.rd.rws.rest.contoller.integration.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rd.rws.rest.controller.HelloWorldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	@Autowired
	HelloWorldController helloWorldController;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(helloWorldController).isNotNull();
	}
}
