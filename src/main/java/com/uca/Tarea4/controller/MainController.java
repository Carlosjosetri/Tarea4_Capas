package com.uca.Tarea4.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.Tarea4.domain.Producto;
import com.uca.Tarea4.domain.Student;

@Controller
public class MainController {
   
	
	private List<Student> students = new ArrayList<Student>();
	
	
	
	
	@GetMapping(path = "/ejemplo1" , produces= MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String ejemplo1() {
		return "bienvenido\n"+"programacion N Capas";
    	
    }
	@GetMapping("/ejemplo2")

    public @ResponseBody List<Student> ejemplo2() {
		return Arrays.asList(
	(new Student("Nombre1","Apellido1","carrera1","10/10/2020",true)),
	(new Student("Nombre2","Apellido2","carrera2","10/10/2020",false))
				)
				;
    	
    }
	
	@GetMapping("/inicio" )
     public String inicio(Student student) {
		return "index";
    	
    }
	
	@PostMapping("/formData")
	public ModelAndView procesar(Student student){
		students.add(student);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
	
		mav.addObject("student", new Student());
		
		return mav;
	}
	
	@GetMapping("/ListStudents")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ListStudents");
		mav.addObject("Studentlist", this.students);
		return mav;
		
		
	}
	
	@RequestMapping("/producto")
	public ModelAndView initMain() {
		Producto producto = new Producto();
		ModelAndView mav = new ModelAndView();
		mav.addObject("producto", producto);
		mav.setViewName("producto");
		return mav;
	}
	
	@RequestMapping("/formProducto")
	public ModelAndView formProducto(@Valid @ModelAttribute Producto producto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		String msg = "Producto " + producto.getNombre() + " guardado con éxito.";
		
		if(result.hasErrors()) {
			mav.setViewName("producto");
		} else {
			mav.addObject("msg", msg);
			mav.setViewName("exito");
		}
		return mav;
	}
	
	
	
	
}
