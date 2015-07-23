package com.concretepage.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.concretepage.User;

@Service
public class UserService2 {
  
  //@Secured("authenticated")
  public void methodOne(){
    System.out.println("OK!");
  };
  
  @PreAuthorize("hasRole('ADMIN')")
  public void methodTwo(String msg){
    System.out.println("OK!");
  }
  
  @PreAuthorize ("#user.userName == authentication.name")
  public void methodThree(User user){
    System.out.println("OK!");
  }

  @PostAuthorize ("returnObject.userName == authentication.name")
  public User methodFour(){
    System.out.println("OK!");
    User user = new User();
    user.setUserName("ram");
    return user;
  }
}
