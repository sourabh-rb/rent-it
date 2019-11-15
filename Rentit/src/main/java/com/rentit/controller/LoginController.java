/**
 * 
 */

package com.rentit.controller;

import com.rentit.model.Clerks;
import com.rentit.model.ClerksDataMapper;
import com.rentit.model.Login;
import com.rentit.test_class.EncryptPassword;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class renders login page.
 * 
 * @author kotic
 */
@Controller
public class LoginController {
  static int count =0;
  static int acount =0;
  static int vcount =0;

  /**
   * This method renders login page.
   * 
   * @return
   */
  @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
  public String getLoginForm() {
    return "loginpage";
  }

  /**
   * This method validated.
   * 
   * @param loginForm Get username and password from Login
   * @param model Model class
   * @return
   * @throws Exception
   */

  @RequestMapping(value = "/loginpage", method = RequestMethod.POST)

  public String loginpage(@ModelAttribute(name = "${loginForm}") Login loginForm, Model model,HttpSession session)
      throws Exception {
    EncryptPassword ep = new EncryptPassword();
    ClerksDataMapper cdm = new ClerksDataMapper();
    String usergroup = null ;
   String  username = loginForm.getUsername();
    session.setAttribute("sessionusername", username);
    String password = loginForm.getPassword();
    boolean flag = false;
    ArrayList<Clerks> clerks = new ArrayList<>();
    clerks = cdm.getClerkData();
    
    for (int i = 0; i < clerks.size(); i++) {
      if (username.equals(clerks.get(i).getUsername())) {
        String decryptpass = ep.decrypt(clerks.get(i).getPassword());
        if (password.equals(decryptpass)) {
          usergroup = clerks.get(i).getusergroup();
          session.setAttribute("sessionusergroup", usergroup);
          flag = true;
          if("admin".equalsIgnoreCase(usergroup)) {
            if(!ClerksDataMapper.getAdminLogin()) {
            ClerksDataMapper.setAdminLogin();
            return "redirect:/admin";
            }
            else {
              model.addAttribute("oneadmin", true);
              return "loginpage";
            }
          }
          else {
            ClerksDataMapper.resetAdminLogin();
          break;
        }
      }
    }
    }
    if (flag == false) {
      model.addAttribute("InvalidCredentials", true);
      return "loginpage";
    } 
    
      
        return "redirect:/vehicle";
     
     
      
    
    }
  
}
