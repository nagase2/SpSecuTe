package com.concretepage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.concretepage.config.AppConfig;
import com.concretepage.service.IUserService;
import com.concretepage.service.UserService2;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class SpringSecurityTest2 {
	@Autowired
	public UserService2 userService2;
	@Autowired
	public UserDetailsService userDetailsService;
	
	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void testOne() {
		userService2.methodOne();
	}
	
	@Test
	@WithMockUser(roles={"ADMIN"})
	public void testTwo() {
		userService2.methodTwo("This is Admin");
	}
	@Test
	@WithMockUser(username = "ravan")
	public void testThree() {
		User user = new User();
		user.setUserName("ravan");
		userService2.methodThree(user);
	}
	@Test
	@WithUserDetails("ram") 
	public void testFour() {
		userService2.methodFour();
	}
}
