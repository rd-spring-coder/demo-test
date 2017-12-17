package org.rd.rws.rest.controller;

import org.rd.rws.demo.controller.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() throws ServiceException {
    	throw new ServiceException("service");
    	//return "Hello Mock";
    }
}