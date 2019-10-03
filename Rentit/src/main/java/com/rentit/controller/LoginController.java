/**
 * 
 */
package com.rentit.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.rentit.form.LoginForm;

/**
 * @author kotic
 *
 */
public class LoginController {
  @RequestMapping(value="/LoginPage",method=RequestMethod.GET)
  public String getLoginForm() {
   return "LoginPage"; 
  }
  @RequestMapping(value="/LoginPage",method=RequestMethod.POST)
 public String LoginPage(@ModelAttribute(name="loginForm") LoginForm loginForm,Model model) {
    String username=loginForm.getUsername();
    String password=loginForm.getPassword();
    if("admin".equals(username) && "admin".equals(password)) {
      return "vehicle";
    }
    model.addAttribute("Invalid Credentials", true);
    return "LoginPage";
 
   
 }
}
