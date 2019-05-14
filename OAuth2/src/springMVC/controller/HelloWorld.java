package springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class HelloWorld  {

	@RequestMapping("/hello")
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	 
		  return "hello";
	}

}
