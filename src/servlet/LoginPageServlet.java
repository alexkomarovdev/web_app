package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import model.User;
import utils.AppUtils;
import utils.DataDao;

/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginPageServlet") //alternative declare of servlets
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String index = "/WEB-INF/view/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		req.getRequestDispatcher(index).forward(req, resp); // we give login.jsp to PC-user
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
        String login = req.getParameter("login");
        System.out.println("введенный логин ");
        System.out.println(login);
        String password = req.getParameter("password");
        System.out.println("введенный пароль");
        System.out.println(password);
        User user = DataDao.findUser(login, password);
 
        if (user == null) {
            String errorMessage = "Invalid userName or Password";
            System.out.println("Юзераккаунт нулевой");
            req.setAttribute("errorMessage", errorMessage);
 
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
 
            dispatcher.forward(req, resp);
            return;
        }
 
        AppUtils.storeLoginedUser(req.getSession(), user);
        System.out.println("создаем сессию Юзераккаунт ");
        // 
        int redirectId = -1;
        try {
            redirectId = Integer.parseInt(req.getParameter("redirectId"));
        } catch (Exception e) {
        }
        String requestUri = AppUtils.getRedirectAfterLoginUrl(req.getSession(), redirectId);
        if (requestUri != null) {
            resp.sendRedirect(requestUri);
        } else {
            // По умолчанию после успешного входа в систему
            // перенаправить на страницу /userInfo
        	
            resp.sendRedirect(req.getContextPath() + "/UserInfoServlet");
            System.out.println("перенаправляем ");
        }
 
    
	}

}
