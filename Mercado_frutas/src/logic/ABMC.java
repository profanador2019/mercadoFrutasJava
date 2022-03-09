package logic;

import java.util.LinkedList;

import data.DataArticulo;
import data.DataCliente;
import entities.Articulo;
import entities.Cliente;

public class ABMC {
	private DataCliente dc;
	private DataArticulo da;
	
	public ABMC() {
		dc = new DataCliente();
		da = new DataArticulo();
	}
	
	public LinkedList<Cliente> listarClientes(){
		return dc.getAll();
	}
	
	public Cliente buscarCliente(Cliente cli){
		return dc.getById(cli);
	}
	
	public void nuevoCliente(Cliente cli) {
		dc.addCliente(cli);
	}
	
	public void borrarCliente(Cliente cli) {
		dc.deleteCliente(cli);
	}
	
	public void editarCliente(Cliente cli) {
		dc.editCliente(cli);
	}
	
	public LinkedList<Articulo> listarArticulos(){
		return da.getAll();
	}

}
