package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SecurityConfig {

    public static final String ROLE_ASUP = "ASUP";
    public static final String ROLE_JURIST = "JURIST";
 
    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();	

    
    static {
        init();
    }
 
    private static void init() {
 
        // Config for role "ASUP".
        List<String> urlPatterns1 = new ArrayList<String>();
 
        urlPatterns1.add("/userInfo");
        urlPatterns1.add("/ASUPTask");
 
        mapConfig.put(ROLE_ASUP, urlPatterns1);
 
        // Config for role "JURIST".
        List<String> urlPatterns2 = new ArrayList<String>();
 
        urlPatterns2.add("/userInfo");
        urlPatterns2.add("/JuristTask");
 
        mapConfig.put(ROLE_JURIST, urlPatterns2);
    }
 
    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }
 
    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }    
    
    
}
