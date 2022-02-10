package entities;

import java.util.Scanner;

public class Princ {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Cliente c = new Cliente();
		System.out.println("Ingrese nombre del cliente: ");
		c.setNombre(s.nextLine());
		System.out.println("El nombre del cliente es: "+c.getNombre());
		System.out.println(c);
		s.close();
		

	}

}
