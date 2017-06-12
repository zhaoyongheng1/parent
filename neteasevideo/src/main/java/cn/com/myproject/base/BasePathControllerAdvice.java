package cn.com.myproject.base;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liyang-macbook on 2017/6/7.
 */
@ControllerAdvice
public class BasePathControllerAdvice {

    @ModelAttribute
    public void basePath(HttpServletRequest request, Model model){
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String path = request.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        model.addAttribute("basePath",basePath);
    }
}
