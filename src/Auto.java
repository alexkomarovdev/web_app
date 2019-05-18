import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;//db
import java.sql.Connection;//db
import java.sql.SQLException;//db


import java.io.PrintWriter;

import java.util.List; // for init List
import java.util.concurrent.CopyOnWriteArrayList; // for create CopyOnWriteArrayList
import model.User; // our module User
/**
 * Servlet implementation class Auto
 */
@WebServlet("/Auto")
public class Auto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Working!!!!!     ").append(request.getContextPath());
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("username");//read username from html form
        String age = request.getParameter("userage");//read age from html form
        String gender = request.getParameter("gender");//read gender from html form
        String country = request.getParameter("country");//read country from html form
        String[] courses = request.getParameterValues("courses");//read selected course from html form
        
        writer.println("<p>" + "</p>");
        response.getWriter().append(name);

        writer.println("<p>Name: " + name + "</p>");
        writer.println("<p>Age: " + age + "</p>");
        writer.println("<p>Gender: " + gender + "</p>");
        writer.println("<p>Country: " + country + "</p>");
        writer.println("<h4>Courses</h4>");
        for(String course: courses)
            writer.println("<li>" + course + "</li>"); 
		//properties connection to db
    	String url = "jdbc:postgresql://127.0.0.1:5432/web_db";
        String username = "admin";
        String password = "admin";
        Connection connection = null;
		
        try {
    	//check correct to connect driver
        Class.forName("org.postgresql.Driver");
        System.out.println("PostgreSQL JDBC Driver successfully connected");
        
        connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		return;
		}
		finally {

			  
			  }
        //check connection to db
		if (connection != null) {
			System.out.println("You successfully connected to database now");
		} else {
			System.out.println("Failed to make connection to database");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("request is "+(HttpServletRequest)request);
		System.out.println("response is "+(HttpServletResponse)response);
		//request.getRequestDispatcher(path).forward(req,resp); //alternative call
		doGet(request, response);
	}

	private List<User> users;
	@Override
	public void init() throws ServletException{
		users = new CopyOnWriteArrayList<>(); // create ThreadSafety array, no memory leak
       // users.add(new User("Java", 10));
       // users.add(new User("Vision", 20));
		System.out.println("*************SERVLET IS INIT**************");
	
	}
	
	@Override
	public void destroy(){
		System.out.println("*************SERVLET IS DESTROY**************");
	
	}
}
