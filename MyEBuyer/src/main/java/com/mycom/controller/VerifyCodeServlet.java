package com.mycom.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.verifycode.VerifyCode;



@Controller
public class VerifyCodeServlet {

  @RequestMapping("/verifycode")
  public void generateVerifyCode(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    VerifyCode vc = new VerifyCode();
    BufferedImage image = vc.getImage();// 获取一次性验证码图片

    //response.setHeader("",);
    // 把文本保存到session中，为LoginServlet验证做准备
    request.getSession().setAttribute("vCode", vc.getText());
    VerifyCode.output(image, response.getOutputStream());// 把图片写到指定流中

  }

}
