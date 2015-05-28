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
}
