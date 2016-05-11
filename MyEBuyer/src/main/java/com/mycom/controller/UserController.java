package com.mycom.controller;

import com.mycom.domain.User;
import com.mycom.formbean.UserForm;
import com.mycom.json.JsonResult;
import com.mycom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login2.json")
    @ResponseBody
    public Object crossDomainCheckUser(HttpServletRequest req, HttpServletResponse rep,
                                     @RequestParam(value = "username") String username,
                                     String password, String callback)throws Exception {
        User user = userService.login(username, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            return getCallBackResult(JsonResult.OK,callback);
        } else return getCallBackResult(JsonResult.FAIL.message("用户名或者密码不正确！"),callback);
    }

//    @RequestMapping(value = "/login2.json")
//    public void crossDomainCheckUser(HttpServletRequest req, HttpServletResponse rep,
//                           @RequestParam(value = "username") String username,
//                           String password, String callback)throws Exception {
//        String result = mapper.writeValueAsString(checkUser(req,username,password));
//        String finalResult = callback == null?result:callback+"("+result+")";
//        rep.setContentType("text/plain;charset=UTF-8");
//        rep.getWriter().print(finalResult);
//        rep.getWriter().flush();
//
//    }

    @RequestMapping(value = "/login.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkUser(HttpServletRequest req, @RequestParam(value = "username") String username,
                                String password) {
        User user = userService.login(username, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            return JsonResult.OK;
        } else return JsonResult.FAIL.message("用户名或者密码不正确！");

    }

    @RequestMapping(value = "/register.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult validateUserInfo(@ModelAttribute UserForm form,String verifycode, HttpServletRequest req) {
        if (checkIsExist(form.getName())) {
            return JsonResult.FAIL.message("该用户名已存在");
        } else if (!form.validate()) {
            return JsonResult.FAIL.message(form.getErrors());
        } else if (!verifycode.equalsIgnoreCase(getSessionInfo(req, "vCode").toString())) {
            return JsonResult.FAIL.message("验证码不正确");
        } else {
            User user = form.transToUser();
            userService.save(user);
            return JsonResult.OK.message("注册成功");
        }
    }

    @RequestMapping(value = "/checkName.json")
    @ResponseBody
    public boolean checkIsExist(String name) {
        return userService.checkName(name) != null;
    }
}
