package cn.tellsea.module.system.controller;

import cn.tellsea.frame.aop.annotation.LoginLog;
import cn.tellsea.frame.consts.SessionConst;
import cn.tellsea.frame.dto.ResponseResult;
import cn.tellsea.frame.shiro.util.ShiroUtils;
import cn.tellsea.frame.util.CaptchaUtils;
import cn.tellsea.module.system.service.ResourceInfoService;
import cn.tellsea.module.system.service.RoleInfoService;
import cn.tellsea.module.system.service.UserInfoService;
import cn.tellsea.module.system.vo.UserInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * 登录控制器
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private ResourceInfoService resourceInfoService;

    @ApiOperation("跳转登录页")
    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    @ApiOperation("登录")
    @PostMapping("login")
    @ResponseBody
    @LoginLog
    public ResponseResult login(@RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam(value = "rememberMe", required = false) boolean rememberMe,
                                @RequestParam("captcha") String captcha,
                                HttpServletRequest request) {
        // 校验验证码
        String sessionCaptcha = (String) ShiroUtils.getSessionAttribute(SessionConst.KEY_CAPTCHA);
        if (null == captcha || !captcha.equalsIgnoreCase(sessionCaptcha)) {
            return ResponseResult.error("验证码错误");
        }

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            // 登录成功
            subject.login(token);
            log.info("登录成功：{}", userName);
            // 将用户角色、权限保存到session，为 shiro 授权做准备
            UserInfoVo userInfoVo = userInfoService.getByName(userName);
            ShiroUtils.setSessionAttribute(SessionConst.USER_INFO_SESSION, userInfoVo);
            // 返回之前请求路径
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String loginSuccessUrl = "/";
            /*if (null != savedRequest) {
                loginSuccessUrl = savedRequest.getRequestUrl();
            }*/
            return ResponseResult.success("登录成功", loginSuccessUrl);

        } catch (DisabledAccountException e) {
            return ResponseResult.error("账号或密码错误", userName);
        } catch (UnknownAccountException e) {
            return ResponseResult.error("用户未找到", userName);
        } catch (IncorrectCredentialsException e) {
            return ResponseResult.error("密码错误", userName);
        }
    }

    @ApiOperation("退出登录")
    @GetMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        ShiroUtils.removeSessionAttribute(SessionConst.USER_INFO_SESSION);
        return "admin/login";
    }

    @ApiOperation("生成验证码")
    @GetMapping("Captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        // 设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        // 不缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {

            HttpSession session = request.getSession();

            CaptchaUtils tool = new CaptchaUtils();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.genRandomCodeImage(code);
            session.removeAttribute(SessionConst.KEY_CAPTCHA);
            session.setAttribute(SessionConst.KEY_CAPTCHA, code.toString());

            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("403")
    @GetMapping("403")
    public String unauthorized(Model model) {
        model.addAttribute("code", 403);
        model.addAttribute("msg", "未授权");
        return "admin/error";
    }

    @ApiOperation("404")
    @GetMapping("404")
    public String notFound(Model model) {
        model.addAttribute("code", 404);
        model.addAttribute("msg", "找不到您访问的信息");
        return "admin/error";
    }
}
