package ar.edu.unlam.tallerweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/testOne")
	public ModelAndView testOne(){
		ModelAndView modelAndView = new ModelAndView("viewTwo");
		return modelAndView;
	}
	@RequestMapping("/")
	public ModelAndView testRoot(String nombre, String apellido){
		System.out.println(nombre + "\t" + apellido);
		ModelAndView modelAndView = new ModelAndView("viewOne");
		modelAndView.addObject("saludo", nombre + "\t" + apellido);
		return modelAndView;
		
	}
}
