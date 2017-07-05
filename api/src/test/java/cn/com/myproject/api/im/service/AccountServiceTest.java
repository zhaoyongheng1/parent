package cn.com.myproject.api.im.service;

import cn.com.myproject.api.im.VO.*;
import cn.com.myproject.api.im.VO.account.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void createTest() {
        IMCreateVO createVO = new IMCreateVO();
        createVO.setAccid("honglan1009");
        createVO.setName("honglan1009");
        ResultInfo vo =  accountService.create(createVO);
        Assert.assertEquals("状态码",vo.getCode()+"","200");
    }

    @Test
    public void updateTest() {
        IMUpdateVO updateVO = new IMUpdateVO();
        updateVO.setAccid("honglan10091");
        updateVO.setToken("111111111111111111");
        Result vo =  accountService.update(updateVO);
        Assert.assertEquals("状态码",vo.getCode()+"","200");
    }

    @Test
    public void refreshTokenTest(){
        IMRefreshTokenVO vo = new IMRefreshTokenVO();
        vo.setAccid("honglan1009");
        ResultInfo result = accountService.refreshToken(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }


    @Test
    public void blockTest(){
        IMBlockVO vo = new IMBlockVO();
        vo.setAccid("honglan10091");
        Result result = this.accountService.block(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }

    @Test
    public void unBlockTest(){
        IMUnBlockVO vo = new IMUnBlockVO();
        vo.setAccid("honglan10091");
        Result result = this.accountService.unBlock(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }

    @Test
    public void updateUinfoTest(){
        IMUpdateUinfoVO vo = new IMUpdateUinfoVO();
        vo.setAccid("honglan10091");
        vo.setName("红懒");
        vo.setSign("宁静致远");
        vo.setEmail("598048929@qq.com");
        vo.setBirth("2016-01-01");
        vo.setMobile("18600890788");
        vo.setGender("1");
        Result result = this.accountService.updateUinfo(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }

    @Test
    public void getUinfosTest(){
        IMGetUinfosVO vo = new IMGetUinfosVO();
        List<String> list = new ArrayList<>();
        list.add("honglan10091");
        vo.setAccids(list);
        ResultUinfos result = this.accountService.getUinfos(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }

    @Test
    public void setDonnopTest(){
        IMSetDonnopVO vo = new IMSetDonnopVO();
        vo.setAccid("honglan10091");
        vo.setDonnopOpen("true");

        Result result = this.accountService.setDonnop(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }

}
