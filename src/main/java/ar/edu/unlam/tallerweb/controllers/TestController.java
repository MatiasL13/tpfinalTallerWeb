package ar.edu.unlam.tallerweb.controllers;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class TestController{

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
	public ModelAndView mostrarPersonas() {		
		List<Persona> personas = TablaPersonas.getInstance().listarTodas();	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("personas",personas);
		modelAndView.setViewName("persona");
		modelAndView.addObject("command",new Persona());
		return modelAndView;
		
	}
	
	@RequestMapping("/persona/crear")
	public ModelAndView crearPersonas(){
		 return new ModelAndView("crearPersona", "command", new Persona());
	}
	
	@RequestMapping(value = "/persona/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("persona")
                            Persona contact, BindingResult result) {
		Integer id = 0;
		//id = TablaPersonas.getInstance().total();
		for (Persona ele : TablaPersonas.getInstance().listarTodas())
		{
			if (ele.getId() >= id )
				id = ele.getId() + 1;
		}
		if(contact.getId() != null){
			TablaPersonas.getInstance().modificarPersona(contact);
		}
		else{
	        contact.setId(id);
	        TablaPersonas.getInstance().crearPersona(contact);	
		}
        return "redirect:";
    }
	
	@RequestMapping(value = "/persona/deleteContact", method = RequestMethod.POST)
	public String deletePersona(@ModelAttribute("persona")
							Persona contact, BindingResult result){

		TablaPersonas.getInstance().removerPersona(contact);
		return "redirect:";
	}
	@RequestMapping(value = "/persona/crear", method = RequestMethod.POST)
	public ModelAndView modificarPersona(@ModelAttribute("persona")
    								Persona contact){
		ModelAndView modelAndView = new ModelAndView();
		if (contact.getId() != null){
			List<Persona> personas =  TablaPersonas.getInstance().listarTodas();
			for(Persona persona : personas){
				if (persona.getId() == contact.getId()){
					modelAndView.addObject("command",persona);
					modelAndView.setViewName("crearPersona");
					return modelAndView;
				}
			}
		}
		
		return new ModelAndView("crearPersona", "command", new Persona());
		
	}
     
   
	
	
		
}
