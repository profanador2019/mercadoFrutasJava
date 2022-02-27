package entities;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Pedido {
	private int nro_pedido;
	private LocalDateTime fecha_pedido;
	private int cant_bultos;
	private boolean abonado;
	private boolean retirado;
	private LinkedList<LineaPedido> lineas;
	private Cliente cliente;
	private Personal vendedor;
	
	public Pedido(Personal v) {
		this.setFecha_pedido(LocalDateTime.now());
		this.setLineas(new LinkedList<LineaPedido>());
		this.setVendedor(v);
	}
	
	public int getNro_pedido() {
		return nro_pedido;
	}
	public void setNro_pedido(int nro_pedido) {
		this.nro_pedido = nro_pedido;
	}
	public LocalDateTime getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(LocalDateTime fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public int getCant_bultos() {
		return cant_bultos;
	}
	public void setCant_bultos(int cant_bultos) {
		this.cant_bultos = cant_bultos;
	}
	public boolean isAbonado() {
		return abonado;
	}
	public void setAbonado(boolean abonado) {
		this.abonado = abonado;
	}
	public boolean isRetirado() {
		return retirado;
	}
	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}
	public LinkedList<LineaPedido> getLineas() {
		return lineas;
	}
	public void setLineas(LinkedList<LineaPedido> lineas) {
		this.lineas = lineas;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Personal getVendedor() {
		return vendedor;
	}
	public void setVendedor(Personal vendedor) {
		this.vendedor = vendedor;
	}
	
	

}