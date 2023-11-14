package poly.dn.huyndai.UserContoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import poly.dn.huyndai.Entity.New;
import poly.dn.huyndai.Service.NewService;

@Controller
public class NewController {
    @Autowired
     NewService newsService; // Đây là một service để truy xuất dữ liệu tin tức.
    @GetMapping("/user/news")
    public String listNews(Model model) {
      List<New> newsList = newsService.findAll(); // Lấy danh sách tin tức từ service, bao gồm danh sách hình ảnh.

        model.addAttribute("newsList", newsList); // Truyền danh sách tin tức đến trang HTML.


        return "user/common/new1"; // Trả về tên trang HTML để hiển thị danh sách tin tức.
    }
}
