package com.infosys.exercise_spring_mvcdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infosys.exercise_spring_mvcdb.entity.Student;
import com.infosys.exercise_spring_mvcdb.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService student;
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
	@RequestMapping("/new-student-form")
	public String newStudentForm() {
		return "newStudentForm";
	}
	
	@RequestMapping("/update-student-form")
	public String updateStudentForm() {
		return "updateStudentForm";
	}
	
	@RequestMapping("/delete-student-form")
	public String deleteStudentForm() {
		return "deleteStudentForm";
	}
	
	@RequestMapping(path="/save-student" , method = RequestMethod.POST)
	public String addStudent(@ModelAttribute Student std, Model model) {
		Student savedStd = student.addStudent(std);
		model.addAttribute("student", savedStd.getSname());
		return "successAdd";
	}
	
	@RequestMapping("/get-all")
	public String showStudents(Model model) {
		List<Student> students = student.getAllStudents();
		model.addAttribute("students", students);
		return "successList";
	}
	
	@RequestMapping("/{id}")
	public String getById(@PathVariable("id") Integer id, Model model) {
		Student stdById = student.getById(id);
		model.addAttribute("name", stdById.getSname());
		model.addAttribute("regno", stdById.getRegno());
		model.addAttribute("subject", stdById.getSubject());
		model.addAttribute("marks", stdById.getMarks());
		return "successStudent";
	}
	
	@RequestMapping(path="/update-student", method = RequestMethod.POST)
	public String updateById(@ModelAttribute Student std, Model model) {
		student.updateStudent(std.getMarks(), std.getRegno());
		model.addAttribute("student", std.getRegno());
		return "successUpdate";
	}	
	
	@RequestMapping(path="/delete-student", method = RequestMethod.POST)
	public String deleteStudent(@ModelAttribute Student std, Model model) {
		student.deleteById(std.getRegno());
		model.addAttribute("student", std.getRegno());
		return "successDelete";
	}
	
}
