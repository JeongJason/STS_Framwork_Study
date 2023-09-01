package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InfoDTO;
import com.example.ex02.domain.vo.StudentVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex/*")
@Log4j
public class SampleController {
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET,RequestMethod.POST})
	public void basic(HttpServletRequest req) {
		log.info("basic...." + req.getMethod());
	}
	
	@RequestMapping
	public void basic2() {
		log.info("basic2................");
	}
	
	@GetMapping("/basicOnlyGet")
	public void vasic3() {
		log.info("basic3.....only get");
	}
	
	@GetMapping("/ex01")
	public void ex01(InfoDTO infoDTO) {
		log.info("ex01....." + infoDTO.getName() + "," + infoDTO.getAge());
	}
	
	@GetMapping("/ex02")
	public void ex02(@RequestParam("data1")String name, @RequestParam("data2")int age) {
		log.info("ex02...." + name + "," + age);
	}
	
	@GetMapping("/ex03")
		public String ex03(@RequestParam("data") ArrayList<String> datas) {
			log.info("datas : " + datas);
			return "ex03";
		}
	
	
	@GetMapping("/ex04")
	public String ex04(@ModelAttribute("dto") InfoDTO infoDTO) {
		log.info("---------------------");
		log.info("ex04............");
		log.info(infoDTO.toString());
		log.info("---------------------");
		
		return "ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05(InfoDTO infoDTO, @ModelAttribute("gender") String gender) {
		log.info("ex05.........");
		log.info(infoDTO.toString());
		log.info("gender: " + gender);
	}
	
	@GetMapping("/ex06")
	public String ex06(InfoDTO infoDTO, String gender, Model model){
		log.info("ex06.........");
		log.info(infoDTO.toString());
		log.info("gender: " + gender);
		
		model.addAttribute("dto",infoDTO);
		model.addAttribute("gender",gender);
		
		return "ex/ex06";
	}
	
	@GetMapping("/ex07")
	public String ex07(StudentVO studentVo) {
		log.info("ex07................");
		log.info(studentVo.toString());
		return "ex/ex07";
	}
	
}
