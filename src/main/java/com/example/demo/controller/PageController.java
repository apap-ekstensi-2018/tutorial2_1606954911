package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	/*//@RequestMapping("/hello/greeting")
	@RequestMapping("/greeting")
	//public String greeting (@RequestParam(value = "name") String name, Model model) {
	//public String greeting (@RequestParam(value = "name", required = false) String name, Model model) {
	public String greeting (@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}*/
	
	//@RequestMapping("greeting/{name}")
	@RequestMapping(value = {"/greeting","greeting/{name}"})
	//public String greetingPath (@PathVariable String name, Model model) {
	public String greetingPath (@PathVariable Optional<String> name, Model model) {
		//model.addAttribute("name", name);
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "apap");
		}
		return "greeting";
	}
}
