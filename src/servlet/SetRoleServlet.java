package servlet;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

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
    
    public static ArrayList<User> select() {
    	ArrayList<User> users = new ArrayList<User>();

		Connection conn = DbFilter.getConn();

        Statement statement = null;
		try {
			statement  = ((Connection) conn).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Выполним запрос
        ResultSet resultset = null;
		try {
			resultset = statement.executeQuery(
			        "SELECT * FROM users ORDER BY id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
        System.out.println("Выводим statement");
        try {
			while (resultset.next()) {
                int id = resultset.getInt(1);
                String name = resultset.getString(2);
                String second = resultset.getString(3);
                String login = resultset.getString(4);
                String password = resultset.getString(5);
                int id_department = resultset.getInt(6);
                String stringArray = resultset.getString(7);
        		//String[] stringArray = { "a", "b", "c", "d", "e" };
        		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        		String[] stringArr = new String[arrayList.size()];
        		arrayList.toArray(stringArr);
        		for (String s : stringArr)
        			System.out.println(s);
        		System.out.println(arrayList);

                String[] roles =  stringArr;
                User user = new User(id, name, second, login, password, id_department, roles);
                //User user = new User(id, name, second, login, password, id_department);
                users.add(user);
					
			    System.out.println("\t Номер в базе #" + resultset.getInt("id")
			            + "\t" + resultset.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
								} 		    	
    	
    	return users;
    	
    }
    
    
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] stringArray = { "a", "b", "c", "d", "e" };
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
		System.out.println(arrayList);
		
		
        ArrayList<User> users = SetRoleServlet.select();
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
