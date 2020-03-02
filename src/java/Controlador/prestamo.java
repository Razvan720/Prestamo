/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuota;
import Modelo.Prestamo;
import Modelo.Utilidades;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DAW209
 */
@WebServlet(name = "prestamo", urlPatterns = {"/prestamo"})
public class prestamo extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet prestamo</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet prestamo at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> meses = Utilidades.getLista();

		request.setAttribute("meses", meses);
		request.getRequestDispatcher("prestamo.jsp").forward(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*Recogemos los datos del formulario*/
		String nombre = "Sin nombre";
		double cantidad = 0;
		double interes = 0;
		int tiempo = Integer.parseInt(request.getParameter("tiempo"));

		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");
		}
		if (request.getParameter("cantidad") != null) {
			cantidad = Double.parseDouble(request.getParameter("cantidad"));
		}
		if (request.getParameter("interes") != null) {
			interes = Double.parseDouble(request.getParameter("interes"));
		}

		/*Creamos un objeto prestamo con los datos anteriores*/
		Prestamo prestamo = new Prestamo(cantidad, interes, tiempo);
		
		String total = String.format("%.3f", prestamo.getImportePrestamo());

		/*Ponemos los atributos*/
		request.setAttribute("nombre", nombre);
		request.setAttribute("interes", interes);
		request.setAttribute("cantidad", cantidad);
		request.setAttribute("tiempo", tiempo);
		
		request.setAttribute("prestamo", total);

		/*Volvemos a crear la lista de meses*/
		ArrayList<String> meses = Utilidades.getLista();
		request.setAttribute("meses", meses);
		
		/*Creamos la tabla de cuotas*/
		 ArrayList<Cuota> cuotas = Utilidades.generaListaCuotas(tiempo, prestamo.getImportePrestamo());
		 request.setAttribute("cuotas", cuotas);

		/*Redirigimos al JSP*/
		request.getRequestDispatcher("prestamo.jsp").forward(request, response);

	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
