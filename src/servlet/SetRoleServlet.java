package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filter.DbFilter;
import model.User;

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
		Connection conn = DbFilter.getConn();

        Statement statement = null;
		try {
			statement  = ((Connection) conn).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Выполним запрос
        ResultSet result1 = null;
		try {
			result1 = statement.executeQuery(
			        "SELECT * FROM users where id >0 ORDER BY id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
        System.out.println("Выводим statement");
        try {
			while (result1.next()) {
			    System.out.println("\t Номер в базе #" + result1.getInt("id")
			            + "\t" + result1.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
								} 		
   	 //----------------------------------------------------------------------------------------------------------------------
/*
        ArrayList<User> listResults=convertToList(result1);
    	        req.setAttribute("listResults", listResults);
    	        resp.sendRedirect("ProductList.jsp");

    	public ArrayList<User> convertToList(ResultSet set) throws SQLException {
    	            ArrayList<User> arrayList=new ArrayList<User>();
    	            while (set.next())
    	            {
    	                User p=new User();
    	                 p.setName(set.getString("p_name"));
    	            }
    	        }
    	//----------------------------------------------------------------------------------------------------------------------	
*/		
		
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
