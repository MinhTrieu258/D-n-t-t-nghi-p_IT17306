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

import poly.dn.huyndai.Entity.Car;
import poly.dn.huyndai.Entity.Comment;
import poly.dn.huyndai.Entity.Customer;
import poly.dn.huyndai.Entity.Order;
import poly.dn.huyndai.Model.CommentModel;
import poly.dn.huyndai.Model.OrderModel;
import poly.dn.huyndai.Service.CarService;
import poly.dn.huyndai.Service.CommentService;

@Controller
@RequestMapping("user/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	@Autowired
	CarService carService;
	
	@GetMapping("add")
	public String add(Model model) {
		CommentModel dto = new CommentModel();
		
		
		List<Car> list1 = carService.findAll();
		model.addAttribute("products", list1);
		dto.setIsEdit(false);
		model.addAttribute("comment", dto);
		return "user/comments/addOrEdit";
	}
	
	
	@GetMapping("edit/{cmtId}")
	public ModelAndView edit(ModelMap model,@PathVariable("cmtId") Integer cmtId) {
		Optional<Comment> opt = commentService.findById(cmtId);
		
		CommentModel dto = new CommentModel();
		if(opt.isPresent()) {
			Comment enCategory = opt.get();
			
			
			
			
			List<Car> list1 = carService.findAll();
			model.addAttribute("products", list1);
			
			BeanUtils.copyProperties(enCategory, dto);
			
			
			dto.setIsEdit(true);
			System.out.println(dto.getCmtId());
			model.addAttribute("order",dto);
			return new ModelAndView("user/comment/addOrEdit",model);
		}
		model.addAttribute("message","Comment is not existed");
		return new ModelAndView( "forward:/user/comments",model);
	
	}
	
	@GetMapping("delete/{cmtId}")
	public ModelAndView delete(@PathVariable("cmtId")Integer cmtId,ModelMap model) {
		commentService.deleteById(cmtId);
		
		model.addAttribute("message","Cmt is delete");
		
		return new ModelAndView("forward:/user/comments/list",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model 
			,@Validated @ModelAttribute("comment") CommentModel commentModel ,BindingResult result) {
		
		Comment entity = new Comment();
		
		BeanUtils.copyProperties(commentModel, entity);
		
		
		
		
		Car dto1 = new Car();
		dto1.setId(commentModel.getCarId());
		
		commentService.save(entity);
		
		model.addAttribute("message","Comment is save");
		
		return new ModelAndView("forward:/user/comments",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Comment> list = commentService.findAll();
		modelMap.addAttribute("comments",list);
		return "user/comments/list";
	}
	
}
