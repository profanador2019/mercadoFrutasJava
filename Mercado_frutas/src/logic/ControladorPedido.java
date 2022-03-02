package logic;

import entities.*;

import java.util.LinkedList;

import data.*;

public class ControladorPedido {
	
	private DataCliente dc;
	private DataArticulo da;
	private DataPedido dp;
	private Pedido pedido_actual;
	
	
	public ControladorPedido() {
		dc = new DataCliente();
		da = new DataArticulo();
		dp = new DataPedido();
	}
	
	public Pedido nuevoPedido(Cliente c,Personal vendedor) {
		pedido_actual = new Pedido();
		pedido_actual.setVendedor(vendedor);
		Cliente cliente_actual = dc.getById(c);
		if(cliente_actual!=null) {
			pedido_actual.setCliente(cliente_actual);
		} return pedido_actual;
	}
	
	public Articulo añadirArticulo(Articulo art, LineaPedido linea) {
		Articulo articulo = da.getDisponible(art, linea);
		// El precio lo decide el vendedor al momento de la compra
		if(articulo!=null) {
			articulo.setPrecio(art.getPrecio());
			pedido_actual.añadirLinea(articulo, linea);
			return articulo;
		} else {
			return null;
		}
	}
	
	public Pedido finalizarPedido(int cantbultos) {
		pedido_actual.setCant_bultos(cantbultos);
		dp.savePedido(pedido_actual);
		dp.saveArticulosPedidos(pedido_actual);
		da.actualizarStock(pedido_actual);
		return pedido_actual;
	}
	
	public LinkedList<Pedido> pedidosRecientes(){
		return dp.getPedidosRecientes();
	}
	
}	
