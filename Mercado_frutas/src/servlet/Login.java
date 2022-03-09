package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Personal;
import logic.ControladorPedido;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
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
		
		Personal p = new Personal();
		p.setUsuario(request.getParameter("usuario"));
		p.setContraseña(request.getParameter("pass"));
		
		ControladorPedido ctrl = new ControladorPedido();
		
		try {
			p = ctrl.validar(p);
			request.getSession().setAttribute("usuario",p);
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		} catch(Exception e) {
			request.setAttribute("mensaje","Usuario y/o contraseña incorrectos");
			request.setAttribute("direccion-volver","index.html");
			request.setAttribute("mensaje-volver","Volver");
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
		
	}

}
