package ar.edu.unlam.tallerweb.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb.domain.DatosPersonas;
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
	public ModelAndView tablaDePersonas(){
		
		Persona uno = new Persona();
		uno.setNombre("matias");
		DatosPersonas datos = new DatosPersonas();
		TablaPersonas.getInstance().crearPersona(uno);	
		List<Persona> personas = TablaPersonas.getInstance().listarTodas();
		ArrayList<DatosPersonas> listaDatos = new ArrayList<DatosPersonas>();
		
		for (Persona persona : personas) {
			
			datos.nombre =  persona.getNombre();
			datos.apellido = persona.getApellido();
			datos.edad = persona.getEdad();
			datos.email = persona.getEmail();
			listaDatos.add(datos);
			
		}
		
		
		for (DatosPersonas entry : listaDatos) {
			System.out.println(entry.nombre);
		}
				
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaDatos",listaDatos);
		modelAndView.setViewName("persona");
		return modelAndView;
		
	}
	
		
}
