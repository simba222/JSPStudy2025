package ch18;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch18/pmemberPost")
public class PMemberPostServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		PMemberMgr pMgr = new PMemberMgr();
		if(pMgr.insertPMember(request)) {
			response.sendRedirect("login.jsp");
		}else {
			request.getSession().setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다");
			response.sendRedirect("pregister.jsp");
			
		}
	}
}