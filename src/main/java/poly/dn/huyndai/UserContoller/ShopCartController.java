package poly.dn.huyndai.UserContoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopCartController {
    
    @GetMapping("/cart/view")
    public String list(){
        return "user/cart/view";
    }
}
