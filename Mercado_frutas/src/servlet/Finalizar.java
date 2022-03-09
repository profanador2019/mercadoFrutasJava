package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pedido;
import logic.ControladorPedido;

/**
 * Servlet implementation class Finalizar
 */
@WebServlet("/finalizar")
public class Finalizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Finalizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cant = Integer.parseInt(request.getParameter("cantidadbultos"));
		ControladorPedido ctrl = (ControladorPedido)request.getSession().getAttribute("pedidoactual");
		Pedido p = ctrl.finalizarPedido(cant);
		request.setAttribute("total",p.getTotal());
		request.getRequestDispatcher("WEB-INF/total.jsp").forward(request, response);

}}
