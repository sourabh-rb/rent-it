/**
 * 
 */
package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rentit.model.Login;

/**
 * @author kotic
 *
 */
@Controller
public class LoginController {
  @RequestMapping(value="/LoginPage",method=RequestMethod.GET)
  public String getLoginForm() {
   return "LoginPage"; 
  }
  @RequestMapping(value="/LoginPage",method=RequestMethod.POST)
 public String LoginPage(@ModelAttribute(name="${loginForm}") Login loginForm,Model model) {
    String username=loginForm.getUsername();
    String password=loginForm.getPassword();
    Login l = new Login();
    if(l.checkPassword(username, password)) {
    	return "redirect:/vehicle";
    }else {
    	model.addAttribute("Invalid Credentials", true);
    	return "redirect:/LoginPage";
    }
//    if("admin".equals(username) && "admin".equals(password)) {
//      return "redirect:/vehicle";
    }

 
   
 
}
