package javase.jndi.wildfly820.example1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 509920882684720569L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");

		PrintWriter out = resp.getWriter();
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:jboss/mysql");
			Connection conn = ds.getConnection();        
	        Statement stmt = conn.createStatement();        
	        ResultSet rs = stmt.executeQuery("select symbol from language where id = 1");
	        if (rs.next()) {
	            out.println("<div>" + rs.getString("symbol") + "</div>");
	        }
		} catch (NamingException e) {
			e.printStackTrace(out);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.flush();
	}
}