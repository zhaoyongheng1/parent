package cn.com.myproject.api.im.service;

import cn.com.myproject.api.im.VO.channel.GetTokenReturnVO;
import cn.com.myproject.api.im.VO.channel.GetTokenVO;
import cn.com.myproject.api.im.VO.channel.IMCreateVO;
import cn.com.myproject.api.im.VO.channel.ResultChannel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liyang-macbook on 2017/7/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IMChannelServiceTest {


    @Autowired
    private IIMChannelService imChannelService;

    @Test
    public void testCreate(){
        IMCreateVO vo = new IMCreateVO();
        vo.setName("红懒的直播间——宁静致远");
        ResultChannel channel = imChannelService.create(vo);
        Assert.assertEquals("状态码",channel.getCode()+"","200");
    }
    @Test
    public void testGetToken() {
        GetTokenVO vo = new GetTokenVO();
        vo.setAccid("6e7d77e7331e4a5680274b4b4f835475");
        GetTokenReturnVO getTokenReturnVO = imChannelService.getToken(vo);
        Assert.assertEquals("状态码",getTokenReturnVO.getCode()+"","200");
    }

}
