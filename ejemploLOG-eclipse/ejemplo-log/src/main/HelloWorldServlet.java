package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Prueba
 */
@WebServlet(name = "logServlet", urlPatterns = "/log.html")
public class HelloWorldServlet extends HttpServlet {
    Logger logger = Logger.getLogger("main");
    Logger logger2 = Logger.getLogger("curso1.log");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.warning("mensaje de prueba");
        logger2.info("Ejemplo a la consola");
        response.sendRedirect("/log/index.jsp");

    }
}
