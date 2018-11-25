package cn.appsys.service.developer;

import cn.appsys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User:admin
 * Date:2018/11/24
 * Time:10:54
 * Desc:
 */
public interface DevUserService {
    public DevUser serlect( String devCode,String pwd);
}
