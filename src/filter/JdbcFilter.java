package filter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.sql.DriverManager;//db
import java.sql.Connection;//db
import java.sql.SQLException;//db
import java.sql.*;

/**
 * Servlet Filter implementation class JdbcFilter
 */
@WebFilter(urlPatterns = { "/*" })
public class JdbcFilter implements Filter {

	/**
     * Default constructor. 
     */
    public JdbcFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//properties connection to db
	    String hostname = request.getRemoteHost(); // hostname
	    System.out.println("hostname"+hostname);
	    String computerName = null;
	    String remoteAddress = request.getRemoteAddr();
	    System.out.println("remoteAddress: " + remoteAddress);

	    
	    try {
	        InetAddress inetAddress = InetAddress.getByName(remoteAddress);
	        System.out.println("inetAddress: " + inetAddress);
	        computerName = inetAddress.getHostName();

	        System.out.println("computerName: " + computerName);


	        if (computerName.equalsIgnoreCase("localhost")) {
	            computerName = java.net.InetAddress.getLocalHost().getCanonicalHostName();
	        } 
	    } catch (UnknownHostException e) {

	        }

	    System.out.println("computerName: " + computerName);
	    System.out.println(java.lang.System.getProperty("os.name"));
	    if (java.lang.System.getProperty("os.name").equals("Windows 7"))
	    {
	    	String url = "jdbc:postgresql://127.0.0.1:5432/web_db";
	        String username = "admin";
	        String password = "web_app";
	        Connection conn = null; 	    	
	    	System.out.println("connect localhost! ");
	    	//////////////////////////////////////////////////////////////////////////////////
	        HttpServletRequest req = (HttpServletRequest) request;
	        String servletPath = req.getServletPath();
	        try {
	        Class.forName("org.postgresql.Driver");
	        System.out.println("PostgreSQL JDBC Driver successfully connected");
	        // Создать объект Connection подключенный к database.
	        conn = DriverManager.getConnection(url, username, password);
	        //Statement statement = null;
	        } catch (ClassNotFoundException e) {
				System.out.println("Connection Failed ClassNotFoundException");
				e.printStackTrace();
	        } catch (SQLException e) {
				System.out.println("Connection Failed SQLException");
				e.printStackTrace();
				return;
	        }finally {       	
	         }
	        // Открыть Connection (соединение) только для request со специальной ссылкой
	        // (Например ссылка к servlet, jsp, ..)
	        // Избегать открытие Connection для обычноых запросов
	        // (Например image, css, javascript,... )
	        if (servletPath.contains("/LoginPageServlet") )//|| servletPath.contains("/specialPath2")) 
	        	{System.out.println("address is loginpage!");

	            //1.Statement: используется для простых случаев без параметров
	            Statement statement = null;

	            try {
					statement = ((Connection) conn).createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            //Выполним запрос
	            ResultSet result1 = null;
				try {
					result1 = statement.executeQuery(
					        "SELECT * FROM users where id >0");
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
					    System.out.println("Номер в выборке #" + result1.getRow()
					            + "\t Номер в базе #" + result1.getInt("id")
					            + "\t" + result1.getString("name"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
										}        	
	        	
		    }
	    	
	    	/////////////////////////////////////////////////////////////////////////////////
	    	
	    } else 
	    {
	    	String url = "jdbc:postgresql://10.72.0.128:5432/web_db";
	        String username = "admin";
	        String password = "web_pg";
	        Connection conn = null;        
	        System.out.println("connect 10.72.0.128 ");
	    	//////////////////////////////////////////////////////////////////////////////////
	        HttpServletRequest req = (HttpServletRequest) request;
	        String servletPath = req.getServletPath();
	        try {
	        Class.forName("org.postgresql.Driver");
	        System.out.println("PostgreSQL JDBC Driver successfully connected");
	        // Создать объект Connection подключенный к database.
	        conn = DriverManager.getConnection(url, username, password);
	        //Statement statement = null;
	        } catch (ClassNotFoundException e) {
				System.out.println("Connection Failed ClassNotFoundException");
				e.printStackTrace();
	        } catch (SQLException e) {
				System.out.println("Connection Failed SQLException");
				e.printStackTrace();
				return;
	        }finally {       	
	         }
	        // Открыть Connection (соединение) только для request со специальной ссылкой
	        // (Например ссылка к servlet, jsp, ..)
	        // Избегать открытие Connection для обычноых запросов
	        // (Например image, css, javascript,... )
	        if (servletPath.contains("/LoginPageServlet") )//|| servletPath.contains("/specialPath2")) 
	        	{System.out.println("address is loginpage!");

	            //1.Statement: используется для простых случаев без параметров
	            Statement statement = null;

	            try {
					statement = ((Connection) conn).createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            //Выполним запрос
	            ResultSet result1 = null;
				try {
					result1 = statement.executeQuery(
					        "SELECT * FROM users where id >0");
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
					    System.out.println("Номер в выборке #" + result1.getRow()
					            + "\t Номер в базе #" + result1.getInt("id")
					            + "\t" + result1.getString("name"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
										}        	
	        	
		    }
	    	
	    	/////////////////////////////////////////////////////////////////////////////////
	        
	        
	    }
	    

		// pass the request along the filter chain
        chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
