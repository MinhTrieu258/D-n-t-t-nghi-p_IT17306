package poly.dn.huyndai.UserContoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    
    @GetMapping("about")
    public String list(){
        return "user/common/about";
    }
}
