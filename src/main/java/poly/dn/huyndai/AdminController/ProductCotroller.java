package poly.dn.huyndai.AdminController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import poly.dn.huyndai.Entity.Car;
import poly.dn.huyndai.Entity.Category;
import poly.dn.huyndai.Model.CarModel;
import poly.dn.huyndai.Service.CarService;
import poly.dn.huyndai.Service.CategoryService;
import poly.dn.huyndai.Service.StorageService;



@Controller
@RequestMapping("admin/products")
public class ProductCotroller {
	@Autowired
	CarService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	StorageService storageService;

	@GetMapping("add")
	public String add(Model model) {
		CarModel dto = new CarModel();
		List<Category> list = categoryService.findAll();
		model.addAttribute("categories", list);
		dto.setIsEdit(false);
		model.addAttribute("product", dto);
		return "admin/products/addOrEdit";
	}
	public void lisCategory() {
		
	}
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Integer id) {
		Optional<Car> opt = productService.findById(id);
		
		CarModel dto = new CarModel();
		if (opt.isPresent()) {
			Car enCategory = opt.get();
			
			List<Category> list = categoryService.findAll();
			model.addAttribute("categories", list);
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setId(enCategory.getCategory().getId());
			dto.setIsEdit(true);

			model.addAttribute("product", dto);
			return new ModelAndView("admin/products/addOrEdit", model);
		}
		
		
		model.addAttribute("message", "Product is not existed");
		return new ModelAndView("forward:/admin/products", model);

	}

	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id, ModelMap model) throws IOException {
		Optional<Car> otp = productService.findById(id);
		if (otp.isPresent()) {
			if(!StringUtils.isEmpty(otp.get().getImage())){
				storageService.delete(otp.get().getImage());
			}
			productService.delete(otp.get());
			model.addAttribute("message", "Product is delete");
		}else {
			model.addAttribute("message","Product not delete");
		}
		
		return new ModelAndView("forward:/admin/products", model);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Validated @ModelAttribute("product") CarModel productModel,
			BindingResult result) {
		
		
		Car entity = new Car();
		
		BeanUtils.copyProperties(productModel, entity);
		
		Category category = new Category();
		
		category.setId(productModel.getId());
		
		entity.setCategory(category);
	

		if (!productModel.getImageFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();

			entity.setImage(storageService.getStoredFileName(productModel.getImageFile(), uuString));
			storageService.store(productModel.getImageFile(), entity.getImage());
		}

		productService.save(entity);
		model.addAttribute("message", "Product is save");

		return new ModelAndView("forward:/admin/products", model);
	}

	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Car> list = productService.findAll();
		modelMap.addAttribute("products", list);
		return "admin/products/list";
	}
	
	
	@GetMapping("search")
	public String search(ModelMap map, @RequestParam(name = "name", required = false) String name) {
		List<Car> list = null;
		if (StringUtils.hasText(name)) {
			list = productService.findByNameContaining(name);
		} else {
			list = productService.findAll();
		}
		map.addAttribute("products", list);
		return "admin/products/search";
	}

	@GetMapping("searchpaginated")
	public String search(ModelMap map, @RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		List<Car> list = null;
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("name"));
		Page<Car> rePage = null;

		if (StringUtils.hasText(name)) {
			rePage = productService.findByNameContaining(name, pageable);
			map.addAttribute("name", name);
		} else {
			rePage = productService.findAll(pageable);
		}
		int totalPages = rePage.getTotalPages();
		if (totalPages > 0) {
			int star = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPages);
			if (totalPages > 5) {
				if (end == totalPages)
					star = end - 5;
				else if (star == 1)
					end = star + 5;
			}
			List<Integer> pageNumber = IntStream.rangeClosed(star, end).boxed().collect(Collectors.toList());
			map.addAttribute("pageNumbers", pageNumber);
		}
		map.addAttribute("productPage", rePage);
		return "admin/products/searchpaginated";
	}

}
