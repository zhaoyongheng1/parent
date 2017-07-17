package cn.com.myproject.user.controller;

import cn.com.myproject.user.entity.VO.SysUserVO;
import cn.com.myproject.user.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liyang-macbook on 2017/7/11.
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private IUserService userService;

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
    public PageInfo<SysUserVO> list(Integer rows,Integer page) {
        PageInfo<SysUserVO> info = userService.getPage(page,rows);
        return info;
    }
}
