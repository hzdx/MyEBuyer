package com.mycom.controller;

import com.mycom.json.JSONPObject;
import com.mycom.json.JsonResult;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseController{
     private static Logger log = Logger.getLogger(BaseController.class);
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
        binder.registerCustomEditor(Date.class, dateEditor);
        // super.initBinder(request, binder);
    }

    protected Object getSessionInfo(HttpServletRequest request,String sessionKey){
        return request.getSession().getAttribute(sessionKey);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public JsonResult illegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        log.error("IllegalArgumentException => ", ex);
        return JsonResult.FAIL.message(ex.getMessage());
    }

    //将json对象转换为jsonp对象
    protected Object getCallBackResult(JsonResult result,String callback) {
        if(callback == null){
            return result;
        }else{
            return new JSONPObject(callback, result);
        }
    }
}
