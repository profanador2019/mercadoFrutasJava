package ui;

import entities.*;
import logic.*;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		ControladorPedido ctrl = new ControladorPedido();
		Scanner s = new Scanner(System.in);
		
		System.out.println("ingrese usuario:");
		String u = s.nextLine();
		System.out.println("Ingrese clave:");
		String c = s.nextLine();
		Personal p = new Personal();
		p.setUsuario(u);
		p.setContraseña(c);
		Personal ven = ctrl.validar(p);
		if(ven!=null) {
			System.out.println("Bienvenido "+ven.getNombre()+" "+ven.getApellido());
		} else {
			System.out.println("Usuario o clave incorrecta");
		}
		
		Cliente cliente = null;
		System.out.println("Nuevo Pedido:");
		do{System.out.println("Ingrese ID del cliente");
		Cliente cli = new Cliente();
		cli.setId(Integer.parseInt(s.nextLine()));
		cliente=ctrl.nuevoPedido(cli, ven);
		if(cliente==null) {
			System.out.println("No se encontro cliente");
		} else {
			System.out.println("Cliente: "+cliente.getNombre()+" "+cliente.getApellido());
		}
		} while(cliente==null);
		
		String op = null;
		do{Articulo art = new Articulo();
		LineaPedido l = new LineaPedido();
		System.out.println("Ingrese id de articulo a añadir: ");
		art.setId_articulo(Integer.parseInt(s.nextLine()));
		System.out.println("Ingrese precio: ");
		art.setPrecio(Integer.parseInt(s.nextLine()));
		System.out.println("Ingrese cantidad: ");
		l.setCantidad(Integer.parseInt(s.nextLine()));
		Articulo añadido = ctrl.añadirArticulo(art, l);
		if(añadido!=null) {
			System.out.println("se añadio al pedido "+l.getCantidad()+" unidades del articulo "+añadido.getNombre());
		} else {
			System.out.println("No hay disponibilidad");
		}
		System.out.println("ingrese otro si desea agregar otro articulo o f si desea finalizar");
		op = s.nextLine();} while(!op.equals("f"));
		
		
		System.out.println("Ingrese cantidad de bultos: ");
		int b = Integer.parseInt(s.nextLine());
		Pedido ped = ctrl.finalizarPedido(b);
		System.out.println(ped);
		s.close();
		
		System.out.println("Pedidos Recientes:");
		System.out.println(ctrl.pedidosRecientes());
		Pedido pe = new Pedido();
		pe.setNro_pedido(8);
		ctrl.abonarPedido(pe);
		System.out.println(ctrl.pedidosRecientes());
		ctrl.retirarPedido(pe);
		System.out.println(ctrl.pedidosRecientes());

	}

}
