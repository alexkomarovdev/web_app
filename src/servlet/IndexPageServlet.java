package servlet;

import model.User;
import utils.UserDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet({ "/", "/index" })
//@SuppressWarnings("serial") // or declare 	private static final long serialVersionUID = 1L;
public class IndexPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String index = "/WEB-INF/view/index.jsp";

	
    public IndexPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

		/*
		 * req.setAttribute("users", users);
		 * req.getRequestDispatcher(index).forward(req, resp); // we give index.jsp to
		 * PC-user
		 */        
    	
		  //users = new CopyOnWriteArrayList<>(); // create ThreadSafety array, no memory leak
		  //users.add(new User(UserDb.selectone(0))); 
		
		  //users.add(new User(1,"Анатолий Николаевич","Желизнык","1","1", 10)); 
		  //users.add(new User(2,"Майя Валериевна","Ушкова","2","2", 20)); 
		  //users.add(new User(3,"Наталья Алексеевна","Курникова","3","3", 30)); 
		  
    	RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher(index);

    	dispatcher.forward(req, resp);        
    }
	
	
	  private CopyOnWriteArrayList<User> users;
	  
	  @Override 
	  public void init() throws ServletException{ 
		  /*1306 
		  users = new CopyOnWriteArrayList<>(); // create ThreadSafety array, no memory leak
		  users.add(new User(UserDb.selectone(0))); 
		
		  //users.add(new User(1,"Анатолий Николаевич","Желизнык","1","1", 10)); 
		  users.add(new User(2,"Майя Валериевна","Ушкова","2","2", 20)); 
		  users.add(new User(3,"Наталья Алексеевна","Курникова","3","3", 30));
		  
		   */
		  
		  System.out.println("*************SERVLET IS INIT**************");
	  }
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	    	req.setCharacterEncoding("UTF-8"); // set using codepage
	    	final String id = req.getParameter("id"); // data from input form
	        final String name = req.getParameter("name"); // data from input form 
	        final String second = req.getParameter("second"); // data from input form
	        final String login = req.getParameter("login"); // data from input form
	        final String password = req.getParameter("password"); // data from input form
	        final String id_department = req.getParameter("id_department"); // data from input form
	        final User user = new User(Integer.valueOf(id), name, 
	        		second, login, password,
	        		Integer.valueOf(id_department)); // create new user
	        users.add(user);
	        
	    	doGet(req,resp);
	    	System.out.println("*************do Get**************");
	    }



}
