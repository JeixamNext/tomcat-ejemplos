package curso;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import javax.sql.DataSource;




@WebServlet(urlPatterns = {"/verUsuarios.html"})
public class VisualizarUsuariosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        StringBuffer sb = new StringBuffer("<HTML><BODY>");
        sb.append("<TABLE>");
        sb.append("<TR><TH>USUARIOS</TH></TR>");
        try {
        	Context ctx = new InitialContext();
        	//ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/cursoDB");
			
			conn = ds.getConnection();
			//stmt = con.createStatement();
        	
        	
            Statement statement = conn.createStatement();
            ResultSet users = statement.executeQuery("select * from usuarios");
            while (users.next()) {
                sb.append("<TR><TD>");
                String usuario = users.getString("nombre");
                sb.append(usuario);
                sb.append("</TD></TR>");
            }
        } catch (Exception e) {
            System.err.println("Error conectando a la Base de Datos");
            System.err.println(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Sesion cerrada");
                }
                catch (Exception e) {
                    System.err.println("Error al cerrar la sesion");
                }
            }
        }
        sb.append("</TABLE>");
        sb.append("</BODY></HTML>");
        response.getOutputStream().write(sb.toString().getBytes());

    }
/*
    private Connection getDbConnectionOld()
            throws SQLException,
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        String userName = "root";
        String password = "lepanto";
        String url = "jdbc:mysql://localhost/curso";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection(url, userName, password);
    }

    private Connection getDbConnection() throws NamingException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        Connection connection = (Connection) envContext.lookup("jdbc/cursoDB");
        return connection;
    }
    */
}
