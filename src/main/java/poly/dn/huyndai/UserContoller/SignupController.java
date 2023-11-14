package poly.dn.huyndai.UserContoller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import poly.dn.huyndai.Entity.Customer;
import poly.dn.huyndai.Model.CustomerModel;
import poly.dn.huyndai.Service.CustomerService;

@Controller
public class SignupController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("Signup")
    public  String list(Model model){
        model.addAttribute("customer", new CustomerModel());
        return "user/common/register";
    }
    @PostMapping("/save")
    public ModelAndView save(ModelMap modelMap, @Valid  @ModelAttribute("customer")CustomerModel customerModel, BindingResult result){
  if (result.hasErrors()){
      modelMap.addAttribute("error", "Đăng ký thất bại");
      return new ModelAndView( "user/common/register",modelMap);
  }else {
      Customer entity = new Customer();
      BeanUtils.copyProperties(customerModel, entity);

      customerService.save(entity);
      modelMap.addAttribute("message", "Đăng ký thành công");


      return new ModelAndView("forward:/Signup", modelMap);
  }
    }
}
