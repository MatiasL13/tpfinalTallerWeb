package ar.edu.unlam.tallerweb.controllers;


import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb.domain.Persona;
import ar.edu.unlam.tallerweb.domain.TablaPersonas;

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
	@RequestMapping(value = "/mapa", method = RequestMethod.GET)
	public ModelAndView map(){
		ModelMap miMapa = new ModelMap();
		miMapa.put("nombre", "dario");
		miMapa.put("apellido", "asd");
		ModelAndView miVista = new ModelAndView();
		miVista.addAllObjects(miMapa);
		miVista.setViewName("mapa");
		return miVista;
	}
	@RequestMapping(value = "/nombre/{nombre}", method = RequestMethod.GET)
	public ModelAndView hola(@PathVariable String nombre){
		ModelMap miMapa = new ModelMap();
		miMapa.put("nombre", nombre);
		miMapa.put("apellido", "asd");
		ModelAndView miVista = new ModelAndView();
		miVista.addAllObjects(miMapa);
		miVista.setViewName("mapa");
		return miVista;
	}
	@RequestMapping("/persona")
	public ModelAndView mostrarPersonas(){		
		
		List<Persona> personas = TablaPersonas.getInstance().listarTodas();	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("personas",personas);
		modelAndView.setViewName("persona");
		return modelAndView;
		
	}
	
	@RequestMapping("/persona/crear")
	public ModelAndView crearPersonas(){
		
		 return new ModelAndView("crearPersona", "command", new Persona());
		
	}
	
	@RequestMapping(value = "/persona/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("persona")
                            Persona contact, BindingResult result) {
         
        TablaPersonas.getInstance().crearPersona(contact);	
        return "redirect:";
    }
     
   
	
	
		
}
