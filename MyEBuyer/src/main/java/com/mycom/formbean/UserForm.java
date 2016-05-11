package com.mycom.formbean;

import com.mycom.domain.User;

public class UserForm extends User {
    private String repsw;
    private String errors;

    public String getRepsw() {
        return repsw;
    }

    public void setRepsw(String repsw) {
        this.repsw = repsw;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public UserForm() {
    }

    public User transToUser() {
        User user = new User();
        user.setId(this.getId());
        user.setName(this.getName());
        user.setPassword(this.getPassword());
        user.setBirthday(this.getBirthday());
        user.setPhone(this.getPhone());
        return user;
    }

    public boolean validate() {
        if (this.getName() == null || this.getName().trim().equals("")) {
            errors = "用户名不能为空";
            return false;
        } else if (this.getPassword() == null || this.getPassword().length() > 16 || this.getPassword().length() < 6) {
            errors = "密码长度不正确";
            return false;
        } else if (!this.getRepsw().equals(this.getPassword())) {
            errors = "两次密码必须一样";
            return false;
        } else if (this.getPhone() == null || !this.getPhone().matches("^1[358][0-9]{9}$")) {
            errors = "手机格式不正确";
            return false;
        }

        return true;

    /*
     * if(this.email==null || this.email.trim().equals("")){ isOK = false; errors.put("email",
     * "邮箱不能为空"); }else{ if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){ isOK = false;
     * errors.put("email", "邮箱格式不对"); } }
     * 
     * if(this.birthday != null && !this.birthday.trim().equals("")){ try { DateLocaleConverter dlc
     * = new DateLocaleConverter(); dlc.convert(this.birthday, "yyyy-MM-dd"); } catch (Exception e)
     * { isOK = false; errors.put("birthday", "生日格式不正确"); }
     * 
     * 
     * }
     * 
     * if(this.nickname==null || this.nickname.trim().equals("")){ isOK = false;
     * errors.put("nickname", "昵称不能为空"); }
     *//*
        * else{ if(!this.nickname.matches("^([\u4e00-\u9fa5]+)$")){ isOK = false;
        * errors.put("nickname", "昵称必须是汉字"); } }
        */

    }
}
