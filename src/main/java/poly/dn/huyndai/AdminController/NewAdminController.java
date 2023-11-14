package poly.dn.huyndai.AdminController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import poly.dn.huyndai.Entity.Customer;
import poly.dn.huyndai.Entity.New;

import poly.dn.huyndai.Model.NewImageModel;
import poly.dn.huyndai.Model.NewModel;
import poly.dn.huyndai.Service.CustomerService;
import poly.dn.huyndai.Service.NewService;

@Controller
@RequestMapping("admin/new")
public class NewAdminController {
	@Autowired
	NewService newService;
	@Autowired
	CustomerService customerService;
	
	@GetMapping("add")
	public String add(Model model) {
		NewImageModel dto = new NewImageModel();
		List<Customer> list = customerService.findAll();
		model.addAttribute("customers", list);
		dto.setIsEdit(false);
		model.addAttribute("new", dto);
		
		
		
		return "admin/new/addOrEdit";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,@PathVariable("id") Long id) {
		
		Optional<New> opt = newService.findById(id);
		NewModel dto = new NewModel();
		if(opt.isPresent()) {
			
			New enCategory = opt.get();
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("new",dto);
			return new ModelAndView("admin/new/addOrEdit",model);
		}
		model.addAttribute("message","New is not existed");
		return new ModelAndView( "forward:/admin/new");
	
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id")Long Id,ModelMap model) {
		newService.deleteById(Id);
		
		model.addAttribute("message","NewImage is delete");
		
		return new ModelAndView("forward:/admin/new/search",model);
	}
	

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model
			,@Validated @ModelAttribute("new") NewModel newModel,BindingResult result) {
		
		New entity = new New();
		BeanUtils.copyProperties(newModel, entity);
		
		newService.save(entity);
		
		model.addAttribute("message","New is save");
		
		return new ModelAndView("forward:/admin/new",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<New> list = newService.findAll();
		modelMap.addAttribute("news",list);
		return "admin/new/list";
	}
}
