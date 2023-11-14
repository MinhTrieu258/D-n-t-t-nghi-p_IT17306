package poly.dn.huyndai.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.dn.huyndai.Entity.Category;
import poly.dn.huyndai.Service.CategoryService;

@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<Category> list(){
        return categoryService.findAll();
    }
}
