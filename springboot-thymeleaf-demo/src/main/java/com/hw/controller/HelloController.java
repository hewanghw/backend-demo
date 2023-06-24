package com.hw.controller;

import com.hw.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/stu")
@Controller
public class HelloController {

    @GetMapping("/index")
    public String index(Model model){
        List<Student> list = new ArrayList<>();
        list.add(new Student("1", "zhangsan", 18, "大一"));
        list.add(new Student("2", "lisi", 20, "大二"));
        model.addAttribute("list", list);
        return "index";
    }


}
