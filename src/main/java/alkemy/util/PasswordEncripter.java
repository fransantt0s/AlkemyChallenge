package alkemy.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncripter {
    public static void main(String[] args) {
        
        var password = "123";
        System.out.println("password: " + password);
        System.out.println("password encriptado:" + encriptPassword(password));
    }
    
    public static String encriptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
