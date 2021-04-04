package cn.tellsea.frame.handle;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Slf4j
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandle {

    @ExceptionHandler(value = AuthorizationException.class)
    public String authorizationException(AuthorizationException e, Model model) {
        model.addAttribute("code", 403);
        model.addAttribute("msg", "您没有权限访问，请联系管理员");
        log.error("【未授权】{}", e.getMessage());
        return "admin/error";
    }

    @ExceptionHandler(value = SpelEvaluationException.class)
    public String spelEvaluationException(SpelEvaluationException e, Model model) {
        model.addAttribute("code", 500);
        model.addAttribute("msg", "【模板解析错误】" + e.getMessage());
        log.error("【模板解析错误】{}", e.getMessage());
        return "admin/error";
    }
}
