package poly.dn.huyndai.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TinTucAdminController {
    @GetMapping("tintuc")
    public String list(){
        return "";
    }
}
