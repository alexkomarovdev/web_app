package filter;

/*SecurityFilter является  Servlet Filter, который выполняет обязанность проверки всех  request 
перед тем как позволить получить доступ в защищенные страницы (page). 
SecurityFilter читает  "конфигурации безопасности" 
объявленные в классе  SecurityConfig.
SecurityFilter read safety configs declared on class SecurityConfig*/

import java.io.IOException;
import java.util.List;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import model.User;
import request.UserRoleRequestWrapper;
import utils.AppUtils;
import utils.SecurityUtils;

@WebFilter("/*")
public class SecurityFilter implements Filter { // after activing of interface had added three methods

	public SecurityFilter () {
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		/*
		 * Запрос от браузера поступает серверу в виде объекта типа HttpServletRequest.
		 * Этот интерфейс наследует свойства интерфейса ServletRequest. Методы
		 * интерфейса ServletRequest позволяют получать дополнительную информацию, в том
		 * числе и о сервлете и деталях протокола HTTP запроса		 
		 * http://java-online.ru/servlet-questions.xhtml */	
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
 
        String servletPath = request.getServletPath();
 
        // Информация пользователя сохранена в Session
        // (После успешного входа в систему).
        User loginedUser = AppUtils.getLoginedUser(request.getSession());
 
        if (servletPath.equals("/LoginPageServlet")) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest wrapRequest = request;
 
        if (loginedUser != null) {
            // User Name
            String userName = loginedUser.getName();
 
            // Роли (Role).
            List<String> roles = loginedUser.getRoles();
 
            // Старый пакет request с помощью нового Request с информацией userName и Roles.
            wrapRequest = new UserRoleRequestWrapper(userName, roles, request);
        }
 
        // Страницы требующие входа в систему.
        if (SecurityUtils.isSecurityPage(request)) {
 
            // Если пользователь еще не вошел в систему,
            // Redirect (перенаправить) к странице логина.
            if (loginedUser == null) {
 
                String requestUri = request.getRequestURI();
 
                // Сохранить текущую страницу для перенаправления (redirect) после успешного входа в систему.
                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);
 
                response.sendRedirect(wrapRequest.getContextPath() + "/LoginPageServlet?redirectId=" + redirectId);
                return;
            }
 
            // Проверить пользователь имеет действительную роль или нет?
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
 
                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDeniedView.jsp");
 
                dispatcher.forward(request, response);
                return;
            }
        }
 
        chain.doFilter(wrapRequest, response);		
	}	
	
}
