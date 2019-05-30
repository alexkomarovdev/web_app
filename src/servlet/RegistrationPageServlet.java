package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationPageServlet
 */
@WebServlet("/RegistrationPageServlet")
public class RegistrationPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String index = "/WEB-INF/view/registration.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher(index).forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");//read name from html form
        String second = req.getParameter("second");//read second from html form
        String login = req.getParameter("login");//read login from html form
        String pass = req.getParameter("pass");//read pass from html form
        String id_department = req.getParameter("id_department");//read department from html form
        PrintWriter writer = resp.getWriter();
        writer.println("<p>Пользователь с этими данными успешно зарегистрирован в системе!"+"</p>");
        writer.println("<p>Имя: " + name + "</p>");
        writer.println("<p>Фамилия: " + second + "</p>");
        writer.println("<p>Логин: " + login + "</p>");
        //writer.println("<p>Пароль: " + pass + "</p>");
        writer.println("<p>Отдел: " + id_department + "</p>");
        writer.println("<a href=/web_app>Главная страница</a>");
        
		//doGet(req, resp);
        
	}

}
