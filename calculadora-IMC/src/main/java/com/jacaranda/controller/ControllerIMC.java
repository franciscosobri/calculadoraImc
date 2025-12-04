package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerIMC {

	@GetMapping("/imc")
	public String inicio() {
		return "imc";
	}
	
	@PostMapping("/calculo")
		public String calculo(
				@RequestParam("peso") double peso,
				@RequestParam("edad") int edad,
				@RequestParam("sexo") String sexo,
				@RequestParam("altura") double altura, 
				Model model) {
		
		double imc = peso * (altura * altura);
		
		String categoria;
		if (imc < 17.5) {
			categoria = "Bajo peso";
		}
		else if (imc >= 17.5 && imc <= 26.9) {
			categoria = "NormoPeso";
		}
		else if(imc >= 26 && imc <=32.9) {
			categoria = "Sobrepeso";
		}
		else {
			categoria = "Obesidad";
		}
		
		model.addAttribute("peso", peso);
		model.addAttribute("edad", edad);
		model.addAttribute("sexo", sexo);
		model.addAttribute("altura", altura);
		model.addAttribute("imc", imc);
		model.addAttribute("categoria", categoria);
		
		
		return "imc";
	}
		
	
	
}