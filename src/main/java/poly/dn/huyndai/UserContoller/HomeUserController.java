package poly.dn.huyndai.UserContoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeUserController {
    @GetMapping("/home")
    public String lists(){
        return "user/home/index";
    }
    
}
