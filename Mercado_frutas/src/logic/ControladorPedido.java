package logic;

import entities.*;
import data.*;

public class ControladorPedido {
	
	private DataCliente dc;
	private Pedido pedido_actual;
	
	
	public ControladorPedido() {
		dc = new DataCliente();
	}
	
	public Pedido nuevoPedido(Cliente c,Personal vendedor) {
		pedido_actual = new Pedido(vendedor);
		Cliente cliente_actual = dc.getById(c);
		if(cliente_actual!=null) {
			pedido_actual.setCliente(cliente_actual);
		} return pedido_actual;
	}
	
	public void añadirArticulo(Articulo art) {
		
	}
	
}	
