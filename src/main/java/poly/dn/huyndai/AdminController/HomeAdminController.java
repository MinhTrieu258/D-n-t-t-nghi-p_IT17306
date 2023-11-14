package poly.dn.huyndai.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAdminController {
	@RequestMapping({"/","/home/index"})
	public String user(){
		return "redirect:/home";
	}
	  @GetMapping("admin")
	  public String list() {
		  return "admin/home/index";
	  }
	

}
