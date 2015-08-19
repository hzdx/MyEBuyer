package com.mycom.formbean;

import java.util.HashMap;
import java.util.Map;

import com.mycom.domain.User;

public class UserForm extends User {
  private String repsw;
  private Map errors = new HashMap();
  
  public String getRepsw() {
      return repsw;
  }
  public void setRepsw(String repsw) {
      this.repsw = repsw;
  }
  
  public Map getErrors() {
      return errors;
  }
  public void setErrors(Map errors) {
      this.errors = errors;
  }
  public UserForm(){}
  public User transToUser(){
      User user = new User();
      user.setId(this.getId());
      user.setName(this.getName());
      user.setPassword(this.getPassword());
      user.setBirthday(this.getBirthday());
      return user;
  }
  
  public boolean validate(){
      boolean isOK = true;
      if(this.getName()==null || this.getName().trim().equals("")){
              isOK = false;
              errors.put("name", "用户名不能为空");
          }else{
              if(!this.getName().matches("[A-Za-z]{3,8}")){
                  isOK = false;
                  errors.put("name", "用户名必须是3-8位");
              }
          }
          
          if(this.getPassword()==null || this.getPassword().trim().equals("")){
              isOK = false;
              errors.put("password", "密码不能为空");
          }else{
              if(!this.getPassword().matches("\\d{3,8}")){
                  isOK = false;
                  errors.put("password", "密码必须是3-8位数字");
              }
          }
          
          if(this.getRepsw()==null || this.getRepsw().trim().equals("")){
              isOK = false;
              errors.put("password2", "确认密码不能为空");
          }else{
              if(!(this.getPassword().equals(getRepsw()))){
                  isOK = false;
                  errors.put("password2", "两次密码必须一致");
              }
          }
          
          /*if(this.email==null || this.email.trim().equals("")){
              isOK = false;
              errors.put("email", "邮箱不能为空");
          }else{
              if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
                  isOK = false;
                  errors.put("email", "邮箱格式不对");
              }
          }
          
          if(this.birthday != null && !this.birthday.trim().equals("")){
              try {
                  DateLocaleConverter dlc = new DateLocaleConverter();
                  dlc.convert(this.birthday, "yyyy-MM-dd");
              } catch (Exception e) {
                  isOK = false;
                  errors.put("birthday", "生日格式不正确");
              }
                  
              
          }
          
          if(this.nickname==null || this.nickname.trim().equals("")){
              isOK = false;
              errors.put("nickname", "昵称不能为空");
          }*//*else{
              if(!this.nickname.matches("^([\u4e00-\u9fa5]+)$")){
                  isOK = false;
                  errors.put("nickname", "昵称必须是汉字");
              }
          }*/
          
          return isOK;
      }
  }


