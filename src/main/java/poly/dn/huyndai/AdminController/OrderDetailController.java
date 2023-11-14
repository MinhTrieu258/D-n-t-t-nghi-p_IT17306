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
import org.springframework.web.servlet.ModelAndView;

import poly.dn.huyndai.Entity.Order;
import poly.dn.huyndai.Entity.OrderDetail;
import poly.dn.huyndai.Model.OrderDetailModel;
import poly.dn.huyndai.Service.CarService;
import poly.dn.huyndai.Service.CategoryService;
import poly.dn.huyndai.Service.OrderDetailService;
import poly.dn.huyndai.Service.OrderService;


@Controller
@RequestMapping("admin/orderDetails")

public class OrderDetailController {
@Autowired
	CategoryService categoryService;
	@Autowired
	CarService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDetailService orderDetailService;
	@GetMapping("add")
	public String add(Model model) {
		OrderDetailModel dto = new OrderDetailModel();
		
		List<Order> listOrder = orderService.findAll();

		model.addAttribute("orders", listOrder);
		dto.setIsEdit(false);
		model.addAttribute("orderDetail", dto);
		return "admin/orderDetails/addOrEdit";
	}
	
	@GetMapping("edit/{orderDetailId}")
	public ModelAndView edit(ModelMap model,@PathVariable("orderDetailId") Long orderDetailId) {
		Optional<OrderDetail> opt = orderDetailService.findById(orderDetailId);
		
		List<Order> listOrder = orderService.findAll();
	
		model.addAttribute("orders", listOrder);
		OrderDetailModel dto = new OrderDetailModel();
		if(opt.isPresent()) {
			OrderDetail enCategory = opt.get();
					
			BeanUtils.copyProperties(enCategory, dto);
			
	
			dto.setOrderId(enCategory.getOrder().getOrderId());		
			dto.setIsEdit(true);
			System.out.println(orderDetailId);
			model.addAttribute("orderDetail",dto);
			return new ModelAndView("admin/orderDetails/addOrEdit",model);
		}
		model.addAttribute("message","Order Detail is not existed");
		return new ModelAndView( "forward:/admin/orderDetails",model);
	
	}
	
	@GetMapping("delete/{orderDetailId}")
	public ModelAndView delete(@PathVariable("orderDetailId")Long orderId,ModelMap model) {
		orderDetailService.deleteById(orderId);
		
		model.addAttribute("message","Order is delete");
		
		return new ModelAndView("forward:/admin/orderDetails",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model 
			,@Validated @ModelAttribute("orderDetail") OrderDetailModel orderModel ,BindingResult result) {
		
		OrderDetail entity = new OrderDetail();
		
		BeanUtils.copyProperties(orderModel, entity);
		
	
		Order order = new Order();
		order.setOrderId(orderModel.getOrderId());
		entity.setOrder(order);	
		
	
		
		orderDetailService.save(entity);
		
		model.addAttribute("message","Order Detail is save");
		
		return new ModelAndView("forward:/admin/orderDetails",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<OrderDetail> list = orderDetailService.findAll();
		modelMap.addAttribute("orderDetails",list);
		return "admin/orderDetails/list";
	}


	
	

	
}
