package com.Flight_Reservation_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_Reservation_app.Entity.User;
import com.Flight_Reservation_app.Repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/showloginPage")
	public String showloginPage() {
		return "login/login";
	}

	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}

	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}

	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			ModelMap model) {
		User user = userRepo.findByEmail(emailId);
		if (user!= null) {
			
			if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
				return "findFlights"; //if user name or password is valid than return in findFlights 
			} else {
				model.addAttribute("error", "Invalid username/password");
				return "login/login";  //if not than show the error message 
			}
			
		  } else {
			model.addAttribute("error", "Invalid username/password");
			return "login/login";
		}

	}
}
