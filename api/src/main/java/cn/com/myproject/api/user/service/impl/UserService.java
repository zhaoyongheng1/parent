package cn.com.myproject.api.user.service.impl;

import cn.com.myproject.api.im.VO.ResultInfo;
import cn.com.myproject.api.im.VO.account.IMCreateVO;
import cn.com.myproject.api.im.service.IAccountService;
import cn.com.myproject.api.user.entity.PO.User;
import cn.com.myproject.api.user.entity.VO.UserStatus;
import cn.com.myproject.api.user.mapper.UserMapper;
import cn.com.myproject.api.user.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Map;
import java.util.UUID;

/**
 * Created by liyang-macbook on 2017/6/30.
 */
@Service
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IAccountService accountService;

    @Override
    @Transactional
    public void reigister(User user) {

        user.setVersion(1);
        user.setCreateTime(Calendar.getInstance().getTimeInMillis());
        user.setStatus(UserStatus.S_1.getId());
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));

        int i = userMapper.insert(user);

        if(i == 1) {
            IMCreateVO vo = new IMCreateVO();
            vo.setAccid(UUID.randomUUID().toString().replace("-",""));
            vo.setName(user.getNickName());
            ResultInfo result = accountService.create(vo);
            if(result.getCode() == 200) {
                Map<String,String> map =  result.getInfo();
                int updatenum = userMapper.updateAccId(user.getLoginName(),map.get("accid"),map.get("token"));
                if(updatenum != 1) {
                    logger.error("插入用户失败userMapper.updateAccId,accid="+map.get("accid"));
                    throw new RuntimeException("更新失败");
                }
            }else {
                logger.error("插入用户失败userMapper.insert(user)");
                throw new RuntimeException("创建网易IM账号失败");
            }
        }else {
            logger.error("插入用户失败userMapper.insert(user)");
            throw new RuntimeException("插入失败");
        }

    }

    @Override
    public User getByLogin(String loginName) {
        return userMapper.selectByLoginName(loginName);
    }

    @Override
    public User login(String loginName, String pwd) {
        User user = null;
        User _user = userMapper.selectByLoginName(loginName);
        if(null != _user && DigestUtils.md5Hex(pwd).equals(_user.getPassword())){
            user = _user;
        }
        return user;
    }
}
