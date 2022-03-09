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
 * Servlet implementation class Despachar
 */
@WebServlet("/despachar")
public class Despachar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Despachar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ControladorPedido ctrl = new ControladorPedido();
		Pedido p = new Pedido();
		p.setNro_pedido(Integer.parseInt(request.getParameter("pedido")));
		String op = request.getParameter("estado");
		if(op.equals("abonado")) {
			ctrl.abonarPedido(p);
		} else if(op.equals("retirado")) {
			ctrl.retirarPedido(p);
		}
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);

}}
