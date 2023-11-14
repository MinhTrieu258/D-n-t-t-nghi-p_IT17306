package poly.dn.huyndai.UserContoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThanhToanController {

    @GetMapping("ThanhToan")
    public String thanhtoan(){

        return "user/common/thanhtoan";
    }
}
