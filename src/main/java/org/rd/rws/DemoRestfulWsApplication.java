package org.rd.rws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoRestfulWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestfulWsApplication.class, args);
	}
}
