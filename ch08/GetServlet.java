package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/getServlet")
public class GetServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String msg = request.getParameter("msg");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter(); 
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Get Servlet ¹æ½Ä</h1>");
		out.println("<h2>msg : "+msg + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}
}