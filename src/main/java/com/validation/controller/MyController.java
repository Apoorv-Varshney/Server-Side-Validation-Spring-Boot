package com.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validation.entity.User;

@Controller
public class MyController {

	@GetMapping("/form")
	public String formHandler(Model m) {
		m.addAttribute("userData", new User());
		System.out.println("form opened...");
		return "form";
	}

	@PostMapping("/submit")
	public String submitHandler(@Valid @ModelAttribute("userData") User userData, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println(userData);
		return "submit";
	}

}
