package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/postServlet")
public class PostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter(); 
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Post Servlet ¹æ½Ä</h1>");
		out.println("<h3>id : "+ id + "</h3>");
		out.println("<h3>pwd : "+ pwd + "</h3>");
		out.println("<h3>email : "+ email + "</h3>");
		out.println("</body>");
		out.println("</html>");
	}
}