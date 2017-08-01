package cn.com.myproject.user.controller;


import cn.com.myproject.service.ISysUserService;
import cn.com.myproject.service.IUploadImgService;
import cn.com.myproject.sysuser.entity.VO.SysUserVO;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liyang-macbook on 2017/7/11.
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController {
    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private ISysUserService sysUserService;


    @RequestMapping("/")
    public String index() {
        return "sys/user";
    }

    @RequestMapping("/add")
    public String add() {
        return "sys/user_add";
    }



    @ResponseBody
    @RequestMapping("/list")
    public PageInfo<SysUserVO> list(Integer rows, Integer page) {
        PageInfo<SysUserVO> info = sysUserService.getPage(page,rows);
        return info;
    }

    @RequestMapping("/demoUE")
    public String demoUE() {
        return "demoUE";
    }

}
