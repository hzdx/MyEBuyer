package com.mycom.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.domain.User;
import com.mycom.formbean.UserForm;
import com.mycom.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {

  @Autowired
  private UserService userService;
  
  //private static Logger logger = Logger.getLogger(UserController.class); 
  @RequestMapping(value="/login")
  public ModelAndView Login(HttpServletRequest req,HttpServletResponse res) throws Exception{
      ModelAndView mv = new ModelAndView();
      String name = req.getParameter("username");      
      String psw = req.getParameter("password");
      
      User user = userService.login(name, psw);
      if(user==null){
          req.setAttribute("msg", "用户名或密码不正确！");
          req.getRequestDispatcher("/login.jsp").forward(req, res);
          return null;
      }else{
          mv.setViewName("/user/index");
          mv.addObject("user", user);
          return mv;
      }   
  }
  
  @RequestMapping(value="/register",method=RequestMethod.GET)
  public ModelAndView Register(){
      //logger.info("this is register controller!");
      ModelAndView mv = new ModelAndView();
      mv.setViewName("/user/register");
      return mv;
  }
  
  @RequestMapping(value="/reg")
  public ModelAndView Reg(@ModelAttribute UserForm form,HttpServletRequest req,HttpServletResponse res/*,MultipartFile pictureFile*/
      ) throws Exception {
      ModelAndView mv = new ModelAndView();
      if(!form.validate()){   
          mv.addObject("form", form);
          mv.addObject("errors", form.getErrors());
          mv.setViewName("/user/register");
          
      }else {
          if(userService.checkName(form.getName())!=null){
              mv.addObject("userExist", "该用户名已存在");
              mv.addObject("form", form);
              mv.addObject("errors", form.getErrors());
              mv.setViewName("/user/register");
              
          }else{
          User user = form.transToUser();
          userService.save(user);
          
          //上传头像部分
          /*String pictureFile_name =  pictureFile.getOriginalFilename();
          if(!(pictureFile_name==null || "".equals(pictureFile_name))){

          String newFileName = UUID.randomUUID().toString()+pictureFile_name.substring(pictureFile_name.lastIndexOf("."));

          File uploadPic = new java.io.File("D:/temp/pic/"+newFileName);
          
              if(!uploadPic.exists()){
                  uploadPic.mkdirs();
              }

              pictureFile.transferTo(uploadPic);
          }*/

          mv.setViewName("/user/regsuccess");
          
      }}
      return mv;
  }
}
