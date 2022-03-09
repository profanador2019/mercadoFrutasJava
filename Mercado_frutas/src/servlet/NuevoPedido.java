package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cliente;
import logic.ABMC;

/**
 * Servlet implementation class NuevoPedido
 */
@WebServlet("/nuevopedido")
public class NuevoPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ABMC ctrl = new ABMC();
		
		try{
			LinkedList<Cliente> clientes = ctrl.listarClientes();
			request.setAttribute("lista", clientes);
			request.getRequestDispatcher("WEB-INF/nuevo_pedido.jsp").forward(request, response);;
			
		} catch(Exception e) {
			request.setAttribute("mensaje","No hay clientes para mostrar");
			request.setAttribute("direccion-volver","home.jsp");
			request.setAttribute("mensaje-volver","Volver");
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
