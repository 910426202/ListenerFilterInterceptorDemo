package org.blabla.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by panting1 on 2017/7/25.
 */
//@RestController 只返回字符串
@Controller
public class UserController {

    //在web.xml中配置了welcomfile后此处的根url映射无效
    @RequestMapping("/")
    public String index() {
        //重定向
        System.out.println("UserController index");
        return "home";
    }

    @RequestMapping("/query")
    public String query(){
        return "query";
    }
}
