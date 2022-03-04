package entities;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Pedido {
	

	private int nro_pedido;
	private LocalDateTime fecha_pedido;
	private int cant_bultos;
	private boolean abonado;
	private LocalDateTime fecha_abonado;
	private boolean retirado;
	private LinkedList<LineaPedido> lineas;
	private Cliente cliente;
	private Personal vendedor;
	
	public Pedido() {
		this.setFecha_pedido(LocalDateTime.now());
		this.setLineas(new LinkedList<LineaPedido>());
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
	public LocalDateTime getFecha_abonado() {
		return fecha_abonado;
	}
    public void setFecha_abonado(LocalDateTime fecha_abonado) {
		this.fecha_abonado = fecha_abonado;
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
	
	public void añadirLinea(Articulo art, LineaPedido linea) {
		LineaPedido l = new LineaPedido();
		l.setArticulo(art);
		l.setCantidad(linea.getCantidad());
		this.lineas.add(l);
	}
	
	public double getTotal() {
		double total=0;
		for(LineaPedido l: this.lineas) {
			total=total+l.getSubtotal();
		}
		return total;
	}
	
	@Override
	public String toString() {
		return "Pedido [nro_pedido=" + nro_pedido + ", fecha_pedido=" + fecha_pedido + ", cant_bultos=" + cant_bultos
				+ ", abonado=" + abonado + ", fecha_abonado=" + fecha_abonado + ", retirado=" + retirado + ", lineas="
				+ lineas + ", cliente=" + cliente + ", vendedor=" + vendedor + "]";
	}
	
	

}
