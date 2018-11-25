package cn.appsys.dao.devuser;

import cn.appsys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.aop.target.LazyInitTargetSource;

/**
 * Created with IntelliJ IDEA.
 * User:admin
 * Date:2018/11/24
 * Time:10:41
 * Desc:
 */
public interface DevUserMapper {
    public DevUser serlect(@Param("devCode") String devCode);

}
