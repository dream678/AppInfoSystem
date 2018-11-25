package cn.appsys.controller.developer;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User:admin
 * Date:2018/11/24
 * Time:10:41
 * Desc:
 */
@Controller
@RequestMapping("/dev")
public class userController {
    @Resource
    private DevUserService devUserService;
    private Logger logger = Logger.getLogger(userController.class);

    @RequestMapping("/login")
    public String select() {
        logger.info("welcome ====================================");
        return "devlogin";
    }

    @RequestMapping("/dologin")
    public String dologin(@RequestParam("devCode") String devCode, @RequestParam("devPassword") String devPassword
            , HttpSession session) {
        DevUser devUser = devUserService.serlect(devCode, devPassword);
        if (devUser == null) {
            session.setAttribute("error", "账号或密码输入错误");
            return "redirect/dev/login";
        }
        session.setAttribute(Constants.DEV_USER_SESSION,devUser);
        return "developer/main";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute(Constants.DEV_USER_SESSION,"");
        return "devlogin";
    }
}


