package poly.dn.huyndai.UserContoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dn.huyndai.Entity.Car;
import poly.dn.huyndai.Service.CarService;

@Controller
public class ProductUserController {
	@Autowired
	CarService productService;
	
	@RequestMapping("/user/list")
	public String list() {
		return "user/home";
	}

	@GetMapping("/product/list")
public String showlogin(Model model, @RequestParam("cid") Optional<String> cid) {
    List<Car> list;
    
    if (cid.isPresent()) {
            list = productService.findByCategoryId(cid.get());
    } else {
        list = productService.findAll();
    }
    
    model.addAttribute("items", list);
    return "user/product/list";
}


	@RequestMapping("/product/detail/{id}")
	public String details(@PathVariable("id") Integer id, Model model) {
		Car product = productService.findById(id).get();

		model.addAttribute("product", product);
		return "user/product/detail";
	}


	@RequestMapping("/product/search")
	public String searchUnitPrice(Model model, @RequestParam("min") Optional<Double> min, @RequestParam("max") Optional<Double> max){

		double minUnitPrice = min.orElse(Double.MIN_VALUE);
		double maxUnitPrice = max.orElse(Double.MAX_VALUE);
		List<Car> cars = productService.findByPriceBetween(minUnitPrice, maxUnitPrice);
		model.addAttribute("items", cars);
		return "user/product/list";
	}
	
}