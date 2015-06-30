package ar.edu.unlam.tallerweb.domain;

import java.util.LinkedList;
import java.util.List;

public class TablaPersonas {
    
    private static TablaPersonas instance = new TablaPersonas();
    private List<Persona> personas = new LinkedList<Persona>();
    private TablaPersonas(){}
    
    public static TablaPersonas getInstance(){
        return instance;
    }
    
    public Boolean crearPersona(Persona persona){
        return this.personas.add(persona);
    }

    public List<Persona> listarTodas(){
        return this.personas;
    }
    
    public Integer total(){
    	return this.personas.size();
    }
    
    public Boolean removerPersona(Persona persona){
    	for(Persona ele : personas)
    	{
    		if(ele.getId() == persona.getId()){
    			return this.personas.remove(ele);
    		}
    	}
    	return false;
    }
    public Boolean modificarPersona(Persona persona){
    	for(Persona ele : personas)
    	{
    		if(ele.getId() == persona.getId()){
    			 ele.setApellido(persona.getApellido());
    			 ele.setEdad(persona.getEdad());
    			 ele.setEmail(persona.getEmail());
    			 ele.setNombre(persona.getNombre());
    		}
    	}
    	return false;
    }
}
