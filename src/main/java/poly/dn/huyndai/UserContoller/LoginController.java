package poly.dn.huyndai.UserContoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    // Chưa đăng nhập
    @RequestMapping("/login/form")
    public String login (){

        return "user/common/login";
    }

    // Đâng nhập thành công
    @RequestMapping("/login/success")
    public  String loginSuccess (Model model){
        model.addAttribute("message","Đăng nhập thảnh công");
        return "user/common/login";
    }
    // Đăng nhập sai thông tin
    @RequestMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("error","Sai thông tin đăng nhập");
        return "user/common/login";

    }
    // Phân quyền truy cập
    @RequestMapping("/login/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("error","Không có quyền truy cập");
        return "user/common/login";
    }

    @RequestMapping("/logoff/success")
    public String loginOffSuccess(Model model){
        model.addAttribute("message","Đăng xuất thành công");
        return "user/common/login";
    }

}
