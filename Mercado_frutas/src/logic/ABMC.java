package logic;

import java.util.LinkedList;

import data.DataCliente;
import entities.Cliente;

public class ABMC {
	private DataCliente dc;
	
	public ABMC() {
		dc = new DataCliente();
	}
	
	public LinkedList<Cliente> listarClientes(){
		return dc.getAll();
	}
	
	public LinkedList<Cliente> buscarCliente(Cliente cli){
		return dc.getByApellido(cli);
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

}
