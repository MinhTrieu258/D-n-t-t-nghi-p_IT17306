package poly.dn.huyndai.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poly.dn.huyndai.Service.CategoryService;

@Component
public class Globallnterceptor implements HandlerInterceptor {
    @Autowired
    CategoryService categoryService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
    ModelAndView modelAndView) throws Exception{
        request.setAttribute("cates", categoryService.findAll());
    }
}
