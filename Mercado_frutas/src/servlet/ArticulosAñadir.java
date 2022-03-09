package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Articulo;
import entities.LineaPedido;
import logic.ABMC;
import logic.ControladorPedido;

/**
 * Servlet implementation class ArticulosAñadir
 */
@WebServlet("/añadir")
public class ArticulosAñadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticulosAñadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ABMC abmc = new ABMC();
		LinkedList<Articulo> lista = abmc.listarArticulos();
		request.setAttribute("listaarticulos",lista);
		request.getRequestDispatcher("WEB-INF/articulos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ABMC abmc = new ABMC();
		ControladorPedido ctrl = (ControladorPedido)request.getSession().getAttribute("pedidoactual");
		LineaPedido lp = new LineaPedido();
		Articulo art = new Articulo();
		lp.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		art.setPrecio(Double.parseDouble(request.getParameter("precio")));
		art.setId_articulo(Integer.parseInt(request.getParameter("articulo")));
		art = ctrl.añadirArticulo(art, lp);
		LinkedList<Articulo> lista = abmc.listarArticulos();
		request.setAttribute("listaarticulos",lista);
		if(art!=null) {
			request.getRequestDispatcher("WEB-INF/articulos.jsp").forward(request, response);
		} else {
			request.setAttribute("mensaje","No hay disponibilidad del articulo");
			request.setAttribute("direccion-volver","añadir");
			request.setAttribute("mensaje-volver","Volver");
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		} 
	}

}
