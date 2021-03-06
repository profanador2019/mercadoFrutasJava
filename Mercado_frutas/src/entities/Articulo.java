package entities;

public class Articulo {
	private int id_articulo;
	private String nombre;
	private String descripcion;
	private int cant_aprox_kg;
	private double precio;
	private double precio_sugerido;
	private Proveedor proveedor;
	private int stock;
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public int getId_articulo() {
		return id_articulo;
	}
	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCant_aprox_kg() {
		return cant_aprox_kg;
	}
	public void setCant_aprox_kg(int cant_aprox_kg) {
		this.cant_aprox_kg = cant_aprox_kg;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecio_sugerido() {
		return precio_sugerido;
	}
	public void setPrecio_sugerido(double precio_sugerido) {
		this.precio_sugerido = precio_sugerido;
	}
	
	

}
