package cn.waicaibao.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liyang-macbook on 2016/11/17.
 */
@RestController
public class DemoController {

  //  @Autowired
    private OAuth2RestOperations restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://API-GATEWAY/demo/add?a=10&b=20", String.class).getBody();
    }
}
