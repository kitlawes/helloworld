package com.tutorialspoint.test;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {
   private static final long serialVersionUID = 1L;
   private Date createTime = new Date();
   private String message = "Hello World!";

   public Date getCreateTime() {
      return(createTime);
   }
   
   public String getMessage() {
      return(message);
   }
}