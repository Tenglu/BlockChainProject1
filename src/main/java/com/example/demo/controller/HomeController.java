package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.WorkOrderMapper;
import com.example.demo.model.WorkOrder;



@Controller
public class HomeController {
	@Autowired
	WorkOrderMapper workOrderMapper;


	
    @RequestMapping("/")
    public String index(Model model,HttpSession session){
     //   Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
     //   model.addAttribute("msg", msg);
    	
        return "index";
    }
}
