package life.echo.community.advice;

import life.echo.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangzewen on 2020/1/30
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model,
                        HttpServletRequest request) {
//        HttpStatus status = getStatus(request);
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            //返回json
        } else {
            //错误页面跳转
            if (e instanceof CustomizeException) {
                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message", "请稍后再试 ..");
            }
            return new ModelAndView("error");
        }

    }



//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return HttpStatus.valueOf(statusCode);
//    }
}
