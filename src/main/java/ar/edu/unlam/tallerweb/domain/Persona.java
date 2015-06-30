package ar.edu.unlam.tallerweb.domain;

public class Persona {

	private String nombre;
	private String apellido;
	private String email;
	private Integer edad;
	private Integer id;
	
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getEdad() {
        return edad;
    }
    public Integer getId() {
        return id;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
	
}
