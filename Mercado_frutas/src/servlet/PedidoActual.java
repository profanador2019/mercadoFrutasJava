package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Articulo;
import entities.Cliente;
import entities.Personal;
import logic.ABMC;
import logic.ControladorPedido;

/**
 * Servlet implementation class PedidoActual
 */
@WebServlet("/pedido")
public class PedidoActual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoActual() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ABMC abmc = new ABMC();
		Cliente c = new Cliente();
		Personal vendedor = (Personal)request.getSession().getAttribute("usuario");
		c.setId(Integer.parseInt(request.getParameter("cliente")));
		c = abmc.buscarCliente(c);
		ControladorPedido ctrl = new ControladorPedido();
		ctrl.nuevoPedido(c, vendedor);
		LinkedList<Articulo> lista = abmc.listarArticulos();
		request.getSession().setAttribute("pedidoactual", ctrl);
		request.setAttribute("listaarticulos", lista);
		request.getRequestDispatcher("WEB-INF/articulos.jsp").forward(request, response);;
	}

}
