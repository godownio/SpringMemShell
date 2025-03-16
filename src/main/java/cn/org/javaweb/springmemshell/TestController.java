package cn.org.javaweb.springmemshell;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
//        WebApplicationContext context1 = ContextLoader.getCurrentWebApplicationContext();
        HttpServletRequest servletRequest =  ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        WebApplicationContext context2 = RequestContextUtils.findWebApplicationContext(servletRequest);
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        WebApplicationContext context = (WebApplicationContext)RequestContextHolder.currentRequestAttributes().getAttribute("org.springframework.web.servlet.DispatcherServlet.CONTEXT", 0);
        return "index";
    }
}