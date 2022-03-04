package entities;

import java.util.LinkedList;

public class Personal {
	int dni;
	String apellido;
	String nombre;
	String usuario;
	String contraseña;
	LinkedList<Rol> roles;
	
	public Personal() {
		roles = new LinkedList<Rol>();
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
    public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Personal [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", usuario=" + usuario
				+ ", contraseña=" + contraseña + ", roles=" + roles + "]";
	}
	
	

}
