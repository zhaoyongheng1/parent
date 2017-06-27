import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by liyang-macbook on 2017/6/21.
 */
public class D {
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String str = encoder.encode("honglan1009");
        System.out.println(str);
        str =  encoder.encode("honglan1009");
        System.out.println(str);
        str = new Md5PasswordEncoder().encodePassword("honglan1009","myproject");
        System.out.println(str);
    }
}
