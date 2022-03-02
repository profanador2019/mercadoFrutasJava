package entities;

public class LineaPedido {
	private Articulo articulo;
	private int cantidad;
	
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getSubtotal() {
		return (this.articulo.getPrecio()*this.cantidad);
		
	}

}
