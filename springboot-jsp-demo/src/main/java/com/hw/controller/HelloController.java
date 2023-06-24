package com.hw.controller;

import com.hw.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/stu")
@Controller
public class HelloController {

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(required = false, value = "id") String id ){
        List<Student> list = new ArrayList<>();
        if("1".equals(id)){
            list.add(new Student("2", "lisi", 20, "大二"));
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            modelAndView.addObject("list", list);
            return modelAndView;
        }else if("2".equals(id)){
            list.add(new Student("1", "zhangsan", 18, "大一"));
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            modelAndView.addObject("list", list);
            return modelAndView;
        }
        list.add(new Student("1", "zhangsan", 18, "大一"));
        list.add(new Student("2", "lisi", 20, "大二"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") String id){
        if("1".equals(id)){
            return "redirect:/stu/index?id=1";
        }
        return "redirect:/stu/index?id=2";
    }

}
