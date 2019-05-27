package utils;
/*This class is utility class that has methods helping to check 
must do any request(query) to execute login or not login.
Класс  SecurityUtils является утилитарным классом, он имеет методы, 
помогающие проверить обязывает ли  request (запрос) выполнить логин 
или нет, и подходит ли тот  request с ролью пользователя вошедшего в 
систему или нет.*/

import java.util.List;
import java.util.Set;
 
import javax.servlet.http.HttpServletRequest;
import config.SecurityConfig;


public class SecurityUtils {

    // Проверить требует ли данный 'request' входа в систему или нет.
	//Check whether the given 'request' requires login or not.
    public static boolean isSecurityPage(HttpServletRequest request) {
    	System.out.println("начинаем проверку требует ли данный 'request' входа в систему или нет");
        String urlPattern = UrlPatternUtils.getUrlPattern(request); // call method from class UrlPatternUtils
 
        Set<String> roles = SecurityConfig.getAllAppRoles();
 
        for (String role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns!=null && urlPatterns.contains(urlPattern)) {
            	System.out.println("request проверка успешна");
                return true;
            }
        }
        System.out.println("request проверка отрицательна");
        return false;
    }	

    
    
    //Check if the given(данный) request has a suitable(подходящую) role?
    public static boolean hasPermission(HttpServletRequest request) {
    	System.out.println("начинаем проверку имеет ли данный 'request' подходящую роль");
    	String urlPattern = UrlPatternUtils.getUrlPattern(request); // call method from class UrlPatternUtils
 
        Set<String> allRoles = SecurityConfig.getAllAppRoles();
 
        for (String role : allRoles) {
            if (!request.isUserInRole(role)) {
                continue;
            }
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
            	System.out.println("role проверка успешна");
            	return true;
            }
        }
        System.out.println("role проверка отрицательна");
        return false;
    }    
	
    
}
