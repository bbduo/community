package com.cwru.platform.controller;

import com.cwru.platform.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String saveHello() {
        return "Hello Spring Boot.";
    }

    // Get 请求
    // students?current=1&limit=20

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name = "current", required = false, defaultValue = "1") int currrent,
            @RequestParam(name = "limit", required = false, defaultValue = "50") int limit
    ){
        System.out.println(currrent);
        System.out.println(limit);
        return "some students";
    }


    // Get 请求2
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @PathVariable("id") int id
    ){
        System.out.println(id);
        return "a student";
    }

    // Post 请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent (String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }


}
