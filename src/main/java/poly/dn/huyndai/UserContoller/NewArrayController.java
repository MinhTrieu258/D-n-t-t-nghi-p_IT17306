package poly.dn.huyndai.UserContoller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import poly.dn.huyndai.Entity.New;
import poly.dn.huyndai.Entity.NewsImage;
import poly.dn.huyndai.Entity.Order;
import poly.dn.huyndai.Model.NewImageModel;
import poly.dn.huyndai.Service.NewImageService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class NewArrayController {
    @Autowired
    NewImageService newArrayService;

    @RequestMapping("newArray")
    public String add(Model model) {
        List<NewsImage> list = newArrayService.findAll();
        model.addAttribute("news", list);
        model.addAttribute("newArr", new NewsImage());

        return "user/common/NewArray";
    }

    @PostMapping("/saveArr")
    public ModelAndView save(ModelMap modelMap, @ModelAttribute("newArr") NewsImage newArrayModel) {
        NewsImage entity = new NewsImage();
        BeanUtils.copyProperties(newArrayModel, entity);

        Date currentDate = new Date();
        entity.setCreatedDate(currentDate);

        newArrayService.save(entity);
        modelMap.addAttribute("message", "Thêm thành công");
        return new ModelAndView("forward:/newArray", modelMap);
    }
}
