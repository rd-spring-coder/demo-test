package org.rd.rws.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.rd.rws.rest.controller.GreetingService;
import org.rd.rws.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DemoController {

	@Autowired
	private GreetingService service;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	            //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	            //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	            //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@ModelAttribute
	public void prepare(ModelMap model){
		model.addAttribute("key","value");
	}
	@GetMapping("/demo")
	public String home(){
		return "home2";
	}
	
	@GetMapping("/model")
	public String homeWithModel(ModelMap model){
		model.addAttribute("greeting", "hello");
		return "home2";
	}
	
	@GetMapping("/flash")
	public String redirectWithFlash(RedirectAttributes attributes){
		attributes.addFlashAttribute("redirect", "hello");
		return "redirect:/hello-world";
	}
	
	@GetMapping("/greet-not-found")
	public String throwsServiceException() throws ServiceException{
		//return service.greet();
		throw new ServiceException("service exception");
	}
	
	@PostMapping("/demo-post")
	public String post(@ModelAttribute("user") User user, BindingResult result){
		user.setName("new user");
		return "home2";
	}
	
	@ExceptionHandler
	public @ResponseBody String handle(ServiceException e){
		return "service exception";
	}
}
