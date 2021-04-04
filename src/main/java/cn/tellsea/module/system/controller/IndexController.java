package cn.tellsea.module.system.controller;

import cn.tellsea.frame.dto.layuimini.HomeInfo;
import cn.tellsea.frame.dto.layuimini.LoginInfo;
import cn.tellsea.module.system.service.ResourceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tellsea
 * @date 2021/03/29
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceInfoService resourceInfoService;

    @GetMapping("/")
    public String index() {
        return "admin/index";
    }

    @GetMapping("initData")
    @ResponseBody
    public Map initData() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("homeInfo", new HomeInfo().setTitle("首页").setHref("/home"));
        map.put("logoInfo", new LoginInfo().setTitle("StrawShiro").setImage("/static/layuimini/images/logo.png"));
        map.put("menuInfo", resourceInfoService.listAllByMenu());
        return map;
    }

    @GetMapping("home")
    public String home() {
        return "admin/home";
    }
}
