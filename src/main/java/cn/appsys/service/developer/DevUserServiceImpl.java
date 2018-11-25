package cn.appsys.service.developer;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User:admin
 * Date:2018/11/24
 * Time:10:54
 * Desc:
 */
@Service
@Transactional
public class DevUserServiceImpl implements DevUserService {
    @Resource(name = "devUserMapper")
    private DevUserMapper devUserMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public DevUser serlect(String devCode, String pwd) {
        DevUser devUser = null;
        try {
            devUser = devUserMapper.serlect(devCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!devUser.getDevPassword().equals(pwd)) {
            devUser = null;
        }
        return devUser;
    }

}
