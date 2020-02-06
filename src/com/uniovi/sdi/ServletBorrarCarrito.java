package com.uniovi.sdi;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBorrarCarrito
 */
@WebServlet("/borrarDelCarrito")
public class ServletBorrarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBorrarCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		String producto = request.getParameter("producto");
		if (producto != null) {
			eliminarEnElCarrito(carrito, producto);
		}
		// Retornar la vista con parámetro "carrito"
		request.setAttribute("paresCarrito", carrito);
		request.setAttribute("producto", null);
		getServletContext().getRequestDispatcher("/vista-carrito.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void eliminarEnElCarrito(HashMap<String, Integer> carrito, String claveProducto) {
		if (carrito.get(claveProducto) != null) {
			int numeroArticulos = (Integer) carrito.get(claveProducto).intValue();
			if (numeroArticulos == 1) {
				carrito.remove(claveProducto);
			} else {
				carrito.replace(claveProducto, numeroArticulos - 1);
			}
		}
	}

}
