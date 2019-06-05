package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import utils.UserDb;

/**
 * Servlet implementation class SetRoleServlet
 */
@WebServlet("/SetRoleServlet")
public class SetRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String index = "/WEB-INF/view/setrole.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
  
    
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	
        //ArrayList<User> users = SetRoleServlet.select();
		ArrayList<User> users = UserDb.select();
        req.setAttribute("users", users);
        
		req.getRequestDispatcher(index).forward(req, resp); // we give SetRole.jsp to PC-user
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
		
	
	
}
