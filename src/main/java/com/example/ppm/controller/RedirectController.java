package com.example.ppm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

	@GetMapping("/admin_home")
	public String redirectadmin()
	{
		return "admin_home";
	}
	@GetMapping("/manager_home")
	public String redirectmanager()
	{
		return "manager_home";
	}
	@GetMapping("/employee_home")
	public String redirectemployee()
	{
		return "employee_home";
	}
}
