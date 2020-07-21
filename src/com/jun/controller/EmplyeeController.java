package com.jun.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.dao.EmplyeeDao;
import com.jun.entity.Emplyee;

@Controller
public class EmplyeeController {
	@Autowired
	private EmplyeeDao emplyeeDao;
	
	//查询所有
	@RequestMapping(value = "findAll",method = RequestMethod.GET)
	public String findAll(ModelMap model) {
		ArrayList<Emplyee> empList = emplyeeDao.findAll();
		model.addAttribute("empList", empList);
		return "infoAll";
	}
	
	//按id查
	@RequestMapping(value = "findById/{id}",method = RequestMethod.GET)
	public String findById(ModelMap model,@PathVariable(name = "id") Integer id) {
		Emplyee emp = emplyeeDao.findById(id);
		model.addAttribute("id", emp.getId());
		model.addAttribute("empName", emp.getEmpName());
		model.addAttribute("age", emp.getAge());
		model.addAttribute("sex", emp.getSex());
		model.addAttribute("simple", emp.getSimple());
		model.addAttribute("face", emp.getFace());
		model.addAttribute("depId", emp.getDepId());
		return "findEmpId";
	}
	
	//按名字模糊查
	@RequestMapping(value = "findByName",method = RequestMethod.POST)
	public String findByName(ModelMap model,@RequestParam(name = "empName") String empName) {
		List<Emplyee> empList = emplyeeDao.findEmpByName(empName);
		model.addAttribute("empList", empList);
		return "infoAll";
	}
	
	//修改操作
	@RequestMapping(value = "updateEmp",method = RequestMethod.POST)
	public String updateEmp(Emplyee emp) {
		boolean flag = emplyeeDao.update(emp);
		if(flag) {			
			return "redirect:/findAll";
		}else {
			return "infoAll";
		}
	}
	
	//添加
	@RequestMapping(value = "addEmpInfo",method = RequestMethod.POST)
	public String addEmpInfo(Emplyee emp) {
		Integer flag = emplyeeDao.add(emp);
		if(flag>0) {
			return "redirect:/findAll";
		}
		return "infoAll";
	}
	
	//删除
	@RequestMapping(value = "deleteEmp",method = RequestMethod.GET)
	public String delete(@RequestParam(name = "id") Integer id) {
		boolean flag = emplyeeDao.delete(id);
		if(flag) {
			return "redirect:/findAll";
		}
		return "infoAll";
	}
	
}
