package poly.dn.huyndai.AdminController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import poly.dn.huyndai.Entity.Car;
import poly.dn.huyndai.Entity.Customer;
import poly.dn.huyndai.Entity.Order;
import poly.dn.huyndai.Model.OrderModel;
import poly.dn.huyndai.Service.CarService;
import poly.dn.huyndai.Service.CategoryService;
import poly.dn.huyndai.Service.CustomerService;
import poly.dn.huyndai.Service.OrderService;



@Controller
@RequestMapping("admin/orders")

public class OrderController {
@Autowired
	CategoryService categoryService;
	@Autowired
	CustomerService customerService;
	@Autowired
	CarService productService;
	@Autowired
	OrderService orderService;
	@GetMapping("add")
	public String add(Model model) {
		OrderModel dto = new OrderModel();
		List<Customer> list = customerService.findAll();
		model.addAttribute("customers", list);
		
		List<Car> list1 = productService.findAll();
		model.addAttribute("products", list1);
		dto.setIsEdit(false);
		model.addAttribute("order", dto);
		return "admin/orders/addOrEdit";
	}
	
	@GetMapping("edit/{orderId}")
	public ModelAndView edit(ModelMap model,@PathVariable("orderId") Long orderId) {
		Optional<Order> opt = orderService.findById(orderId);
		
		OrderModel dto = new OrderModel();
		if(opt.isPresent()) {
			Order enCategory = opt.get();
			
			List<Customer> list = customerService.findAll();
			model.addAttribute("customers", list);
			
			
			List<Car> list1 = productService.findAll();
			model.addAttribute("products", list1);
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setUsername(enCategory.getCustomer().getUsername());
			
			dto.setIsEdit(true);
			System.out.println(dto.getOrderId());
			model.addAttribute("order",dto);
			return new ModelAndView("admin/orders/addOrEdit",model);
		}
		model.addAttribute("message","Order is not existed");
		return new ModelAndView( "forward:/admin/orders",model);
	
	}
	
	@GetMapping("delete/{orderId}")
	public ModelAndView delete(@PathVariable("orderId")Long orderId,ModelMap model) {
		orderService.deleteById(orderId);
		
		model.addAttribute("message","Order is delete");
		
		return new ModelAndView("forward:/admin/orders/search",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model 
			,@Validated @ModelAttribute("order") OrderModel orderModel ,BindingResult result) {
		
		Order entity = new Order();
		
		BeanUtils.copyProperties(orderModel, entity);
		
		Customer dto = new Customer();
		dto.setUsername(orderModel.getUsername());
		entity.setCustomer(dto);
		
		
		Car dto1 = new Car();
		dto1.setId(orderModel.getCarId());
		
		orderService.save(entity);
		
		model.addAttribute("message","Order is save");
		
		return new ModelAndView("forward:/admin/orders",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Order> list = orderService.findAll();
		modelMap.addAttribute("orders",list);
		return "admin/orders/list";
	}

	
	@GetMapping("search")
	public String search(ModelMap map,@RequestParam(name="min",required=false) Double min) {
		List<Order> list = null;
		if(min == null) {
			list = orderService.findAll();
		}else {
			list = orderService.searhByAmount(min);
		}
		map.addAttribute("orders",list);
		return "admin/orders/search";
	}
	
	
	
}
