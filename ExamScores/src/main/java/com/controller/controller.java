package com.controller;

import com.domain.Join;
import com.domain.student;
import com.domain.teacher;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

/**
 * Created by wxq on 17-9-13.
 */
@Controller
public class controller {

    @RequestMapping(value = "/join_in")
    public String JoinIn(Model model, Join join) {
        model.addAttribute("join", join);
        return "index";

    }

    @RequestMapping(value = "/success_in")
    public String AdminIn(Model model, Join join) {
        if (join.getName().equals("admin") && join.getPasswd().equals("admin")) {
            return "adminIN";
        } else {
            return "failure";
        }
    }

    /*
    用来添加学生老师的信息
    flag 代表是老师还是学生,1 是老师 ,0 代表学生
     */
    @RequestMapping(value="/add_information/{flag}")
    public String addInformation(student student, teacher teacher , Model model , ServletRequest request, @PathVariable int flag){
        if(flag == 1) {
            model.addAttribute("teacher" , teacher);
            request.setAttribute("flag" ,flag);
            return "addInformation";
        }
       else if(flag == 0) {
            model.addAttribute("student",student);
            request.setAttribute("flag" ,flag);
            return "addInformation";
        }
        else{
            return "failure";
        }
    }


}
