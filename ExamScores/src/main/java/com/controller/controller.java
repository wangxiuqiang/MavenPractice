package com.controller;

import com.domain.Join;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wxq on 17-9-13.
 */
@Controller
public class controller {

    @RequestMapping(value = "/join_in")
    public String JoinIn (Model model , Join join){
        model.addAttribute("join" , join);
        return "index";

    }
}
