package poly.dn.huyndai.UserContoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAccountController {
    @RequestMapping("UserAcc")
    public String list(){
        return "user/common/taikhoan";
    }
}
