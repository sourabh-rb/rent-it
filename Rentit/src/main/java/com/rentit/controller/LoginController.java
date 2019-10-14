/**
 * 
 */
package com.rentit.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rentit.model.Clerks;
import com.rentit.model.Login;
import com.rentit.test_class.TestClass;

/**
 * @author kotic
 *
 */
@Controller
public class LoginController {
	static String username;
  @RequestMapping(value="/loginpage",method=RequestMethod.GET)
  public String getLoginForm() {
   return "loginpage"; 
  }
  @RequestMapping(value="/loginpage",method=RequestMethod.POST)
  public String LoginPage(@ModelAttribute(name="${loginForm}") Login loginForm,Model model) {
	  String usergroup = "";
     username=loginForm.getUsername();
    String password=loginForm.getPassword();
    boolean flag = false;
    TestClass Tc=new TestClass();
    ArrayList<Clerks>clerks=new ArrayList<>();
    clerks=(ArrayList<Clerks>) Tc.getClerksTestData();
    for(int i=0;i<clerks.size();i++) {
      Clerks clerk = clerks.get(i);
      if(username.equals(clerk.getUsername())) {
        if(password.equals(clerk.getPassword())) {
        	usergroup = clerk.getusergroup();
        flag = true;
        break;
      }
        
    }
      flag = false;
    }
    if(flag == false){
    	model.addAttribute("InvalidCredentials", true);
    	return "loginpage";
    }
    else {
    	if(usergroup == "clerk")
      return "redirect:/vehicle";
    	else {
    		return "redirect:bookingForm";
    	}
    }
 }
}
