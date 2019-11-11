/**
 * 
 */

package com.rentit.controller;

import com.rentit.model.Clerks;
//import com.rentit.model.ClerksDataMapper;
import com.rentit.model.Login;
import com.rentit.test_class.EncryptPassword;
import com.rentit.test_class.TestClass;
import java.util.ArrayList;
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
  static String username;
  static String usergroup;

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

  public String loginpage(@ModelAttribute(name = "${loginForm}") Login loginForm, Model model)
      throws Exception {
    EncryptPassword ep = new EncryptPassword();
    //ClerksDataMapper cdm = new ClerksDataMapper();
    username = loginForm.getUsername();
    String password = loginForm.getPassword();
    boolean flag = false;
    // TestClass tc = new TestClass();
    ArrayList<Clerks> clerks = new ArrayList<>();
    // clerks = (ArrayList<Clerks>) tc.getClerksTestData();

    //clerks = cdm.getClerkData();
    for (int i = 0; i < clerks.size(); i++) {
      if (username.equals(clerks.get(i).getUsername())) {
        String decryptpass = ep.decrypt(clerks.get(i).getPassword());
        if (password.equals(decryptpass)) {
          usergroup = clerks.get(i).getusergroup();
          flag = true;
          break;
        }
      }
    }
    if (flag == false) {
      model.addAttribute("InvalidCredentials", true);
      return "loginpage";
    } else {
      if (usergroup.equals("clerk")) {
        return "redirect:/vehicle";
      } else {
        return "redirect:/admin";

      }
    }
  }
}
