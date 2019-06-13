package utils;

import java.util.HashMap;
import java.util.Map;

import model.User; // our model User
import config.SecurityConfig; // our roles

public class DataDao {

private static final Map<String, User> mapUsers = new HashMap<String, User>();
	   
static {
	      initUsers();	
 	}
	      
private static void initUsers() {
	 
    // This user has a role as ASUP.
    User asup = new User(1,"Анатолий Николаевич","Желизнык","1","1", 10, SecurityConfig.ROLE_ASUP);
    //users.add(new User(UserDb.selectone(0)));
    //User asup = new User(1,"а","fio","1","а", 10, SecurityConfig.ROLE_ASUP);

    // This user has a role Jurist.
    //User jur = new User(3,"Наталья Алексеевна","Курникова","3","3", 30, SecurityConfig.ROLE_JURIST);
    User jur = new User(3,"Наталья Алексеевна","Курникова","3","3", 30, SecurityConfig.ROLE_JURIST);

    mapUsers.put(asup.getName(), asup); // insert data on the map
    mapUsers.put(jur.getName(), jur); //
 }

 // Find a User by userName and password.
 public static User findUser(String login, String password) {
    User u = mapUsers.get(login);
    if (u != null && u.getPassword().equals(password)) {
    	System.out.println("метод findUser : Юзераккаунт НЕнулевой");
       return u;
    }
		/*
		 * // получим объект по ключу 2 User asup = mapUsers.get(1);
		 * System.out.println(asup); User asup2 = mapUsers.get(0);
		 * System.out.println(asup2);
		 */
    System.out.println("метод findUser : Юзераккаунт нулевой");
    return null;
 }	      
	      
	      
	      
}
