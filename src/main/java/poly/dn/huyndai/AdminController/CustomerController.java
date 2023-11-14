package poly.dn.huyndai.AdminController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import poly.dn.huyndai.Entity.Category;
import poly.dn.huyndai.Entity.Customer;
import poly.dn.huyndai.Model.CustomerModel;
import poly.dn.huyndai.Service.CategoryService;
import poly.dn.huyndai.Service.CustomerService;


@Controller
@RequestMapping("admin/customers")

public class CustomerController {
  @Autowired
  CategoryService categoryService;
	@Autowired
	CustomerService customerService;
	
	@GetMapping("add")
	public String add(Model model) {
		
		model.addAttribute("customer", new CustomerModel());
		return "admin/customers/addOrEdit";
	}
	
	@GetMapping("edit/{username}")
	public ModelAndView edit(ModelMap model,@PathVariable("username") String customerId) {
		
		Optional<Customer> opt = customerService.findById(customerId);
		CustomerModel dto = new CustomerModel();
		if(opt.isPresent()) {
			
			Customer enCategory = opt.get();
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("customer",dto);
			return new ModelAndView("admin/customers/addOrEdit",model);
		}
		model.addAttribute("message","Customer is not existed");
		return new ModelAndView( "forward:/admin/customers");
	
	}
	
	@GetMapping("delete/{username}")
	public ModelAndView delete(@PathVariable("username")String customerId,ModelMap model) {
		customerService.deleteById(customerId);
		
		model.addAttribute("message","Customer is delete");
		
		return new ModelAndView("forward:/admin/customers/search",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model
			,@Validated @ModelAttribute("customer") CustomerModel customerModel,BindingResult result) {
		
		Customer entity = new Customer();
		BeanUtils.copyProperties(customerModel, entity);
		
		customerService.save(entity);
		
		model.addAttribute("message","Customer is save");
		
		return new ModelAndView("forward:/admin/customers",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Customer> list = customerService.findAll();
		modelMap.addAttribute("customers",list);
		return "admin/customers/list";
	}

	@GetMapping("search")
	public String search(ModelMap map,@RequestParam(name="name",required=false) String name) {
		List<Customer> list = null;
		if(StringUtils.hasText(name)) {
			list = customerService.findByNameContaining(name);
		}else {
			list = customerService.findAll();
		}
		map.addAttribute("customers",list);
		return "admin/customers/search";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap map,@RequestParam(name="name",required=false) String name,
			@RequestParam("page") Optional<Integer> page,@RequestParam("size") Optional<Integer> size) {
		List<Category> list = null;
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		Pageable pageable = PageRequest.of(currentPage-1,pageSize,Sort.by("name"));
		Page<Category> rePage=null;
		
		if(StringUtils.hasText(name)) {
			rePage = categoryService.findByNameContaining(name,pageable);
			map.addAttribute("name",name);
		}else {
			rePage = categoryService.findAll(pageable);
		}
		int totalPages = rePage.getTotalPages();
		if(totalPages > 0) {
			int star = Math.max(1, currentPage-2);
			int end = Math.min(currentPage + 2, totalPages);
			if(totalPages > 5) {
				if(end==totalPages) star = end - 5;
				else if(star == 1) end = star + 5;
			}
			List<Integer> pageNumber  = IntStream.rangeClosed(star, end).boxed().collect(Collectors.toList());
			map.addAttribute("pageNumbers",pageNumber);
		}
		map.addAttribute("categoryPage",rePage);
		return "admin/categories/searchpaginated";
	}
	
	
}
