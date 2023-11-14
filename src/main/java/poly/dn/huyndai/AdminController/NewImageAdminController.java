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
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import poly.dn.huyndai.Entity.Category;
import poly.dn.huyndai.Entity.Customer;
import poly.dn.huyndai.Entity.New;
import poly.dn.huyndai.Entity.NewsImage;
import poly.dn.huyndai.Model.CarModel;
import poly.dn.huyndai.Model.CustomerModel;
import poly.dn.huyndai.Model.NewModel;
import poly.dn.huyndai.Model.NewImageModel;
import poly.dn.huyndai.Service.NewImageService;
import poly.dn.huyndai.Service.NewService;
import poly.dn.huyndai.Service.StorageService;

@Controller
@RequestMapping("admin/newImages")

public class NewImageAdminController {
	
	@Autowired
	NewImageService newService;
	
	@Autowired
	NewService newsService;
	
	@Autowired
	StorageService storageService;

	
	@GetMapping("add")
	public String add(Model model) {
		NewImageModel dto = new NewImageModel();
		List<New> list = newsService.findAll();
		model.addAttribute("news", list);
		dto.setIsEdit(false);
		model.addAttribute("newImage", dto);
		
		
		
		return "admin/newImages/addOrEdit";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,@PathVariable("id") Long id) {
		
		Optional<NewsImage> opt =newService.findById(id);
		NewImageModel dto = new NewImageModel();
		if(opt.isPresent()) {
			
			NewsImage enCategory = opt.get();
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("newImage",dto);
			return new ModelAndView("admin/newImages/addOrEdit",model);
		}
		model.addAttribute("message","New is not existed");
		return new ModelAndView( "forward:/admin/newImages");
	
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id")Long Id,ModelMap model) {
		newService.deleteById(Id);
		
		model.addAttribute("message","NewImage is delete");
		
		return new ModelAndView("forward:/admin/newImages/search",model);
	}
	
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model
			,@Validated @ModelAttribute("newImage") NewImageModel newModel,BindingResult result) {
		
		NewsImage entity = new NewsImage();
		BeanUtils.copyProperties(newModel, entity);
		
		newService.save(entity);
		
		model.addAttribute("message","New is save");
		
		return new ModelAndView("forward:/admin/newImages",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<NewsImage> list = newService.findAll();
		modelMap.addAttribute("newImages",list);
		return "admin/newImages/list";
	}
	/*
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
	*/
}
