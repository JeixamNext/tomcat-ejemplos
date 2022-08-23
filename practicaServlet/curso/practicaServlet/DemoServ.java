package practicaServlet;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class DemoServ extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String nombre = req.getParameter("nombre");
		pw.println("Bienvenido al curso de Apasoft Training, te llamas:" + nombre);
	}
}
