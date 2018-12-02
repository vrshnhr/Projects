package com.app.PackageController;

import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.pojos.Admin;
import com.app.myService.InterfaceService;
import com.mysql.fabric.Response;
import javax.servlet.http.*;

@Controller
@RequestMapping("/airline")
public class AirlineController {

	@Autowired
	@Qualifier("dao_based_service")
	private InterfaceService ser;

	public AirlineController() {
		System.out.println("in airline ctor");
	}

	@GetMapping("/login")
	public String showLoginFormAdmin() {
		System.out.println("in show login form");
		return "/airline/login"; // forward view : default
	}

	@PostMapping("/login")
	// req param name MUST match with method arg name
	public String processLoginFormAdmin(@RequestParam String email, @RequestParam String pass, Model map,
			HttpSession hs) {
		System.out.println("in process login form");
		Admin a = null;
		try {
			a = ser.ValidateAdmin(email, pass);

		} catch (NoResultException e) {
			System.out.println("err in controller " + e);
			map.addAttribute("status", "Invalid Login , pls retry");
			return "/airline/login";
		}
		hs.setAttribute("user_dtls", a);
		hs.setAttribute("status", "Successful Login ");
		return "redirect:/airline/details";
	}

}
